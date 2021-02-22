/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.1.5099.60569f335 modeling language!*/


import java.sql.Date;
import java.sql.Time;

// line 60 "model.ump"
// line 149 "model.ump"
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
  private Technician technician;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public TimeSlot(Date aDate, Time aStartTime, Time aEndTime, String aTsId, Technician aTechnician)
  {
    date = aDate;
    startTime = aStartTime;
    endTime = aEndTime;
    tsId = aTsId;
    if (!setTechnician(aTechnician))
    {
      throw new RuntimeException("Unable to create TimeSlot due to aTechnician. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
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

  public String getTsId()
  {
    return tsId;
  }
  /* Code from template association_GetOne */
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