package ca.mcgill.ecse321.projectgroup15.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;
import java.sql.Date;
import java.sql.Time;

// line 33 "model.ump"
// line 124 "model.ump"
public class Technician extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Technician Attributes
  private String technicianID;
  private int rating;
  private String role;

  //Technician Associations
  private List<TimeSlot> availability;
  private List<Service> expertise;
  private List<Appointment> assignment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Technician(String aLastName, String aPhoneNo, AutoRepairShop aAutoRepairShop, String aTechnicianID, int aRating, String aRole)
  {
    super(aLastName, aPhoneNo, aAutoRepairShop);
    technicianID = aTechnicianID;
    rating = aRating;
    role = aRole;
    availability = new ArrayList<TimeSlot>();
    expertise = new ArrayList<Service>();
    assignment = new ArrayList<Appointment>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTechnicianID(String aTechnicianID)
  {
    boolean wasSet = false;
    technicianID = aTechnicianID;
    wasSet = true;
    return wasSet;
  }

  public boolean setRating(int aRating)
  {
    boolean wasSet = false;
    rating = aRating;
    wasSet = true;
    return wasSet;
  }

  public boolean setRole(String aRole)
  {
    boolean wasSet = false;
    role = aRole;
    wasSet = true;
    return wasSet;
  }

  public String getTechnicianID()
  {
    return technicianID;
  }

  public int getRating()
  {
    return rating;
  }

  public String getRole()
  {
    return role;
  }
  /* Code from template association_GetMany */
  public TimeSlot getAvailability(int index)
  {
    TimeSlot aAvailability = availability.get(index);
    return aAvailability;
  }

  public List<TimeSlot> getAvailability()
  {
    List<TimeSlot> newAvailability = Collections.unmodifiableList(availability);
    return newAvailability;
  }

  public int numberOfAvailability()
  {
    int number = availability.size();
    return number;
  }

  public boolean hasAvailability()
  {
    boolean has = availability.size() > 0;
    return has;
  }

  public int indexOfAvailability(TimeSlot aAvailability)
  {
    int index = availability.indexOf(aAvailability);
    return index;
  }
  /* Code from template association_GetMany */
  public Service getExpertise(int index)
  {
    Service aExpertise = expertise.get(index);
    return aExpertise;
  }

  public List<Service> getExpertise()
  {
    List<Service> newExpertise = Collections.unmodifiableList(expertise);
    return newExpertise;
  }

  public int numberOfExpertise()
  {
    int number = expertise.size();
    return number;
  }

  public boolean hasExpertise()
  {
    boolean has = expertise.size() > 0;
    return has;
  }

  public int indexOfExpertise(Service aExpertise)
  {
    int index = expertise.indexOf(aExpertise);
    return index;
  }
  /* Code from template association_GetMany */
  public Appointment getAssignment(int index)
  {
    Appointment aAssignment = assignment.get(index);
    return aAssignment;
  }

  public List<Appointment> getAssignment()
  {
    List<Appointment> newAssignment = Collections.unmodifiableList(assignment);
    return newAssignment;
  }

  public int numberOfAssignment()
  {
    int number = assignment.size();
    return number;
  }

  public boolean hasAssignment()
  {
    boolean has = assignment.size() > 0;
    return has;
  }

  public int indexOfAssignment(Appointment aAssignment)
  {
    int index = assignment.indexOf(aAssignment);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAvailability()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addAvailability(TimeSlot aAvailability)
  {
    boolean wasAdded = false;
    if (availability.contains(aAvailability)) { return false; }
    availability.add(aAvailability);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAvailability(TimeSlot aAvailability)
  {
    boolean wasRemoved = false;
    if (availability.contains(aAvailability))
    {
      availability.remove(aAvailability);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAvailabilityAt(TimeSlot aAvailability, int index)
  {  
    boolean wasAdded = false;
    if(addAvailability(aAvailability))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAvailability()) { index = numberOfAvailability() - 1; }
      availability.remove(aAvailability);
      availability.add(index, aAvailability);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAvailabilityAt(TimeSlot aAvailability, int index)
  {
    boolean wasAdded = false;
    if(availability.contains(aAvailability))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAvailability()) { index = numberOfAvailability() - 1; }
      availability.remove(aAvailability);
      availability.add(index, aAvailability);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAvailabilityAt(aAvailability, index);
    }
    return wasAdded;
  }
  /* Code from template association_IsNumberOfValidMethod */
  public boolean isNumberOfExpertiseValid()
  {
    boolean isValid = numberOfExpertise() >= minimumNumberOfExpertise();
    return isValid;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfExpertise()
  {
    return 1;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addExpertise(Service aExpertise)
  {
    boolean wasAdded = false;
    if (expertise.contains(aExpertise)) { return false; }
    expertise.add(aExpertise);
    if (aExpertise.indexOfTechnician(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aExpertise.addTechnician(this);
      if (!wasAdded)
      {
        expertise.remove(aExpertise);
      }
    }
    return wasAdded;
  }
  /* Code from template association_AddMStarToMany */
  public boolean removeExpertise(Service aExpertise)
  {
    boolean wasRemoved = false;
    if (!expertise.contains(aExpertise))
    {
      return wasRemoved;
    }

    if (numberOfExpertise() <= minimumNumberOfExpertise())
    {
      return wasRemoved;
    }

    int oldIndex = expertise.indexOf(aExpertise);
    expertise.remove(oldIndex);
    if (aExpertise.indexOfTechnician(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aExpertise.removeTechnician(this);
      if (!wasRemoved)
      {
        expertise.add(oldIndex,aExpertise);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_SetMStarToMany */
  public boolean setExpertise(Service... newExpertise)
  {
    boolean wasSet = false;
    ArrayList<Service> verifiedExpertise = new ArrayList<Service>();
    for (Service aExpertise : newExpertise)
    {
      if (verifiedExpertise.contains(aExpertise))
      {
        continue;
      }
      verifiedExpertise.add(aExpertise);
    }

    if (verifiedExpertise.size() != newExpertise.length || verifiedExpertise.size() < minimumNumberOfExpertise())
    {
      return wasSet;
    }

    ArrayList<Service> oldExpertise = new ArrayList<Service>(expertise);
    expertise.clear();
    for (Service aNewExpertise : verifiedExpertise)
    {
      expertise.add(aNewExpertise);
      if (oldExpertise.contains(aNewExpertise))
      {
        oldExpertise.remove(aNewExpertise);
      }
      else
      {
        aNewExpertise.addTechnician(this);
      }
    }

    for (Service anOldExpertise : oldExpertise)
    {
      anOldExpertise.removeTechnician(this);
    }
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addExpertiseAt(Service aExpertise, int index)
  {  
    boolean wasAdded = false;
    if(addExpertise(aExpertise))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExpertise()) { index = numberOfExpertise() - 1; }
      expertise.remove(aExpertise);
      expertise.add(index, aExpertise);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveExpertiseAt(Service aExpertise, int index)
  {
    boolean wasAdded = false;
    if(expertise.contains(aExpertise))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfExpertise()) { index = numberOfExpertise() - 1; }
      expertise.remove(aExpertise);
      expertise.add(index, aExpertise);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addExpertiseAt(aExpertise, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfAssignment()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addAssignment(Appointment aAssignment)
  {
    boolean wasAdded = false;
    if (assignment.contains(aAssignment)) { return false; }
    assignment.add(aAssignment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeAssignment(Appointment aAssignment)
  {
    boolean wasRemoved = false;
    if (assignment.contains(aAssignment))
    {
      assignment.remove(aAssignment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addAssignmentAt(Appointment aAssignment, int index)
  {  
    boolean wasAdded = false;
    if(addAssignment(aAssignment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignment()) { index = numberOfAssignment() - 1; }
      assignment.remove(aAssignment);
      assignment.add(index, aAssignment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveAssignmentAt(Appointment aAssignment, int index)
  {
    boolean wasAdded = false;
    if(assignment.contains(aAssignment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfAssignment()) { index = numberOfAssignment() - 1; }
      assignment.remove(aAssignment);
      assignment.add(index, aAssignment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addAssignmentAt(aAssignment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    availability.clear();
    ArrayList<Service> copyOfExpertise = new ArrayList<Service>(expertise);
    expertise.clear();
    for(Service aExpertise : copyOfExpertise)
    {
      if (aExpertise.numberOfTechnicians() <= Service.minimumNumberOfTechnicians())
      {
        aExpertise.delete();
      }
      else
      {
        aExpertise.removeTechnician(this);
      }
    }
    assignment.clear();
    super.delete();
  }


  public String toString()
  {
    return super.toString() + "["+
            "technicianID" + ":" + getTechnicianID()+ "," +
            "rating" + ":" + getRating()+ "," +
            "role" + ":" + getRole()+ "]";
  }
}