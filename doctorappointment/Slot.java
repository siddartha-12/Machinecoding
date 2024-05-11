package doctorappointment;

import java.sql.Time;
import java.util.*;

public class Slot implements SlotInterface {
    private Integer startTime;
    private Integer endTime;
    private Set<Speciality> availableSpecialities;
    private Map<Speciality, List<Doctor>> specialityDoctorMapping;
    private Map<Speciality, Queue<Appointment>> waitingListForSpeciality;
    Slot(Integer startTime, Integer endTime)
    {
        this.endTime = endTime;
        this.startTime = startTime;
        availableSpecialities  = new HashSet<>();
        specialityDoctorMapping = new HashMap<>();
        waitingListForSpeciality = new HashMap<>();
    }

    @Override
    public void markAvailableForSlot(Doctor doctor) {
        if(!availableSpecialities.contains(doctor.speciality))
        {
            availableSpecialities.add(doctor.speciality);
            specialityDoctorMapping.put(doctor.speciality,new ArrayList<>());
        }
        specialityDoctorMapping.get(doctor.speciality).add(doctor);
        bookWaitingAppointmentRequestsIfPresent(doctor.speciality);
    }

    @Override
    public void showAvailableDoctorsForSpeciality(Speciality speciality) {
        boolean isDoctorsAvailable = false;
        if(availableSpecialities.contains(speciality))
        {
            for(Doctor doctor:specialityDoctorMapping.get(speciality))
            {
                isDoctorsAvailable = true;
                System.out.println(doctor.name+" "+doctor.id);
            }
        }
        if(!isDoctorsAvailable)
        {
            System.out.println("No doctors available for "+speciality.toString());
        }
    }

    @Override
    public Appointment confirmAppointment(AppointmentRequest appointmentRequest, int appointmentId) {
        Appointment appointment = new Appointment.AppointmentBuilder()
                .setId(appointmentId)
                .setEndTime(this.endTime)
                .setStartTime(startTime)
                .setUser(appointmentRequest.getUser())
                .setAppointmentStatus(AppointmentStatus.Waiting)
                .build();

        if(availableSpecialities.contains(appointmentRequest.getRequestedSpeciality()))
        {
            if(specialityDoctorMapping.get(appointmentRequest.getRequestedSpeciality()).size()>0)
            {
                Doctor doctor = specialityDoctorMapping.get(appointmentRequest.getRequestedSpeciality()).remove(0);
                appointment.setDoctor(doctor);
                appointment.setAppointmentStatus(AppointmentStatus.Booked);
                return appointment;
            }
            else {
                System.out.println("No doctor available in this slot with "+appointmentRequest.getRequestedSpeciality().toString());
                addToWaitingList(appointment, appointmentRequest.getRequestedSpeciality());
            }
        }
        else {
            System.out.println("Requested speciality is not available in this slot");
            addToWaitingList(appointment, appointmentRequest.getRequestedSpeciality());
        }
        return appointment;
    }

    private void bookWaitingAppointmentRequestsIfPresent(Speciality speciality)
    {

        if(waitingListForSpeciality.containsKey(speciality)) {
            if(waitingListForSpeciality.get(speciality).size()>0) {
                if(specialityDoctorMapping.get(speciality).size() > 0) {
                        Doctor doctor = specialityDoctorMapping.get(speciality).remove(0);
                        Appointment appointment = waitingListForSpeciality.get(speciality).poll();
                        appointment.setDoctor(doctor);
                        appointment.setAppointmentStatus(AppointmentStatus.Booked);
                }
            }
        }
    }
    private void addToWaitingList(Appointment appointment,Speciality speciality)
    {
        System.out.println("Adding to the waiting list");
        if(!waitingListForSpeciality.containsKey(speciality))
        {
            waitingListForSpeciality.put(speciality,new LinkedList<>());
        }
        waitingListForSpeciality.get(speciality).add(appointment);
    }

    public Appointment cancelAppointment(Appointment appointment)
    {
        Doctor doctor = appointment.getDoctor();
        appointment.setAppointmentStatus(AppointmentStatus.Canceled);
        if(doctor == null)
            return appointment;
        specialityDoctorMapping.get(doctor.speciality).add(doctor);
        bookWaitingAppointmentRequestsIfPresent(doctor.speciality);
        return appointment;
    }
}
