package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.Collections;
import java.util.List;


public class AdministratorDto {

	
	 private String email;
	  private String username;
	  private String password;
	  private String firstName;
	  private String lastName;

	private List<TimeSlotDto> timeSlots;

	//First constructor
	public AdministratorDto() {
	}

	
	


	public String getUsername() {
		return username;
	}
	
	@SuppressWarnings("unchecked")
	/**
	 * @param email
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 */
	public AdministratorDto( String email, String username, String password,
			String firstName, String lastName) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.timeSlots = Collections.EMPTY_LIST;
	}

	/**
	 * @param email
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param timeSlots
	 */
	public AdministratorDto( String email, String username, String password,
			String firstName, String lastName, List<TimeSlotDto> timeSlots, List<AppointmentDto> appointments) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.timeSlots = timeSlots;
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

	// get all the available timeSlots of a Administrator
	public List<TimeSlotDto> getTimeSlots() {
		return timeSlots;
	}

	public void setTimeSlots(List<TimeSlotDto> timeSlots) {
		this.timeSlots = timeSlots;
	}

	
}

