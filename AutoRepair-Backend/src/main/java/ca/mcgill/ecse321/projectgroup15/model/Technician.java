package ca.mcgill.ecse321.projectgroup15.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
public class Technician extends User
{

  //Technician Attributes
  private int rating;
  private String role;

  //Technician Associations
  private List<Service> expertise;
  private List<Appointment> assignment;

 
  public Technician(String aLastName, String aPhoneNo, String aFirstName, String aUserId, AutoRepairShop aAutoRepairShop, int aRating, String aRole)
  {
    super(aLastName, aPhoneNo, aFirstName, aUserId, aAutoRepairShop);
    rating = aRating;
    role = aRole;
    expertise = new ArrayList<Service>();
    assignment = new ArrayList<Appointment>();
  }

  public boolean setRating(int aRating)
  {
    boolean wasSet = false;
    rating = aRating;
    wasSet = true;
    return wasSet;
  }

  public boolean setRole(String aRole)
  {
    boolean wasSet = false;
    role = aRole;
    wasSet = true;
    return wasSet;
  }

  public int getRating()
  {
    return rating;
  }

  public String getRole()
  {
    return role;
  }
  /* Code from template association_GetMany */
 
@ManyToMany()
  public List<Service> getExpertise()
  {
    List<Service> newExpertise = Collections.unmodifiableList(expertise);
    return newExpertise;
  }
public void setService(List<Service> expertisess) {
	   this.expertise = expertisess;
}

  
  /* Code from template association_GetMany */
  
@ManyToMany()
  public List<Appointment> getAssignment()
  {
    List<Appointment> newAssignment = Collections.unmodifiableList(assignment);
    return newAssignment;
  }
public void setAppointment(List<Appointment> assignmentss) {
	   this.assignment = assignmentss;
}
 
  
   
  
 
}