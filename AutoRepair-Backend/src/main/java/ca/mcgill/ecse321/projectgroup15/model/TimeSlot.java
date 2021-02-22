package ca.mcgill.ecse321.projectgroup15.model;



import java.sql.Date;
import java.sql.Time;

import javax.persistence.Id;
import javax.persistence.OneToMany;


public class TimeSlot
{

  
  //TimeSlot Attributes
  private Date date;
  private Time startTime;
  private Time endTime;
  private String tsId;

  //TimeSlot Associations
  private Technician technician;



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
@OneToMany()
  public Technician getTechnician()
  {
    return technician;
  }
  /* Code from template association_SetUnidirectionalOne */
  public boolean setTechnician(Technician aNewTechnician)
  {
    boolean wasSet = false;
    if (aNewTechnician != null)
    {
      technician = aNewTechnician;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    technician = null;
  }


  public String toString()
  {
    return super.toString() + "["+
            "tsId" + ":" + getTsId()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "date" + "=" + (getDate() != null ? !getDate().equals(this)  ? getDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "startTime" + "=" + (getStartTime() != null ? !getStartTime().equals(this)  ? getStartTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endTime" + "=" + (getEndTime() != null ? !getEndTime().equals(this)  ? getEndTime().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "technician = "+(getTechnician()!=null?Integer.toHexString(System.identityHashCode(getTechnician())):"null");
  }
}