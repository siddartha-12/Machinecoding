package doctorappointment;

import java.sql.Time;

public class Patient extends User implements PatientInterface{
    private SlotsManager slotsManager;
    Patient(int id, String name) {
        super(id, name);
        slotsManager = SlotsManager.getInstance();
    }

    @Override
    public String toString() {
        return "Patient{" +
                "slotsManager=" + slotsManager +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public Appointment bookAppointment(Speciality speciality, Integer slotStartTime) {
        Appointment appointment = slotsManager.bookAppointment(this,slotStartTime, speciality);
        return appointment;
    }

    @Override
    public Appointment cancelAppointment(Appointment appointment) {
        return slotsManager.cancelAppointment(appointment);
    }
}
