package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.Collections;
import java.util.*;
import java.util.List;

public class AppointmentDto {

	private int id;
//	private TimeSlotDto ts;
	private static TimeSlotDto ts;
	private List<ServiceDto> services;
	private List<TechnicianDto> technicians;

	
	//First Controller
	public AppointmentDto() {
	}
	@SuppressWarnings("unchecked") // because the Collection the Services list needs to be empty at the start.
	
	//Third Controller
	public AppointmentDto(int id, TimeSlotDto ts, List<ServiceDto> arrayList, List<TechnicianDto> arrayList2){
		this.id = id;
		this.ts = ts;
		this.services = arrayList;
		this.technicians = arrayList2;
	}
	public int getId() {
		return id;
	}
	
	public TimeSlotDto getTimeSlot() {
		return ts;
	}
	//Get all the services required for an appointment
	public List<ServiceDto> getServices(){
		return services;
	}
	
	//public void setServices(List<ServiceDto> services) {
	//	this.services = services;
	//}
	
	public List<TechnicianDto> getTechnicians() {
		return technicians;
	}
	
//	public void setTechnicians(List<TechnicianDto> events) {
//		this.technicians = technicians;
//	} 
	
	//public void setTechnicians()
}
