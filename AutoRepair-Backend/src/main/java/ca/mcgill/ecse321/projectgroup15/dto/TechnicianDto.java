package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.Collections;
import java.util.List;

public class TechnicianDto {

	private String username;
	private List<TimeSlotDto> timeSlots;
	private List<AppointmentDto> appointments; //we do not need to import the AppointmentDto because it is in the same package
	//private List<TechnicianRoleDto> roles;

	//First constructor
	public TechnicianDto() {
	}

	@SuppressWarnings("unchecked") // because the Collection the Appointment list needs to be empty at the start.

	//Second Constructor
	public TechnicianDto(String username) {
		this(username, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
	}


	//Third Constructor
	public TechnicianDto(String username, List<AppointmentDto> arrayList,List<TimeSlotDto> arrayList1 ) {
		this.username = username;
		this.appointments = arrayList;
		this.timeSlots = arrayList1;
	}


	public String getUsername() {
		return username;
	}

	// get all the available timeSlots of a technician
	public List<TimeSlotDto> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlotDto> timeSlots) {
		this.timeSlots = timeSlots;
	}

	// get all the appointments a technician has
	public List<AppointmentDto> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<AppointmentDto> appointments) {
		this.appointments = appointments;
	}
}

