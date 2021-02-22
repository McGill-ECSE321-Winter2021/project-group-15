package ca.mcgill.ecse321.projectgroup15.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 2 "model.ump"
// line 84 "model.ump"
@Entity
public abstract class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String lastName;
  private String phoneNo;
  private String firstName;
  private String userId;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aLastName, String aPhoneNo, String aFirstName, String aUserId)
  {
    lastName = aLastName;
    phoneNo = aPhoneNo;
    firstName = aFirstName;
    userId = aUserId;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setLastName(String aLastName)
  {
    boolean wasSet = false;
    lastName = aLastName;
    wasSet = true;
    return wasSet;
  }

  public boolean setPhoneNo(String aPhoneNo)
  {
    boolean wasSet = false;
    phoneNo = aPhoneNo;
    wasSet = true;
    return wasSet;
  }

  public boolean setFirstName(String aFirstName)
  {
    boolean wasSet = false;
    firstName = aFirstName;
    wasSet = true;
    return wasSet;
  }

  public boolean setUserId(String aUserId)
  {
    boolean wasSet = false;
    userId = aUserId;
    wasSet = true;
    return wasSet;
  }

  public String getLastName()
  {
    return lastName;
  }

  public String getPhoneNo()
  {
    return phoneNo;
  }

  public String getFirstName()
  {
    return firstName;
  }
@Id
  public String getUserId()
  {
    return userId;
  }

  public void delete()
  {}


  public String toString()
  {
    return super.toString() + "["+
            "lastName" + ":" + getLastName()+ "," +
            "phoneNo" + ":" + getPhoneNo()+ "," +
            "firstName" + ":" + getFirstName()+ "," +
            "userId" + ":" + getUserId()+ "]";
  }
}