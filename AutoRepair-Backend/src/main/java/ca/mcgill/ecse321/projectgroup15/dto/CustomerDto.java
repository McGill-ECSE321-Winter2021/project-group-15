package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.Collections;
import java.util.List;

public class CustomerDto extends PersonDto {
	
	//I extended the personDto to get all the parameters
	
	//private String username;
	private List<AppointmentDto> appointments; //we do not need to import the AppointmentDto because it is in the same package
	private List<PaymentDto> payments; // need to add in constructor 
	
	
	
	
	public CustomerDto(String email, String username, String password, String firstName, String lastName, int id) {
		super(email, username, password, firstName, lastName, id);
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(String email, String username, String password, String firstName, String lastName) {
		super(email, username, password, firstName, lastName);
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}

	public CustomerDto(String email, String username, String password, String firstName, String lastName, int id,
			List<AppointmentDto> appointments, List<PaymentDto> payments) {
		super(email, username, password, firstName, lastName, id);
		this.appointments = appointments;
		this.payments = payments;
	}

	@SuppressWarnings("unchecked") // because the Collection the Appointment list needs to be empty at the start.

	//Second Constructor 
	
	
	
	
		
	// get all the appointments a customer have
	public List<AppointmentDto> getAppointments() {
		return appointments;
	}
	
	public void setAppointments(List<AppointmentDto> appointments) {
		this.appointments = appointments;
	}
	
	// get all the appointments a customer have
	public List<PaymentDto> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDto> payments) {
		this.payments = payments;
	}

}
