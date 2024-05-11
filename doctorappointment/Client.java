package doctorappointment;

public class Client {
    public static void main(String[] args) {
        Patient patient = new Patient(1,"siddhu");
        Patient patient1 =new Patient(2, "Sashank");
        Doctor doctor = new Doctor(1,"Paul",Speciality.Cardiologist);
        Doctor doctor2 = new Doctor(1,"Paul2",Speciality.Cardiologist);
        doctor.markAvailableForSlot(1);
        doctor2.markAvailableForSlot(1);
        Appointment appointment = patient.bookAppointment(Speciality.Cardiologist,1);
        System.out.println(appointment);
        SlotsManager slotsManager = SlotsManager.getInstance();
        slotsManager.showAvailableDoctorsForSlotWithSpeciality(Speciality.Cardiologist, 1);
        slotsManager.showAppointmentsWithStatus(AppointmentStatus.Booked);

    }
}
