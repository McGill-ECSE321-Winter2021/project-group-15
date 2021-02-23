package ca.mcgill.ecse321.projectgroup15.model;



import java.util.*;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
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
  @ManyToMany()
  private List<Service> desiredService;
  @OneToMany()
  private List<Appointment> appointment;

  /* Code from template association_GetMany */
 
  @Column
  @ElementCollection(targetClass=Customer.class)
  public List<Service> getDesiredService()
  {
    List<Service> newDesiredService = Collections.unmodifiableList(desiredService);
    return newDesiredService;
  }
  public void setService(List<Service> desiredservicess) {
	   this.desiredService = desiredservicess;
 }

  
  /* Code from template association_GetOne */
  @Column
  @ElementCollection(targetClass=Customer.class)
  public List<Appointment> getAppointment()
  {
	  List<Appointment> newAppointment = Collections.unmodifiableList(appointment);
    return newAppointment;
  }
  public void setAppointment(List<Appointment> appointmentss) {
	   this.appointment = appointmentss;
 }
}