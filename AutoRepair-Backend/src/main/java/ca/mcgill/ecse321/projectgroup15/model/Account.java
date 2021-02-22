package ca.mcgill.ecse321.projectgroup15.model;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;

// line 69 "model.ump"
// line 146 "model.ump"
@Entity
public class Account
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Account Attributes
  private String email;
  private String password;

  //Account Associations
  private User user;
  private List<Payment> payment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Account(String aEmail, String aPassword, User aUser)
  {
    email = aEmail;
    password = aPassword;
    if (!setUser(aUser))
    {
      throw new RuntimeException("Unable to create Account due to aUser. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    payment = new ArrayList<Payment>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEmail(String aEmail)
  {
    boolean wasSet = false;
    email = aEmail;
    wasSet = true;
    return wasSet;
  }

  public boolean setPassword(String aPassword)
  {
    boolean wasSet = false;
    password = aPassword;
    wasSet = true;
    return wasSet;
  }
@Id
  public String getEmail()
  {
    return email;
  }

  public String getPassword()
  {
    return password;
  }
  /* Code from template association_GetOne */
  public User getUser()
  {
    return user;
  }
  /* Code from template association_GetMany */
  public Payment getPayment(int index)
  {
    Payment aPayment = payment.get(index);
    return aPayment;
  }

  public List<Payment> getPayment()
  {
    List<Payment> newPayment = Collections.unmodifiableList(payment);
    return newPayment;
  }

  public int numberOfPayment()
  {
    int number = payment.size();
    return number;
  }

  public boolean hasPayment()
  {
    boolean has = payment.size() > 0;
    return has;
  }

  public int indexOfPayment(Payment aPayment)
  {
    int index = payment.indexOf(aPayment);
    return index;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setUser(User aNewUser)
  {
    boolean wasSet = false;
    if (aNewUser != null)
    {
      user = aNewUser;
      wasSet = true;
    }
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPayment()
  {
    return 0;
  }
  /* Code from template association_AddUnidirectionalMany */
  public boolean addPayment(Payment aPayment)
  {
    boolean wasAdded = false;
    if (payment.contains(aPayment)) { return false; }
    payment.add(aPayment);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removePayment(Payment aPayment)
  {
    boolean wasRemoved = false;
    if (payment.contains(aPayment))
    {
      payment.remove(aPayment);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPaymentAt(Payment aPayment, int index)
  {  
    boolean wasAdded = false;
    if(addPayment(aPayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPayment()) { index = numberOfPayment() - 1; }
      payment.remove(aPayment);
      payment.add(index, aPayment);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePaymentAt(Payment aPayment, int index)
  {
    boolean wasAdded = false;
    if(payment.contains(aPayment))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPayment()) { index = numberOfPayment() - 1; }
      payment.remove(aPayment);
      payment.add(index, aPayment);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPaymentAt(aPayment, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    user = null;
    payment.clear();
  }


  public String toString()
  {
    return super.toString() + "["+
            "email" + ":" + getEmail()+ "," +
            "password" + ":" + getPassword()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "user = "+(getUser()!=null?Integer.toHexString(System.identityHashCode(getUser())):"null");
  }
}