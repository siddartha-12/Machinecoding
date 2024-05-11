package doctorappointment;

import java.sql.Time;

public class Appointment {

    public Appointment(AppointmentBuilder appointmentBuilder) {
        this.Id = appointmentBuilder.Id;
        this.endTime = appointmentBuilder.endTime;
        this.startTime = appointmentBuilder.endTime;
        this.user =appointmentBuilder.user;
        this.doctor = appointmentBuilder.doctor;
        this.appointmentStatus = appointmentBuilder.appointmentStatus;
    }

    public int getId() {
        return Id;
    }

    private int Id;
    private Integer startTime;
    private Integer endTime;
    private User user;
    private Doctor doctor;

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    private AppointmentStatus appointmentStatus;

    @Override
    public String toString() {
        return "Appointment{" +
                "Id=" + Id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", user=" + user +
                ", doctor=" + doctor +
                ", appointmentStatus=" + appointmentStatus +
                '}';
    }

    public void setId(int id) {
        Id = id;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public User getUser() {
        return user;
    }

    public Integer getEndTime() {
        return endTime;
    }

    public Integer getStartTime() {
        return startTime;
    }

    public static class AppointmentBuilder{
        private int startTime;

        public AppointmentBuilder setEndTime(Integer endTime) {
            this.endTime = endTime;
            return this;
        }

        public AppointmentBuilder setStartTime(Integer startTime) {
            this.startTime = startTime;
            return this;
        }

        public AppointmentBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public AppointmentBuilder setDoctor(Doctor doctor) {
            this.doctor = doctor;
            return this;
        }

        private Integer endTime;
        private User user;
        private Doctor doctor;

        public AppointmentBuilder setId(int id) {
            Id = id;
            return this;
        }

        private int Id;

        public AppointmentBuilder setAppointmentStatus(AppointmentStatus appointmentStatus) {
            this.appointmentStatus = appointmentStatus;
            return this;
        }

        private AppointmentStatus appointmentStatus;


        public Appointment build()
        {
            return new Appointment(this);
        }

    }

}
