package doctorappointment;

import java.sql.Time;

public class AppointmentRequest {
    public AppointmentRequest(User user, Speciality requestedSpeciality,Integer slotStartTime) {
        this.user = user;
        this.slotStartTime = slotStartTime;
        this.requestedSpeciality = requestedSpeciality;
    }

    private User user;

    public Integer getSlotStartTime() {
        return slotStartTime;
    }

    public User getUser() {
        return user;
    }

    public Speciality getRequestedSpeciality() {
        return requestedSpeciality;
    }

    private Integer slotStartTime;
    private Speciality requestedSpeciality;

}
