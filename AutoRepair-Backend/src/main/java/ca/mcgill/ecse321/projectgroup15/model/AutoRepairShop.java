package ca.mcgill.ecse321.projectgroup15.model;


import java.util.*;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;



@Entity
public class AutoRepairShop
{

@ManyToMany(cascade={CascadeType.ALL})
  private List<User> users;
  
  //@ManyToMany(cascade={CascadeType.ALL})

  public List<User> getUsers()
  {
    return this.users;
  }

public void setUsers(List<User> userss) {
	   this.users = userss;
	   
}

  
  
  @ManyToMany(cascade={CascadeType.ALL})
  private List<Appointment> appointments;
  
  public List<Appointment> getAppointments()
  {
    return this.appointments;
  }
  public void setAppointment(List<Appointment> appointmentss) {
	   this.appointments = appointmentss;
	   
}

  
  
 
  
  private int id;

  public void setId(int value) {
  this.id = value;
      }
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
  return this.id;
         }
}