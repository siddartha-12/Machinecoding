package doctorappointment;

public interface SlotInterface {
    public void markAvailableForSlot(Doctor doctor);
    public void showAvailableDoctorsForSpeciality(Speciality speciality);
    public Appointment confirmAppointment(AppointmentRequest appointmentRequest, int appointmentId);
}
