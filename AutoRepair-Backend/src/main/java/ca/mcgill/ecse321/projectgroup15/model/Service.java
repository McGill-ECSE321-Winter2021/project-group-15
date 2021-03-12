package ca.mcgill.ecse321.projectgroup15.model;


import java.util.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Service
{

  
  //Service Attributes
  private String serviceType;
  private Double serviceCost;

  //Service Associations
  @ManyToMany()
  private List<Technician> technicians;
  @ManyToMany()
  private List<Appointment> appointments;
  
  
  public boolean setServiceCost(Double aServiceCost)
  {
    boolean wasSet = false;
    serviceCost = aServiceCost;
    wasSet = true;
    return wasSet;
  }
  public Double getServiceCost()
  {
    return serviceCost;
  }
  
  public boolean setServiceType(String aServiceType)
  {
    boolean wasSet = false;
    serviceType = aServiceType;
    wasSet = true;
    return wasSet;
  }
@Id
  public String getServiceType()
  {
    return serviceType;
  }
 
@Column
@ElementCollection(targetClass=Service.class)
  public List<Technician> getTechnicians()
  {
    List<Technician> newTechnicians = Collections.unmodifiableList(technicians);
    return newTechnicians;
  }
  public void setTechnician(List<Technician> technicianss) {
	   this.technicians = technicianss;
	}

  
  /* Code from template association_GetMany */
 
  @Column
  @ElementCollection(targetClass=Service.class)
  public List<Appointment> getAppointments()
  {
    List<Appointment> newAppointments = Collections.unmodifiableList(appointments);
    return newAppointments;
  }
  public void setAppointment(List<Appointment> appointmentss) {
	   this.appointments = appointmentss;
	}
  }