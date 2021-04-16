package ca.mcgill.ecse321.projectgroup15.model;

import java.sql.Date;
import java.sql.Time;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TimeSlot
{
  //TimeSlot Attributes
	@JsonFormat(pattern="yyyy-MM-dd")	
  private Date date;
	@JsonFormat(pattern="HH:mm")
  private Time startTime;
	@JsonFormat(pattern="HH:mm")
  private Time endTime;
  private int id;

  //TimeSlot Associations
  private RepairShop repairShop;
  private Technician technician;
  private Services service;
  
  private Appointment appointments;
  
  
  @OneToOne
  public Appointment getAppointments() {
	return appointments;
}

public void setAppointments(Appointment appointments) {
	this.appointments = appointments;
}
  
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