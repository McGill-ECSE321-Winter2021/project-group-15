package ca.mcgill.ecse321.projectgroup15.model;

import java.sql.Date;
import java.util.*;
import javax.persistence.*;

@Entity
public class Payment
{
  private Date date;
  private float totalCost;

  //Payment Associations
  private RepairShop repairShop;
  private Customer customer;
  private List<Appointment> appointments;
  private Long id;

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public float getTotalCost() {
    return totalCost;
  }

  public void setTotalCost(float totalCost) {
    this.totalCost = totalCost;
  }

  @ManyToOne
  public RepairShop getRepairShop() {
    return repairShop;
  }

  public void setRepairShop(RepairShop repairShop) {
    this.repairShop = repairShop;
  }

  @ManyToOne
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @OneToMany(mappedBy = "payment",cascade = {CascadeType.ALL})
  public List<Appointment> getAppointments() {
    return appointments;
  }

  public void setAppointments(List<Appointment> appointments) {
    this.appointments = appointments;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }
}