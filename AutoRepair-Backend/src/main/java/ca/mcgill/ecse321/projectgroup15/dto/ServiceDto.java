package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.List;
import java.util.Collections;

public class ServiceDto {

	private String id;
	private List<TimeSlotDto> timeSlots;
	
	//First Constructor
	public ServiceDto() {	
	}
	@SuppressWarnings("unchecked")

	//Second Constructor
	public ServiceDto(String id) {
		this(id, Collections.EMPTY_LIST);
	}
	
	//Third Constructor
	public ServiceDto(String id, List<TimeSlotDto> arrayList) {
		this.id = id;
		this.timeSlots = arrayList;
	}
	
	public String getId() {
		return id;
	}
	
	//Get all the timeSlots available for a service
	public  List<TimeSlotDto> getTimeSlots(){
		return timeSlots;
	}
	
	public void setTimeSlots(List<TimeSlotDto> timeSlots) {
		this.timeSlots = timeSlots;
	}
}
