package ca.mcgill.ecse321.projectgroup15.model;



import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Account
{


  //Account Attributes
  private String email;
  private String password;

  //Account Associations
  private User user;
  private List<Payment> payment;
 

 

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
  
  /* Code from template association_GetMany */
  
@ManyToMany()
  public List<Payment> getPayment()
  {
    List<Payment> newPayment = Collections.unmodifiableList(payment);
    return newPayment;
  }
  public void setPayment(List<Payment> paymentss) {
	   this.payment = paymentss;
  }
}

 