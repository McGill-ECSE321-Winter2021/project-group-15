package ca.mcgill.ecse321.projectgroup15.dto;

import java.util.Collections;
import java.util.List;

public class CustomerDto {
	private String username;
	private List<AppointmentDto> appointments; //we do not need to import the AppointmentDto because it is in the same package
	private List<PaymentDto> payments; // need to add in constructor 
	
	//First Constructor
	public CustomerDto() {
	}
	
	@SuppressWarnings("unchecked") // because the Collection the Appointment list needs to be empty at the start.

	//Second Constructor 
	public CustomerDto(String username) {
		this(username, Collections.EMPTY_LIST, Collections.EMPTY_LIST);
	}
	
	//Third Constructor
	public CustomerDto(String username, List<AppointmentDto> arrayList, List<PaymentDto> arrayList1) {
		this.username = username;
		this.appointments = arrayList;
		this.payments = arrayList1; 
	}
	
	public String getUsername() {
		return username;
	}
		
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
