package ca.mcgill.ecse321.projectgroup15.model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Services
{
  //Service Attributes
  private String name;
  private float cost;
  private int duration;
  private String id;

  //Service Associations
  private RepairShop repairShop;
  private Appointment appointments;
  private List<TimeSlot> timeSlots;
 
  
  private Technician technician;
  
  
  
  
  @ManyToOne
  public Technician getTechnician() {
	return technician;
}

public void setTechnician(Technician technician) {
	this.technician = technician;
}

@ManyToMany
  public List<TimeSlot> getTimeSlots() {
	return timeSlots;
}

public void setTimeSlots(List<TimeSlot> timeSlots) {
	this.timeSlots = timeSlots;
}

public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public float getCost() {
    return cost;
  }

  public void setCost(float cost) {
    this.cost = cost;
  }

  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  public void setId(String id) {
    this.id = id;
  }

  @ManyToOne(cascade = {CascadeType.ALL})
  public RepairShop getRepairShop() {
    return repairShop;
  }

  public void setRepairShop(RepairShop repairShop) {
    this.repairShop = repairShop;
  }

  @OneToOne
  public Appointment getAppointments() {
    return appointments;
  }

  public void setAppointments(Appointment appointments) {
    this.appointments = appointments;
  }
 

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public String getId() {
    return id;
  }
  @Enumerated(EnumType.ORDINAL)  
 private ServiceType serviceType;
  
  public void setServiceType(ServiceType serviceType) {
	    this.serviceType = serviceType;
	  }

	  public ServiceType getServiceType() {
	    return this.serviceType;
	  }
}