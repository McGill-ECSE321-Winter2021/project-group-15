package ca.mcgill.ecse321.projectgroup15.model;


import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Service
{

  
  //Service Attributes
  private String serviceType;

  //Service Associations
  private List<Technician> technicians;
  private List<Appointment> appointments;
  
  


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
 
  @ManyToMany()
  public List<Technician> getTechnicians()
  {
    List<Technician> newTechnicians = Collections.unmodifiableList(technicians);
    return newTechnicians;
  }
  public void setTechnician(List<Technician> technicianss) {
	   this.technicians = technicianss;
	}

  
  /* Code from template association_GetMany */
 
@ManyToMany()
  public List<Appointment> getAppointments()
  {
    List<Appointment> newAppointments = Collections.unmodifiableList(appointments);
    return newAppointments;
  }
  public void setAppointment(List<Appointment> appointmentss) {
	   this.appointments = appointmentss;
	}
  }