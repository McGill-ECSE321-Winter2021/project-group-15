package ca.mcgill.ecse321.projectgroup15.model;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.sql.Date;
import java.sql.Time;

// line 26 "model.ump"
// line 104 "model.ump"
@Entity
public class Appointment
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Appointment Attributes
  private String appointmentID;

  //Appointment Associations

  private List<Service> services;
  private TimeSlot timeSlot;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Appointment(String aAppointmentID, TimeSlot aTimeSlot)
  {
    appointmentID = aAppointmentID;
    services = new ArrayList<Service>();
    if (aTimeSlot == null || aTimeSlot.getAppointment() != null)
    {
      throw new RuntimeException("Unable to create Appointment due to aTimeSlot. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    timeSlot = aTimeSlot;
  }

  public Appointment(String aAppointmentID, Date aDateForTimeSlot, Time aStartTimeForTimeSlot, Time aEndTimeForTimeSlot, String aTsIdForTimeSlot)
  {
    appointmentID = aAppointmentID;
    services = new ArrayList<Service>();
    timeSlot = new TimeSlot(aDateForTimeSlot, aStartTimeForTimeSlot, aEndTimeForTimeSlot, aTsIdForTimeSlot, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

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
  public Service getService(int index)
  {
    Service aService = services.get(index);
    return aService;
  }
  @OneToMany(cascade={CascadeType.ALL})
  public List<Service> getServices()
  {
    List<Service> newServices = Collections.unmodifiableList(services);
    return newServices;
  }

  public int numberOfServices()
  {
    int number = services.size();
    return number;
  }

  public boolean hasServices()
  {
    boolean has = services.size() > 0;
    return has;
  }

  public int indexOfService(Service aService)
  {
    int index = services.indexOf(aService);
    return index;
  }
  /* Code from template association_GetOne */
  @OneToOne(cascade={CascadeType.ALL})
  public TimeSlot getTimeSlot()
  {
    return timeSlot;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfServicesValid()
  {
    boolean isValid = numberOfServices() >= minimumNumberOfServices() && numberOfServices() <= maximumNumberOfServices();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfServices()
  {
    return 1;
  }
  /* Code from template association_MaximumNumberOfMethod */
  public static int maximumNumberOfServices()
  {
    return 3;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addService(Service aService)
  {
    boolean wasAdded = false;
    if (services.contains(aService)) { return false; }
    if (numberOfServices() >= maximumNumberOfServices())
    {
      return wasAdded;
    }

    services.add(aService);
    if (aService.indexOfAppointment(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aService.addAppointment(this);
      if (!wasAdded)
      {
        services.remove(aService);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMNToMany */
  public boolean removeService(Service aService)
  {
    boolean wasRemoved = false;
    if (!services.contains(aService))
    {
      return wasRemoved;
    }

    if (numberOfServices() <= minimumNumberOfServices())
    {
      return wasRemoved;
    }

    int oldIndex = services.indexOf(aService);
    services.remove(oldIndex);
    if (aService.indexOfAppointment(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aService.removeAppointment(this);
      if (!wasRemoved)
      {
        services.add(oldIndex,aService);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMNToMany */
  public boolean setServices(Service... newServices)
  {
    boolean wasSet = false;
    ArrayList<Service> verifiedServices = new ArrayList<Service>();
    for (Service aService : newServices)
    {
      if (verifiedServices.contains(aService))
      {
        continue;
      }
      verifiedServices.add(aService);
    }

    if (verifiedServices.size() != newServices.length || verifiedServices.size() < minimumNumberOfServices() || verifiedServices.size() > maximumNumberOfServices())
    {
      return wasSet;
    }

    ArrayList<Service> oldServices = new ArrayList<Service>(services);
    services.clear();
    for (Service aNewService : verifiedServices)
    {
      services.add(aNewService);
      if (oldServices.contains(aNewService))
      {
        oldServices.remove(aNewService);
      }
      else
      {
        aNewService.addAppointment(this);
      }
    }

    for (Service anOldService : oldServices)
    {
      anOldService.removeAppointment(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addServiceAt(Service aService, int index)
  {  
    boolean wasAdded = false;
    if(addService(aService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServices()) { index = numberOfServices() - 1; }
      services.remove(aService);
      services.add(index, aService);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveServiceAt(Service aService, int index)
  {
    boolean wasAdded = false;
    if(services.contains(aService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfServices()) { index = numberOfServices() - 1; }
      services.remove(aService);
      services.add(index, aService);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addServiceAt(aService, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Service> copyOfServices = new ArrayList<Service>(services);
    services.clear();
    for(Service aService : copyOfServices)
    {
      if (aService.numberOfAppointments() <= Service.minimumNumberOfAppointments())
      {
        aService.delete();
      }
      else
      {
        aService.removeAppointment(this);
      }
    }
    TimeSlot existingTimeSlot = timeSlot;
    timeSlot = null;
    if (existingTimeSlot != null)
    {
      existingTimeSlot.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "appointmentID" + ":" + getAppointmentID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "timeSlot = "+(getTimeSlot()!=null?Integer.toHexString(System.identityHashCode(getTimeSlot())):"null");
  }
}