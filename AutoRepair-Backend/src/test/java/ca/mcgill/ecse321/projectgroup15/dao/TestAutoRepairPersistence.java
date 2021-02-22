package ca.mcgill.ecse321.projectgroup15.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ca.mcgill.ecse321.projectgroup15.model.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestAutoRepairPersistence {
	
	@Autowired 
	private AdministrativeAssistantRepository assistantRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TechnicianRepository technicianRepository;
	
	@AfterEach
	public void clearDatabase() {
		
		assistantRepository.deleteAll();
		customerRepository.deleteAll();
		technicianRepository.deleteAll();
		
	}
	
	@Test
	public void PersistAndLoadAccount() {
		
		AutoRepairShop auto = new AutoRepairShop();
		Technician tech = new Technician("xsd","213",auto,"123",5,"maintenance");
		tech.setLastName("sdd");
		
		tech.setRole("oil change");
		tech.setPhoneNo("514");
		tech.setTechnicianID("csd");
		tech.setAutoRepairShop(auto);
		String email = "123@mail.mcgill.ca";
		String password = "123";
		Account account = new Account("email","password",tech,auto);
		account.setEmail(email);
		account.setPassword(password);
		account.setAutoRepairShop(auto);
		account.setUser(tech);
		
		account = null;
		
		assertNotNull(account);
		assertEquals(email,account.getEmail());
		assertEquals(password,account.getPassword());
		assertEquals(tech.getLastName(),account.getUser().getLastName());
		assertEquals(tech.getAutoRepairShop(),account.getUser().getAutoRepairShop());
		assertEquals(tech.getPhoneNo(),account.getUser().getPhoneNo());
		assertEquals(auto,account.getAutoRepairShop());
	}
	
	@Test
	public void PersistAndLoadTechnician() {
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		Technician tech = new Technician("xsd","213",auto,"123",5,"maintenance");
		
		String techId = "789";
		String role = "oil change";
		String lastName = "sdd";
		String phoneNumber = "388";
		int rating = 4;
		tech.setLastName(lastName);
		tech.setRole(role);
		tech.setPhoneNo(phoneNumber);
		tech.setTechnicianID(techId);
		tech.setAutoRepairShop(auto2);
		technicianRepository.save(tech);
		
		tech = null;
		tech = technicianRepository.findTechnicianByTechnicianID(techId);
		assertNotNull(tech);
		assertEquals(techId,tech.getTechnicianID());
		assertEquals(role,tech.getRole());
		assertEquals(lastName,tech.getLastName());
		assertEquals(phoneNumber,tech.getPhoneNo());
		assertEquals(rating,tech.getRating());
		assertEquals(auto,tech.getAutoRepairShop());
		
	}
	
	@Test
	public void PersistAndLoadAdministrativeAssistant() {
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		
		String adminId = "123";
		String lastName = "dsf";
		String phoneNumber = "514";
		AdministrativeAssistant assistant = new AdministrativeAssistant("dss","456",auto,"32");
		assistant.setAdminID(adminId);
		assistant.setAutoRepairShop(auto2);
		assistant.setLastName(lastName);
		assistant.setPhoneNo(phoneNumber);
		assistantRepository.save(assistant);
		
		assistant = null;
		
		assistant = assistantRepository.findAdministrativeAssistantByAdminID(adminId);
		
		assertNotNull(assistant);
		assertEquals(adminId,assistant.getAdminID());
		assertEquals(lastName,assistant.getLastName());
		assertEquals(phoneNumber,assistant.getPhoneNo());
		assertEquals(auto2,assistant.getAutoRepairShop());
		
		
	}
	
	@Test
	public void PersistAndLoadAppointment() {
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		TimeSlot timeSlot = new TimeSlot(date,startTime,endTime,"id",auto);
		timeSlot.setDate(date);
		timeSlot.setEndTime(endTime);
		timeSlot.setStartTime(startTime);
		String appointmentID = "45";
		
		Appointment appointment = new Appointment("67",timeSlot,auto2);
		appointment.setAppointmentID(appointmentID);
		appointment.setAutoRepairShop(auto2);
		
		appointment = null;
		
		assertNotNull(appointment);
		assertEquals(appointmentID,appointment.getAppointmentID());
		assertEquals(auto2,appointment.getAutoRepairShop());
		assertEquals(timeSlot.getDate(),appointment.getTimeSlot().getDate());
		assertEquals(timeSlot.getEndTime(),appointment.getTimeSlot().getEndTime());
		assertEquals(timeSlot.getStartTime(), appointment.getTimeSlot().getStartTime());
		
	}
	
	@Test
	public void PersistAndLoadTimeSlot() {
		
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
        String appointmentID = "45";
		
		
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		Appointment appointment = new Appointment("67",date,startTime,endTime,auto);
		appointment.setAppointmentID(appointmentID);
		appointment.setAutoRepairShop(auto2);
		TimeSlot timeSlot = new TimeSlot(java.sql.Date.valueOf(LocalDate.of(2020, Month.FEBRUARY, 31)),java.sql.Time.valueOf(LocalTime.of(21, 45)),java.sql.Time.valueOf(LocalTime.of(22, 65)),appointment);
		timeSlot.setDate(date);
		timeSlot.setEndTime(endTime);
		timeSlot.setStartTime(startTime);
		
		timeSlot = null;
		
		assertNotNull(timeSlot);
		assertEquals(date, timeSlot.getDate());
		assertEquals(startTime,timeSlot.getStartTime());
		assertEquals(endTime,timeSlot.getEndTime());
		assertEquals(appointment.getAppointmentID(),timeSlot.getAppointment().getAppointmentID());
		assertEquals(appointment.getAutoRepairShop(),timeSlot.getAppointment().getAutoRepairShop());
		
	}
	
	@Test
	public void PersistAndLoadCustomer() {
		
		String username = "saa";
		String phoneNumber = "344";
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		Appointment appointment = new Appointment("67",date,startTime,endTime,auto);
		appointment.setAppointmentID("45");
		appointment.setAutoRepairShop(auto2);
		Service service = new Service("maintenance",auto);
		String serviceType = "oil change";
		service.setServiceType(serviceType);
		service.setAutoRepairShop(auto2);
		Customer customer = new Customer("xsdw","900",auto,"opp",appointment,service);
		
		customer.setUsername(username);
		customer.setPhoneNo(phoneNumber);
		customer.setAppointment(appointment);
		customer.setAutoRepairShop(auto2);
		customer.setDesiredService(service);
		customerRepository.save(customer);
		
		customer = null;
		
		customer = customerRepository.findByCustomerAndAppointment(username,"45");
		
		assertNotNull(customer);
		assertEquals(username,customer.getUsername());
		assertEquals(phoneNumber,customer.getPhoneNo());
		assertEquals(auto2,customer.getAutoRepairShop());
		assertEquals(appointment.getAppointmentID(),customer.getAppointment().getAppointmentID());	
		
	}
	
	@Test
	public void PersistAndLoadService() {
		
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		
		Service service = new Service("maintenance",auto);
		String serviceType = "oil change";
		service.setServiceType(serviceType);
		service.setAutoRepairShop(auto2);
		
		service = null;
		
		assertNotNull(service);
		assertEquals(serviceType,service.getServiceType());
		assertEquals(auto2,service.getAutoRepairShop());
		
	}
	
	@Test
	public void PersistAndLoadPayment() {
		
		String cardName = "xsdwd";
		String cardNumber = "1234";
		String expirationDate = "234343";
		int cvc = 8;
		
		Payment payment = new Payment("gh","098","09",0);
		payment.setCardName(cardName);
		payment.setCardNumber(cardNumber);
		payment.setExpirationDate(expirationDate);
		payment.setCvc(cvc);
		
		payment = null;
		
		assertNotNull(payment);
		assertEquals(cardName,payment.getCardName());
		assertEquals(cardNumber,payment.getCardNumber());
		assertEquals(expirationDate, payment.getExpirationDate());
		assertEquals(cvc, payment.getCvc());
	}

}

