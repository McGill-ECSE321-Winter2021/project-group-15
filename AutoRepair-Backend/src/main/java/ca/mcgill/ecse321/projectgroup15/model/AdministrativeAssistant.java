package ca.mcgill.ecse321.projectgroup15.model;


import java.util.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.sql.Date;
import java.sql.Time;

@Entity
public class AdministrativeAssistant extends User
{

  

  //AdministrativeAssistant Associations
  private List<TimeSlot> availableTimeSlots;

  

  public AdministrativeAssistant(String aLastName, String aPhoneNo, String aFirstName, String aUserId, AutoRepairShop aAutoRepairShop)
  {
    super(aLastName, aPhoneNo, aFirstName, aUserId, aAutoRepairShop);
    //availableTimeSlots = new ArrayList<TimeSlot>();
  }

 

  /* Code from template association_GetMany */
  
//@ManyToMany()
  public List<TimeSlot> getAvailableTimeSlots()
  {
    List<TimeSlot> newAvailableTimeSlots = Collections.unmodifiableList(availableTimeSlots);
    return newAvailableTimeSlots;
  }
  public void setTimeSlot(List<TimeSlot> timeSlotss) {
	   this.availableTimeSlots = timeSlotss;
 }
}