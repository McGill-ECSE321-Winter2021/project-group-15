package ca.mcgill.ecse321.projectgroup15.model;


import java.util.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.sql.Date;
import java.sql.Time;

@Entity
public class Appointment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Appointment Attributes
  private String appointmentID;
  private Double totalCost;

  //Appointment Associations
  @ManyToMany()
  private List<Service> services;
  @OneToMany()
  private List<TimeSlot> timeSlots;

  //------------------------
  // CONSTRUCTOR
  //------------------------

 
  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTotalCost(Double aTotalCost) {
	  Boolean wasSet = false;
	  totalCost = aTotalCost;
	  wasSet = true;
	  return wasSet;
  }
  
  public Double getTotalCost() {
	  return totalCost;
  }
  public boolean setAppointmentID(String aAppointmentID)
  {
    boolean wasSet = false;
    appointmentID = aAppointmentID;
    wasSet = true;
    return wasSet;
  }
@Id
  public String getAppointmentID()
  {
    return appointmentID;
  }
  /* Code from template association_GetMany */
 
@Column
@ElementCollection(targetClass=Appointment.class)
  public List<Service> getServices()
  {
    List<Service> newServices = Collections.unmodifiableList(services);
    return newServices;
  }
  
  public void setService(List<Service> servicess) {
	   this.services = servicess;
	}

  
  
  
  /* Code from template association_GetOne */
  //@OneToMany()
  @Column
  @ElementCollection(targetClass=Appointment.class)

  public List<TimeSlot> getTimeSlot()
  {
	  List<TimeSlot> newTimeSlots = Collections.unmodifiableList(timeSlots);
    return newTimeSlots;
  }
  public void setTimeSlot(List<TimeSlot> timeslotss) {
	   this.timeSlots = timeslotss;
	}
}