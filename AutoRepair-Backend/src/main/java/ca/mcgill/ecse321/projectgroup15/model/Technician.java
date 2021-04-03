/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/
package ca.mcgill.ecse321.projectgroup15.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.*;

@Entity
public class Technician extends Person
{
	


//Technician Associations
  private List<TimeSlot> timeSlots;
  private Appointment appointments;
 private List<Services> services;
 
 
 @OneToMany(mappedBy = "technician",cascade = {CascadeType.ALL})
  public List<Services> getServices() {
	return services;
}

public void setServices(List<Services> services) {
	this.services = services;
}

@OneToOne
  public Appointment getAppointments() {
	return appointments;
}

public void setAppointments(Appointment appointments) {
	this.appointments = appointments;
}

@ManyToMany
  public List<TimeSlot> getTimeSlots() {
    return timeSlots;
  }

  public void setTimeSlots(List<TimeSlot> timeSlots) {
    this.timeSlots = timeSlots;
  }
 
  //adds a single timeslot for a technician
  public void setTimeSlot(TimeSlot timeSlot) {
	 if(this.timeSlots == null) {
		 this.timeSlots = new ArrayList<TimeSlot>();
	 }
	 this.timeSlots.add(timeSlot);
  }
  @Enumerated(EnumType.ORDINAL)
private TechnicianRole technicianRole;
  
  public void setTechnicianRole(TechnicianRole technicianRole) {
	    this.technicianRole = technicianRole;
	  }

	  public TechnicianRole getTechnicianRole() {
	    return this.technicianRole;
	  }
  
 
}