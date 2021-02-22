package ca.mcgill.ecse321.projectgroup15.model;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class AutoRepairShop
{


  private List<User> users;
  

  public List<User> getUsers()
  {
    List<User> newUsers = Collections.unmodifiableList(users);
    return newUsers;
  }

public void setUsers(List<User> userss) {
	   this.users = userss;
	   
}
  
 
  private List<Service> services;
  @ManyToMany(cascade={CascadeType.ALL})
  public List<Service> getServices()
  {
    List<Service> newServices = Collections.unmodifiableList(services);
    return newServices;
  }
  public void setServices(List<Service> servicess) {
	   this.services = servicess;
	   
}
  public Service getService(int index)
  {
    Service aService = services.get(index);
    return aService;
  }
  
  
  

  private List<Appointment> appointments;
  @ManyToMany(cascade={CascadeType.ALL})
  public List<Appointment> getAppointments()
  {
    List<Appointment> newAppointments = Collections.unmodifiableList(appointments);
    return newAppointments;
  }
  public void setAppointment(List<Appointment> appointmentss) {
	   this.appointments = appointmentss;
	   
}

  
  

  private List<Account> accounts;

  
  @ManyToMany(cascade={CascadeType.ALL})
  public List<Account> getAccounts()
  {
    List<Account> newAccounts = Collections.unmodifiableList(accounts);
    return newAccounts;
  }
  public void setAccount(List<Account> accountss) {
	   this.accounts = accountss;
	   
}
  
  private int id;

  public void setId(int value) {
  this.id = value;
      }
  @Id
  public int getId() {
  return this.id;
         }
}