package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.Collections;
import java.util.List;

import ca.mcgill.ecse321.projectgroup15.model.TechnicianRole;

public class TechnicianDto {

	
	private TechnicianRole technicianRole;
	 private String email;
	  private String username;
	  private String password;
	  private String firstName;
	  private String lastName;

	private List<TimeSlotDto> timeSlots;
	private List<AppointmentDto> appointments; //we do not need to import the AppointmentDto because it is in the same package
	//private List<TechnicianRoleDto> roles;

	//First constructor
	public TechnicianDto() {
	}

	
	


	public String getUsername() {
		return username;
	}
	
	@SuppressWarnings("unchecked") // because the Collection the Appointment list needs to be empty at the start.


	/**
	 * @param technicianRole
	 * @param email
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public TechnicianDto(TechnicianRole technicianRole, String email, String username, String password,
			String firstName, String lastName) {
		super();
		this.technicianRole = technicianRole;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.timeSlots = Collections.EMPTY_LIST;
		this.appointments = Collections.EMPTY_LIST;
	}

	/**
	 * @param technicianRole
	 * @param email
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param timeSlots
	 * @param appointments
	 */
	public TechnicianDto(TechnicianRole technicianRole, String email, String username, String password,
			String firstName, String lastName, List<TimeSlotDto> timeSlots, List<AppointmentDto> appointments) {
		super();
		this.technicianRole = technicianRole;
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.timeSlots = timeSlots;
		this.appointments = appointments;
	}

	/**
	 * @return the technicianRole
	 */
	public TechnicianRole getTechnicianRole() {
		return technicianRole;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
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

