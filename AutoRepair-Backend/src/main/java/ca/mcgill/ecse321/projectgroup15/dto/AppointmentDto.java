package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.Collections;
import java.util.List;

public class AppointmentDto {

	private int id;
	private List<ServiceDto> services;
	
	//First Controller
	public AppointmentDto() {
	}
	@SuppressWarnings("unchecked") // because the Collection the Services list needs to be empty at the start.

	//Second Controller
	public AppointmentDto(int id) {
		this(id, Collections.EMPTY_LIST);
	}
	
	//Third Controller
	public AppointmentDto(int id, List<ServiceDto> arrayList){
		this.id = id;
		this.services = arrayList;
	}
	
	//Get all the services required for an appointment
	public List<ServiceDto> getServices(){
		return services;
	}
	
	public void setServices(List<ServiceDto> services) {
		this.services = services;
	}
}
