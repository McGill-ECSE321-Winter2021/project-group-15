package ca.mcgill.ecse321.projectgroup15.model;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
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

  
 

  public User(String aLastName, String aPhoneNo, String aFirstName, String aUserId, AutoRepairShop aAutoRepairShop) {
	// TODO Auto-generated constructor stub
}

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
}