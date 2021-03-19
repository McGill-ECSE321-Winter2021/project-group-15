/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/
package ca.mcgill.ecse321.projectgroup15.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.*;

@Entity
public class Customer extends Person
{
  //Customer Attributes
  private String cardNumber;
  private String cvv;
  private Date expiry;

  //Customer Associations
  private List<Payment> payments;
  private List<Appointment> appointments;

  public String getCardNumber() {
    return cardNumber;
  }

  


  

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCvv() {
    return cvv;
  }

  public void setCvv(String cvv) {
    this.cvv = cvv;
  }

  public Date getExpiry() {
    return expiry;
  }

  public void setExpiry(Date expiry) {
    this.expiry = expiry;
  }

  @OneToMany(mappedBy = "customer",cascade = {CascadeType.ALL})
  public List<Payment> getPayments() {
    return payments;
  }

  public void setPayments(List<Payment> Payments) {
    this.payments = Payments;
  }

  @OneToMany(mappedBy = "customer",cascade = {CascadeType.ALL})
  public List<Appointment> getAppointments() {
    return appointments;
  }

  public void setAppointments(List<Appointment> appointments) {
    this.appointments = appointments;
  }
}