/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/
package ca.mcgill.ecse321.projectgroup15.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.*;

@Entity
public class Technician extends Person
{
	


//Technician Associations
  private List<TimeSlot> timeSlots;
  private List<Appointment> appointments;
 private List<Service> services;
 
 
 @OneToMany(mappedBy = "technician",cascade = {CascadeType.ALL})
  public List<Service> getServices() {
	return services;
}

public void setServices(List<Service> services) {
	this.services = services;
}

@OneToMany(mappedBy = "technician",cascade = {CascadeType.ALL})
  public List<Appointment> getAppointments() {
	return appointments;
}

public void setAppointments(List<Appointment> appointments) {
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
private TechnicianRole TechnicianRole;
  
  public void setTechnicianRole(TechnicianRole TechnicianRole) {
	    this.TechnicianRole = TechnicianRole;
	  }

	  public TechnicianRole getTechnicianRole() {
	    return this.TechnicianRole;
	  }
  
 
}