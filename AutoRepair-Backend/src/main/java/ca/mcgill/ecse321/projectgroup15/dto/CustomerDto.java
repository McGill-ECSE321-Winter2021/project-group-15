package ca.mcgill.ecse321.projectgroup15.dto;

import java.sql.Date;
import java.time.Month;
import java.time.Year;
import java.util.Collections;
import java.util.List;

public class CustomerDto  {
	
	//I extended the personDto to get all the parameters
	
	private String email;
	  private String username;
	  private String password;
	  private String firstName;
	  private String lastName;
	  private String cardholderName;
	  private String cardNumber;
	  private String cvv;
	  private Month expiryMonth;
	  private Year expiryYear;

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public Month getExpiryMonth() {
		return expiryMonth;
	}

	public Year getExpiryYear() {
		return expiryYear;
	}
	private List<AppointmentDto> appointments; //we do not need to import the AppointmentDto because it is in the same package
	private List<PaymentDto> payments; // need to add in constructor 
	
	
	
	
	@SuppressWarnings("unchecked") // because the Collection the Appointment list needs to be empty at the start.
	
	/**
	 * @param email
	 * @param username
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param cardholderName
	 * @param cardNumber
	 * @param cvv
	 * @param expiry
	 * @param appointments
	 * @param payments
	 */
	public CustomerDto(String email, String username, String password, String firstName, String lastName, String cardholderName,
			String cardNumber, String cvv, Month expiryMonth, Year expiryYear, List<AppointmentDto> appointments, List<PaymentDto> payments) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardholderName = cardholderName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.appointments = Collections.EMPTY_LIST;
		this.payments = Collections.EMPTY_LIST;
	}

	

	//Second Constructor 
	
	
	@SuppressWarnings("unchecked") // because the Collection the Appointment list needs to be empty at the start.
	
		
	public CustomerDto(String email, String username, String password, String lastName, String firstName,
			String cardNumber, String cvv, Month expiryMonth, Year expiryYear) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.appointments = Collections.EMPTY_LIST;
		this.payments = Collections.EMPTY_LIST;
	}

	public CustomerDto(String cardholderName, String cardNumber, Month expiryMonth, Year expiryYear, String cvv) {
		super();
		this.cardholderName = cardholderName;
		this.cardNumber = cardNumber;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.cvv = cvv;

	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setCardNumber(String password) {
		this.password = password;
	}
	
	public void setCVV(String password) {
		this.password = password;
	}
	
	public void setExpiryMonth(Month expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	
	
	public void setExpiryYear(Year expiryYear) {
		this.expiryYear = expiryYear;
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
