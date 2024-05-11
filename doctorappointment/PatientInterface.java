package doctorappointment;

import java.sql.Time;

public interface PatientInterface {
    public Appointment bookAppointment(Speciality speciality, Integer slotStartTime);
    public Appointment cancelAppointment(Appointment appointment);
}
