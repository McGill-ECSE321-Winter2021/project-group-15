package ca.mcgill.ecse321.projectgroup15.dto;

import java.sql.Date;
import java.sql.Time;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TimeSlotDto {
	private int id;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	@JsonFormat(pattern="HH:mm")
	private Time startTime;
	@JsonFormat(pattern="HH:mm")
	private Time endTime;

	public TimeSlotDto() {	
	}
	
	public TimeSlotDto(int id) {
		this(id, Date.valueOf("2020-01-01"),Time.valueOf("00:00:00"),Time.valueOf("00:00:00"));
	}
	
	public TimeSlotDto(int id, Date date, Time startTime, Time endTime) {
		this.id = id;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Time getStartTime() {
		return startTime;
	}
	
	public Time getEndTime() {
		return endTime;
	}
	
	
}
