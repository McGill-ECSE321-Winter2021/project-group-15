package ca.mcgill.ecse321.projectgroup15.model;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/



// line 2 "model.ump"
// line 89 "model.ump"
public abstract class User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //User Attributes
  private String lastName;
  private String phoneNo;

  //User Associations
  private AutoRepairShop autoRepairShop;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public User(String aLastName, String aPhoneNo, AutoRepairShop aAutoRepairShop)
  {
    lastName = aLastName;
    phoneNo = aPhoneNo;
    boolean didAddAutoRepairShop = setAutoRepairShop(aAutoRepairShop);
    if (!didAddAutoRepairShop)
    {
      throw new RuntimeException("Unable to create user due to autoRepairShop. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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

  public String getLastName()
  {
    return lastName;
  }

  public String getPhoneNo()
  {
    return phoneNo;
  }
  /* Code from template association_GetOne */
  public AutoRepairShop getAutoRepairShop()
  {
    return autoRepairShop;
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
      existingAutoRepairShop.removeUser(this);
    }
    autoRepairShop.addUser(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    AutoRepairShop placeholderAutoRepairShop = autoRepairShop;
    this.autoRepairShop = null;
    if(placeholderAutoRepairShop != null)
    {
      placeholderAutoRepairShop.removeUser(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "lastName" + ":" + getLastName()+ "," +
            "phoneNo" + ":" + getPhoneNo()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "autoRepairShop = "+(getAutoRepairShop()!=null?Integer.toHexString(System.identityHashCode(getAutoRepairShop())):"null");
  }
}