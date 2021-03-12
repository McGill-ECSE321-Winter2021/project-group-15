package ca.mcgill.ecse321.projectgroup15.model;



import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
  @OneToMany()
  private List<User> user;
  @ManyToMany()
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
  @Column
  @ElementCollection(targetClass=Account.class)
  public List<User> getUser()
  {
	  List<User> newUser = Collections.unmodifiableList(user);
    return newUser;
  }
  public void setUser(List<User> userss) {
	   this.user = userss;
 }
  
 
  
  /* Code from template association_GetMany */
  
  @Column
  @ElementCollection(targetClass=Account.class)
  public List<Payment> getPayment()
  {
    List<Payment> newPayment = Collections.unmodifiableList(payment);
    return newPayment;
  }
  public void setPayment(List<Payment> paymentss) {
	   this.payment = paymentss;
  }
}

 