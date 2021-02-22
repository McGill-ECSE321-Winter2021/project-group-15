package ca.mcgill.ecse321.projectgroup15.model;

/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.sql.Date;
import java.sql.Time;

import javax.persistence.Entity;
import javax.persistence.Id;

// line 61 "model.ump"
// line 141 "model.ump"
@Entity
public class TimeSlot
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TimeSlot Attributes
  private Date date;
  private Time startTime;
  private Time endTime;
  private String tsId;

  //TimeSlot Associations
  private Appointment appointment;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TimeSlot(Date aDate, Time aStartTime, Time aEndTime, String aTsId, Appointment aAppointment)
  {
    date = aDate;
    startTime = aStartTime;
    endTime = aEndTime;
    tsId = aTsId;
    if (aAppointment == null || aAppointment.getTimeSlot() != null)
    {
      throw new RuntimeException("Unable to create TimeSlot due to aAppointment. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    appointment = aAppointment;
  }

  public TimeSlot(Date aDate, Time aStartTime, Time aEndTime, String aTsId, String aAppointmentIDForAppointment)
  {
    date = aDate;
    startTime = aStartTime;
    endTime = aEndTime;
    tsId = aTsId;
    appointment = new Appointment(aAppointmentIDForAppointment, this);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDate(Date aDate)
  {
    boolean wasSet = false;
    date = aDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartTime(Time aStartTime)
  {
    boolean wasSet = false;
    startTime = aStartTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndTime(Time aEndTime)
  {
    boolean wasSet = false;
    endTime = aEndTime;
    wasSet = true;
    return wasSet;
  }

  public boolean setTsId(String aTsId)
  {
    boolean wasSet = false;
    tsId = aTsId;
    wasSet = true;
    return wasSet;
  }

  public Date getDate()
  {
    return date;
  }

  public Time getStartTime()
  {
    return startTime;
  }

  public Time getEndTime()
  {
    return endTime;
  }
@Id
  public String getTsId()
  {
    return tsId;
  }
  /* Code from template association_GetOne */
  public Appointment getAppointment()
  {
    return appointment;
  }

  public void delete()
  {
    Appointment existingAppointment = appointment;
    appointment = null;
    if (existingAppointment != null)
    {
      existingAppointment.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "tsId" + ":" + getTsId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endTime" + "=" + (getEndTime() != null ? !getEndTime().equals(this)  ? getEndTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "appointment = "+(getAppointment()!=null?Integer.toHexString(System.identityHashCode(getAppointment())):"null");
  }
}