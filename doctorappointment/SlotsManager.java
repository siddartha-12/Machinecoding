package doctorappointment;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotsManager {
   private static int appointmentId = 1;
   public static SlotsManager slotsManager = null;
   private Map<Integer, Slot> timeSlotMap;
   private List<Appointment> appointments;
   private SlotsManager()
   {
      appointments = new ArrayList<>();
      timeSlotMap = new HashMap<>();
      for(Integer slot = 1; slot<=10; slot+=1)
      {
         timeSlotMap.put(slot, new Slot(slot,slot));
      }
   }
   public void markAvailable(Doctor doctor, Integer startTime)
   {
         timeSlotMap.get(startTime).markAvailableForSlot(doctor);
   }
   public Appointment cancelAppointment(Appointment appointment)
   {
      return timeSlotMap.get(appointment.getStartTime()).cancelAppointment(appointment);
   }

   public Appointment bookAppointment(User user,Integer startTime, Speciality speciality)
   {
      AppointmentRequest appointmentRequest = new AppointmentRequest(user,speciality,startTime);
      Appointment appointment = timeSlotMap.get(startTime).confirmAppointment(appointmentRequest,appointmentId);
      appointmentId+=1;
      appointments.add(appointment);
      return  appointment;
   }

   public void showAvailableDoctorsForSlotWithSpeciality(Speciality speciality, Integer slot)
   {
      timeSlotMap.get(slot).showAvailableDoctorsForSpeciality(speciality);
   }
   public void showAppointmentsWithStatus(AppointmentStatus appointmentStatus)
   {
      appointments.stream()
              .filter((appointment)->appointment.getAppointmentStatus().equals(appointmentStatus))
              .forEach((appointment)->{
                 System.out.println(""+appointment.getId()+" "+appointmentStatus.toString());
              });
   }

   public static SlotsManager getInstance()
   {
      if(slotsManager ==  null)
      {
         synchronized (SlotsManager.class)
         {
            if(slotsManager == null)
            {
               slotsManager = new SlotsManager();
            }
         }
      }
      return slotsManager;
   }

}
