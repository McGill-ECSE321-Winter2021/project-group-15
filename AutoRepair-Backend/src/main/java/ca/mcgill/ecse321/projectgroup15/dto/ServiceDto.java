package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.List;
import java.util.Collections;

public class ServiceDto {

	private String id;
	private List<TimeSlotDto> timeSlots;
	private List<TechnicianDto> technicians;
	
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
//	
//	public ServiceDto(String id, List<TechnicianDto> arrayList1) {
//		this.id = id;
//		this.technicians = arrayList1;
//	}
	
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
	
	//Get all the technicians that are specified in a service
	public List<TechnicianDto> getTechnicians(){
		return technicians;
	}
	
	public void setTechnicians(List<TechnicianDto> technicians) {
		this.technicians = technicians;
	}
}
