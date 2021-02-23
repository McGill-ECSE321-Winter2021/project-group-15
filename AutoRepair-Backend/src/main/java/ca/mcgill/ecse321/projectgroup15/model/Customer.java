package ca.mcgill.ecse321.projectgroup15.model;



import java.util.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Customer extends User
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  public Customer(String aLastName, String aPhoneNo, String aFirstName, String aUserId,
			AutoRepairShop aAutoRepairShop) {
		super(aLastName, aPhoneNo, aFirstName, aUserId, aAutoRepairShop);
		// TODO Auto-generated constructor stub
	}
//Customer Associations
  private List<Service> desiredService;
  private Appointment appointment;

  /* Code from template association_GetMany */
 

  public List<Service> getDesiredService()
  {
    List<Service> newDesiredService = Collections.unmodifiableList(desiredService);
    return newDesiredService;
  }
  public void setService(List<Service> desiredservicess) {
	   this.desiredService = desiredservicess;
 }

  
  /* Code from template association_GetOne */
 
  public Appointment getAppointment()
  {
    return appointment;
  }
  public void setAppointment(Appointment appointmentss) {
	   this.appointment = appointmentss;
 }
}