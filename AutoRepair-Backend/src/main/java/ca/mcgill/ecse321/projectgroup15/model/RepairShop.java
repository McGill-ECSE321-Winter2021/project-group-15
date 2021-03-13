package ca.mcgill.ecse321.projectgroup15.model;

import java.util.*;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.*;

@Entity
public class RepairShop
{
  private String id;

  //RepairShop Associations
  private List<TimeSlot> timeSlots;
  
  private List<Person> persons;
  private List<Payment> payments;
  private List<Service> services;
  private List<Appointment> appointments;


  @OneToMany(mappedBy = "repairShop",cascade = {CascadeType.ALL})
  public List<TimeSlot> getTimeSlots() {
    return timeSlots;
  }

  public void setTimeSlots(List<TimeSlot> timeSlots) {
    this.timeSlots = timeSlots;
  }

  @OneToMany(mappedBy = "repairShop",cascade = {CascadeType.ALL})
  public List<Person> getPersons() {
    return persons;
  }

  public void setPersons(List<Person> persons) {
    this.persons = persons;
  }
  @OneToMany(mappedBy = "repairShop",cascade = {CascadeType.ALL})
  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> Payments) {
    this.payments = Payments;
  }
  @OneToMany(mappedBy = "repairShop",cascade = {CascadeType.ALL})
  public List<Service> getServices() {
    return services;
  }

  public void setServices(List<Service> services) {
    this.services = services;
  }

  @OneToMany(mappedBy = "repairShop",cascade = {CascadeType.ALL})
  public List<Appointment> getAppointments() {
    return appointments;
  }

  public void setAppointments(List<Appointment> appointments) {
    this.appointments = appointments;
  }

  public void setId(String ID) {
    this.id = ID;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public String getId() {
    return id;
  }
}