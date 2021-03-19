package ca.mcgill.ecse321.projectgroup15.model;

import javax.persistence.*;

@Entity
public class Appointment
{
  private Services service;
  private Customer customer;
  private Technician technician;
  private TimeSlot timeslot;
  private Payment payment;
  private RepairShop repairShop;
  private int id;

  
  @ManyToOne()
  @JoinColumn(name = "technician_id", referencedColumnName = "id", insertable=false, updatable=false) 
  public Technician getTechnician() {
	return technician;
}

public void setTechnician(Technician technician) {
	this.technician = technician;
}

@ManyToOne()
@JoinColumn(name = "services_id", referencedColumnName = "id", insertable=false, updatable=false) 
  public Services getService() {
    return service;
  }

  public void setService(Services service) {
    this.service = service;
  }

  @ManyToOne()
  @JoinColumn(name = "customer_id", referencedColumnName = "id", insertable=false, updatable=false) 
  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @ManyToOne()
  @JoinColumn(name = "timeslot_id", referencedColumnName = "id", insertable=false, updatable=false) 
  public TimeSlot getTimeslot() {
    return timeslot;
  }

  public void setTimeslot(TimeSlot timeslot) {
    this.timeslot = timeslot;
  }

  @ManyToOne()
  @JoinColumn(name = "payment_id", referencedColumnName = "id", insertable=false, updatable=false) 
  public Payment getPayment() {
    return payment;
  }

  public void setPayment(Payment payment) {
    this.payment = payment;
  }

  @ManyToOne(cascade = {CascadeType.ALL})
  public RepairShop getRepairShop() {
    return repairShop;
  }

  public void setRepairShop(RepairShop repairShop) {
    this.repairShop = repairShop;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getId() {
    return id;
  }
}