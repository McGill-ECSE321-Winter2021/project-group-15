package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.List;

import ca.mcgill.ecse321.projectgroup15.model.ServiceType;

import java.util.Collections;

public class ServiceDto {

	private String id;
	private String name;
	  private float cost;
	  private int duration;
	

	private ServiceType serviceType;
	private List<TimeSlotDto> timeSlots;
	private List<TechnicianDto> technicians;
	
	//First Constructor
	public ServiceDto() {	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	public String getId() {
		return id;
	}
	
	
	/**
	 * @param id
	 * @param name
	 * @param cost
	 * @param duration
	 * @param serviceType
	 * @param timeSlots
	 * @param technicians
	 */
	public ServiceDto(String id, String name, float cost, int duration, ServiceType serviceType,
			List<TimeSlotDto> timeSlots, List<TechnicianDto> technicians) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.duration = duration;
		this.serviceType = serviceType;
		this.timeSlots = timeSlots;
		this.technicians = technicians;
	}
	
	
	




	@SuppressWarnings("unchecked")

	/**
	 * @param id
	 * @param name
	 * @param cost
	 * @param duration
	 * @param serviceType
	 */
	public ServiceDto(String id, String name, float cost, int duration, ServiceType serviceType) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.duration = duration;
		this.serviceType = serviceType;
		this.timeSlots = Collections.EMPTY_LIST;
		this.technicians = Collections.EMPTY_LIST;
	}






	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}






	/**
	 * @return the cost
	 */
	public float getCost() {
		return cost;
	}






	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}






	public ServiceType getServiceType() {
		return serviceType;
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
