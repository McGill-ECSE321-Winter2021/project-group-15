/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

// line 44 "model.ump"
// line 115 "model.ump"
public class Customer extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Customer Associations
  private List<Service> desiredService;
  private Appointment appointment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Customer(String aLastName, String aPhoneNo, String aFirstName, String aUserId, AutoRepairShop aAutoRepairShop, Appointment aAppointment, Service... allDesiredService)
  {
    super(aLastName, aPhoneNo, aFirstName, aUserId, aAutoRepairShop);
    desiredService = new ArrayList<Service>();
    boolean didAddDesiredService = setDesiredService(allDesiredService);
    if (!didAddDesiredService)
    {
      throw new RuntimeException("Unable to create Customer, must have at least 1 desiredService. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    if (!setAppointment(aAppointment))
    {
      throw new RuntimeException("Unable to create Customer due to aAppointment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public Service getDesiredService(int index)
  {
    Service aDesiredService = desiredService.get(index);
    return aDesiredService;
  }

  public List<Service> getDesiredService()
  {
    List<Service> newDesiredService = Collections.unmodifiableList(desiredService);
    return newDesiredService;
  }

  public int numberOfDesiredService()
  {
    int number = desiredService.size();
    return number;
  }

  public boolean hasDesiredService()
  {
    boolean has = desiredService.size() > 0;
    return has;
  }

  public int indexOfDesiredService(Service aDesiredService)
  {
    int index = desiredService.indexOf(aDesiredService);
    return index;
  }
  /* Code from template association_GetOne */
  public Appointment getAppointment()
  {
    return appointment;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfDesiredService()
  {
    return 1;
  }
  /* Code from template association_AddUnidirectionalMStar */
  public boolean addDesiredService(Service aDesiredService)
  {
    boolean wasAdded = false;
    if (desiredService.contains(aDesiredService)) { return false; }
    desiredService.add(aDesiredService);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeDesiredService(Service aDesiredService)
  {
    boolean wasRemoved = false;
    if (!desiredService.contains(aDesiredService))
    {
      return wasRemoved;
    }

    if (numberOfDesiredService() <= minimumNumberOfDesiredService())
    {
      return wasRemoved;
    }

    desiredService.remove(aDesiredService);
    wasRemoved = true;
    return wasRemoved;
  }
  /* Code from template association_SetUnidirectionalMStar */
  public boolean setDesiredService(Service... newDesiredService)
  {
    boolean wasSet = false;
    ArrayList<Service> verifiedDesiredService = new ArrayList<Service>();
    for (Service aDesiredService : newDesiredService)
    {
      if (verifiedDesiredService.contains(aDesiredService))
      {
        continue;
      }
      verifiedDesiredService.add(aDesiredService);
    }

    if (verifiedDesiredService.size() != newDesiredService.length || verifiedDesiredService.size() < minimumNumberOfDesiredService())
    {
      return wasSet;
    }

    desiredService.clear();
    desiredService.addAll(verifiedDesiredService);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addDesiredServiceAt(Service aDesiredService, int index)
  {  
    boolean wasAdded = false;
    if(addDesiredService(aDesiredService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDesiredService()) { index = numberOfDesiredService() - 1; }
      desiredService.remove(aDesiredService);
      desiredService.add(index, aDesiredService);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveDesiredServiceAt(Service aDesiredService, int index)
  {
    boolean wasAdded = false;
    if(desiredService.contains(aDesiredService))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfDesiredService()) { index = numberOfDesiredService() - 1; }
      desiredService.remove(aDesiredService);
      desiredService.add(index, aDesiredService);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addDesiredServiceAt(aDesiredService, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setAppointment(Appointment aNewAppointment)
  {
    boolean wasSet = false;
    if (aNewAppointment != null)
    {
      appointment = aNewAppointment;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    desiredService.clear();
    appointment = null;
    super.delete();
  }

}