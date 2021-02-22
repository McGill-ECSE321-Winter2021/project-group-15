/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 20 "model.ump"
// line 137 "model.ump"
public class Service
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Service Attributes
  private String serviceType;

  //Service Associations
  private List<Technician> technicians;
  private List<Appointment> appointments;
  private AutoRepairShop autoRepairShop;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Service(String aServiceType, AutoRepairShop aAutoRepairShop)
  {
    serviceType = aServiceType;
    technicians = new ArrayList<Technician>();
    appointments = new ArrayList<Appointment>();
    boolean didAddAutoRepairShop = setAutoRepairShop(aAutoRepairShop);
    if (!didAddAutoRepairShop)
    {
      throw new RuntimeException("Unable to create service due to autoRepairShop. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setServiceType(String aServiceType)
  {
    boolean wasSet = false;
    serviceType = aServiceType;
    wasSet = true;
    return wasSet;
  }

  public String getServiceType()
  {
    return serviceType;
  }
  /* Code from template association_GetMany */
  public Technician getTechnician(int index)
  {
    Technician aTechnician = technicians.get(index);
    return aTechnician;
  }

  public List<Technician> getTechnicians()
  {
    List<Technician> newTechnicians = Collections.unmodifiableList(technicians);
    return newTechnicians;
  }

  public int numberOfTechnicians()
  {
    int number = technicians.size();
    return number;
  }

  public boolean hasTechnicians()
  {
    boolean has = technicians.size() > 0;
    return has;
  }

  public int indexOfTechnician(Technician aTechnician)
  {
    int index = technicians.indexOf(aTechnician);
    return index;
  }
  /* Code from template association_GetMany */
  public Appointment getAppointment(int index)
  {
    Appointment aAppointment = appointments.get(index);
    return aAppointment;
  }

  public List<Appointment> getAppointments()
  {
    List<Appointment> newAppointments = Collections.unmodifiableList(appointments);
    return newAppointments;
  }

  public int numberOfAppointments()
  {
    int number = appointments.size();
    return number;
  }

  public boolean hasAppointments()
  {
    boolean has = appointments.size() > 0;
    return has;
  }

  public int indexOfAppointment(Appointment aAppointment)
  {
    int index = appointments.indexOf(aAppointment);
    return index;
  }
  /* Code from template association_GetOne */
  public AutoRepairShop getAutoRepairShop()
  {
    return autoRepairShop;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfTechniciansValid()
  {
    boolean isValid = numberOfTechnicians() >= minimumNumberOfTechnicians();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTechnicians()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTechnician(Technician aTechnician)
  {
    boolean wasAdded = false;
    if (technicians.contains(aTechnician)) { return false; }
    technicians.add(aTechnician);
    if (aTechnician.indexOfExpertise(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTechnician.addExpertise(this);
      if (!wasAdded)
      {
        technicians.remove(aTechnician);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeTechnician(Technician aTechnician)
  {
    boolean wasRemoved = false;
    if (!technicians.contains(aTechnician))
    {
      return wasRemoved;
    }

    if (numberOfTechnicians() <= minimumNumberOfTechnicians())
    {
      return wasRemoved;
    }

    int oldIndex = technicians.indexOf(aTechnician);
    technicians.remove(oldIndex);
    if (aTechnician.indexOfExpertise(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTechnician.removeExpertise(this);
      if (!wasRemoved)
      {
        technicians.add(oldIndex,aTechnician);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setTechnicians(Technician... newTechnicians)
  {
    boolean wasSet = false;
    ArrayList<Technician> verifiedTechnicians = new ArrayList<Technician>();
    for (Technician aTechnician : newTechnicians)
    {
      if (verifiedTechnicians.contains(aTechnician))
      {
        continue;
      }
      verifiedTechnicians.add(aTechnician);
    }

    if (verifiedTechnicians.size() != newTechnicians.length || verifiedTechnicians.size() < minimumNumberOfTechnicians())
    {
      return wasSet;
    }

    ArrayList<Technician> oldTechnicians = new ArrayList<Technician>(technicians);
    technicians.clear();
    for (Technician aNewTechnician : verifiedTechnicians)
    {
      technicians.add(aNewTechnician);
      if (oldTechnicians.contains(aNewTechnician))
      {
        oldTechnicians.remove(aNewTechnician);
      }
      else
      {
        aNewTechnician.addExpertise(this);
      }
    }

    for (Technician anOldTechnician : oldTechnicians)
    {
      anOldTechnician.removeExpertise(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTechnicianAt(Technician aTechnician, int index)
  {  
    boolean wasAdded = false;
    if(addTechnician(aTechnician))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTechnicians()) { index = numberOfTechnicians() - 1; }
      technicians.remove(aTechnician);
      technicians.add(index, aTechnician);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTechnicianAt(Technician aTechnician, int index)
  {
    boolean wasAdded = false;
    if(technicians.contains(aTechnician))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTechnicians()) { index = numberOfTechnicians() - 1; }
      technicians.remove(aTechnician);
      technicians.add(index, aTechnician);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTechnicianAt(aTechnician, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfAppointmentsValid()
  {
    boolean isValid = numberOfAppointments() >= minimumNumberOfAppointments();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAppointments()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addAppointment(Appointment aAppointment)
  {
    boolean wasAdded = false;
    if (appointments.contains(aAppointment)) { return false; }
    appointments.add(aAppointment);
    if (aAppointment.indexOfService(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aAppointment.addService(this);
      if (!wasAdded)
      {
        appointments.remove(aAppointment);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeAppointment(Appointment aAppointment)
  {
    boolean wasRemoved = false;
    if (!appointments.contains(aAppointment))
    {
      return wasRemoved;
    }

    if (numberOfAppointments() <= minimumNumberOfAppointments())
    {
      return wasRemoved;
    }

    int oldIndex = appointments.indexOf(aAppointment);
    appointments.remove(oldIndex);
    if (aAppointment.indexOfService(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aAppointment.removeService(this);
      if (!wasRemoved)
      {
        appointments.add(oldIndex,aAppointment);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setAppointments(Appointment... newAppointments)
  {
    boolean wasSet = false;
    ArrayList<Appointment> verifiedAppointments = new ArrayList<Appointment>();
    for (Appointment aAppointment : newAppointments)
    {
      if (verifiedAppointments.contains(aAppointment))
      {
        continue;
      }
      verifiedAppointments.add(aAppointment);
    }

    if (verifiedAppointments.size() != newAppointments.length || verifiedAppointments.size() < minimumNumberOfAppointments())
    {
      return wasSet;
    }

    ArrayList<Appointment> oldAppointments = new ArrayList<Appointment>(appointments);
    appointments.clear();
    for (Appointment aNewAppointment : verifiedAppointments)
    {
      appointments.add(aNewAppointment);
      if (oldAppointments.contains(aNewAppointment))
      {
        oldAppointments.remove(aNewAppointment);
      }
      else
      {
        aNewAppointment.addService(this);
      }
    }

    for (Appointment anOldAppointment : oldAppointments)
    {
      anOldAppointment.removeService(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAppointmentAt(Appointment aAppointment, int index)
  {  
    boolean wasAdded = false;
    if(addAppointment(aAppointment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAppointments()) { index = numberOfAppointments() - 1; }
      appointments.remove(aAppointment);
      appointments.add(index, aAppointment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAppointmentAt(Appointment aAppointment, int index)
  {
    boolean wasAdded = false;
    if(appointments.contains(aAppointment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAppointments()) { index = numberOfAppointments() - 1; }
      appointments.remove(aAppointment);
      appointments.add(index, aAppointment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAppointmentAt(aAppointment, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setAutoRepairShop(AutoRepairShop aAutoRepairShop)
  {
    boolean wasSet = false;
    if (aAutoRepairShop == null)
    {
      return wasSet;
    }

    AutoRepairShop existingAutoRepairShop = autoRepairShop;
    autoRepairShop = aAutoRepairShop;
    if (existingAutoRepairShop != null && !existingAutoRepairShop.equals(aAutoRepairShop))
    {
      existingAutoRepairShop.removeService(this);
    }
    autoRepairShop.addService(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    ArrayList<Technician> copyOfTechnicians = new ArrayList<Technician>(technicians);
    technicians.clear();
    for(Technician aTechnician : copyOfTechnicians)
    {
      if (aTechnician.numberOfExpertise() <= Technician.minimumNumberOfExpertise())
      {
        aTechnician.delete();
      }
      else
      {
        aTechnician.removeExpertise(this);
      }
    }
    ArrayList<Appointment> copyOfAppointments = new ArrayList<Appointment>(appointments);
    appointments.clear();
    for(Appointment aAppointment : copyOfAppointments)
    {
      if (aAppointment.numberOfServices() <= Appointment.minimumNumberOfServices())
      {
        aAppointment.delete();
      }
      else
      {
        aAppointment.removeService(this);
      }
    }
    AutoRepairShop placeholderAutoRepairShop = autoRepairShop;
    this.autoRepairShop = null;
    if(placeholderAutoRepairShop != null)
    {
      placeholderAutoRepairShop.removeService(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "serviceType" + ":" + getServiceType()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "autoRepairShop = "+(getAutoRepairShop()!=null?Integer.toHexString(System.identityHashCode(getAutoRepairShop())):"null");
  }
}