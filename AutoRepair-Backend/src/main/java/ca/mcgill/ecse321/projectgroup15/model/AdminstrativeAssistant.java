/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 50 "model.ump"
// line 130 "model.ump"
public class AdminstrativeAssistant extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //AdminstrativeAssistant Associations
  private List<TimeSlot> availableTimeSlots;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public AdminstrativeAssistant(String aLastName, String aPhoneNo, String aFirstName, String aUserId, AutoRepairShop aAutoRepairShop)
  {
    super(aLastName, aPhoneNo, aFirstName, aUserId, aAutoRepairShop);
    availableTimeSlots = new ArrayList<TimeSlot>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetMany */
  public TimeSlot getAvailableTimeSlot(int index)
  {
    TimeSlot aAvailableTimeSlot = availableTimeSlots.get(index);
    return aAvailableTimeSlot;
  }

  public List<TimeSlot> getAvailableTimeSlots()
  {
    List<TimeSlot> newAvailableTimeSlots = Collections.unmodifiableList(availableTimeSlots);
    return newAvailableTimeSlots;
  }

  public int numberOfAvailableTimeSlots()
  {
    int number = availableTimeSlots.size();
    return number;
  }

  public boolean hasAvailableTimeSlots()
  {
    boolean has = availableTimeSlots.size() > 0;
    return has;
  }

  public int indexOfAvailableTimeSlot(TimeSlot aAvailableTimeSlot)
  {
    int index = availableTimeSlots.indexOf(aAvailableTimeSlot);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAvailableTimeSlots()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addAvailableTimeSlot(TimeSlot aAvailableTimeSlot)
  {
    boolean wasAdded = false;
    if (availableTimeSlots.contains(aAvailableTimeSlot)) { return false; }
    availableTimeSlots.add(aAvailableTimeSlot);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAvailableTimeSlot(TimeSlot aAvailableTimeSlot)
  {
    boolean wasRemoved = false;
    if (availableTimeSlots.contains(aAvailableTimeSlot))
    {
      availableTimeSlots.remove(aAvailableTimeSlot);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAvailableTimeSlotAt(TimeSlot aAvailableTimeSlot, int index)
  {  
    boolean wasAdded = false;
    if(addAvailableTimeSlot(aAvailableTimeSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAvailableTimeSlots()) { index = numberOfAvailableTimeSlots() - 1; }
      availableTimeSlots.remove(aAvailableTimeSlot);
      availableTimeSlots.add(index, aAvailableTimeSlot);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAvailableTimeSlotAt(TimeSlot aAvailableTimeSlot, int index)
  {
    boolean wasAdded = false;
    if(availableTimeSlots.contains(aAvailableTimeSlot))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAvailableTimeSlots()) { index = numberOfAvailableTimeSlots() - 1; }
      availableTimeSlots.remove(aAvailableTimeSlot);
      availableTimeSlots.add(index, aAvailableTimeSlot);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAvailableTimeSlotAt(aAvailableTimeSlot, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    availableTimeSlots.clear();
    super.delete();
  }

}