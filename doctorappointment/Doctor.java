package doctorappointment;

import java.sql.Time;

public class Doctor extends User implements DoctorInterface{
    public Speciality speciality;
    SlotsManager slotsManager;

    @Override
    public String toString() {
        return "Doctor{" +
                "speciality=" + speciality +
                ", slotsManager=" + slotsManager +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    Doctor(int id, String name, Speciality speciality)
    {
        super(id,name);
        this.speciality = speciality;
        slotsManager = SlotsManager.getInstance();
    }
    @Override
    public void markAvailableForSlot(Integer startTime) {
        slotsManager.markAvailable(this, startTime);
    }
}
