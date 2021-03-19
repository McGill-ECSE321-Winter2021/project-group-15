package ca.mcgill.ecse321.projectgroup15.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

@Entity
public class TimeSlot
{
  //TimeSlot Attributes
  private Date date;
  private Time startTime;
  private Time endTime;
  private int id;

  //TimeSlot Associations
  private RepairShop repairShop;
  private Technician technician;
  private Services service;
  
  
  
  @ManyToOne()
  @JoinColumn(name = "services_id", referencedColumnName = "id", insertable=false, updatable=false) 
public Services getService() {
	return service;
}

public void setService(Services service) {
	this.service = service;
}

@ManyToOne
  public Technician getTechnician() {
	return technician;
}

public void setTechnician(Technician technician) {
	this.technician = technician;
}

public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public Time getStartTime() {
    return startTime;
  }

  public void setStartTime(Time startTime) {
    this.startTime = startTime;
  }

  public Time getEndTime() {
    return endTime;
  }

  public void setEndTime(Time endTime) {
    this.endTime = endTime;
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