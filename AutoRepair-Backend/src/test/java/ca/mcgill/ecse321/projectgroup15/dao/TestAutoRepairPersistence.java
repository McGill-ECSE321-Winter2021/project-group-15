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
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
	private TimeSlotRepository timeSlotRepository;
	
	@AfterEach
	public void clearDatabase() {
		
		assistantRepository.deleteAll();
		customerRepository.deleteAll();
		technicianRepository.deleteAll();
		accountRepository.deleteAll();
		appointmentRepository.deleteAll();
		paymentRepository.deleteAll();
		serviceRepository.deleteAll();
		timeSlotRepository.deleteAll();
		
		
	}
	
	@Test
	public void PersistAndLoadAccount() {
		
		AutoRepairShop auto = new AutoRepairShop();
		
		Technician tech = new Technician("xsd","213","cccwed","xdewdw",auto,5,"maintenance");
		tech.setFirstName("d");
		tech.setLastName("sdd");
		tech.setRole("oil change");
		tech.setPhoneNo("514");
		tech.setUserId("helo");
		tech.setRating(8);
		
		String email = "123@mail.mcgill.ca";
		String password = "123";
		Account account = new Account();
		account.setEmail(email);
		account.setPassword(password);
		
		account.setUser(tech);
		accountRepository.save(account);
		
		account = null;
		
		account = accountRepository.findAccountByEmail(email);
		
		assertNotNull(account);
		assertEquals(email,account.getEmail());
		assertEquals(password,account.getPassword());
		assertEquals(tech.getFirstName(),account.getUser().getFirstName());
		assertEquals(tech.getUserId(),account.getUser().getUserId());
		assertEquals(tech.getLastName(),account.getUser().getLastName());
		
		assertEquals(tech.getPhoneNo(),account.getUser().getPhoneNo());
	
	}
	
	@Test
	public void PersistAndLoadTechnician() {
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		Technician tech = new Technician("xsd","213","cccwed","xdewdw",auto,5,"maintenance");
		
		String techId = "789";
		String role = "oil change";
		String lastName = "sdd";
		String firstName = "x";
		String phoneNumber = "388";
		int rating = 4;
		tech.setFirstName(firstName);
		tech.setLastName(lastName);
		tech.setRole(role);
		tech.setPhoneNo(phoneNumber);
		tech.setUserId(techId);
		tech.setRating(rating);
		
		technicianRepository.save(tech);
		
		tech = null;
		tech = technicianRepository.findTechnicianByTechnicianID(techId);
		assertNotNull(tech);
		assertEquals(techId,tech.getUserId());
		assertEquals(role,tech.getRole());
		assertEquals(firstName,tech.getFirstName());
		assertEquals(lastName,tech.getLastName());
		assertEquals(phoneNumber,tech.getPhoneNo());
		assertEquals(rating,tech.getRating());
		
		
	}
	
	@Test
	public void PersistAndLoadAdministrativeAssistant() {
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		
		String adminId = "123";
		String lastName = "dsf";
		String phoneNumber = "514";
		AdministrativeAssistant assistant = new AdministrativeAssistant("xsd","213","cccwed","xdewdw",auto);
		assistant.setUserId(adminId);
		
		assistant.setLastName(lastName);
		assistant.setPhoneNo(phoneNumber);
		assistantRepository.save(assistant);
		
		assistant = null;
		
		assistant = assistantRepository.findAdministrativeAssistantByAdminID(adminId);
		
		assertNotNull(assistant);
		assertEquals(adminId,assistant.getUserId());
		assertEquals(lastName,assistant.getLastName());
		assertEquals(phoneNumber,assistant.getPhoneNo());
		
		
		
	}
	
	@Test
	public void PersistAndLoadAppointment() {
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		
		Technician tech = new Technician("xsd","213","cccwed","xdewdw",auto,5,"maintenance");
		tech.setFirstName("vrf");
		tech.setLastName("sdd");
		tech.setRole("oil change");
		tech.setPhoneNo("514");
		tech.setUserId("helo");
		tech.setRating(0);
		
		
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setDate(date);
		timeSlot.setEndTime(endTime);
		timeSlot.setStartTime(startTime);
		timeSlot.setTechnician(tech);
		String appointmentID = "45";
		Double totalCost = 34.55;
		
		Appointment appointment = new Appointment();
		appointment.setAppointmentID(appointmentID);
		appointment.setTimeSlot(timeSlot);
		//appointment.setTotalCost(totalCost);
		
		appointmentRepository.save(appointment);
		
		appointment = null;
		
		appointment = appointmentRepository.findApointmentByAppointmentID(appointmentID);
		
		assertNotNull(appointment);
		assertEquals(appointmentID,appointment.getAppointmentID());
	
		assertEquals(timeSlot.getDate(),appointment.getTimeSlot().getDate());
		assertEquals(timeSlot.getEndTime(),appointment.getTimeSlot().getEndTime());
		assertEquals(timeSlot.getStartTime(), appointment.getTimeSlot().getStartTime());
		//assertEquals(totalCost,appointment.getTotalCost());
		
	}
	
	@Test
	public void PersistAndLoadTimeSlot() {
		
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
       
        
        Technician tech = new Technician("xsd","213","cccwed","xdewdw",auto,5,"maintenance");
        tech.setFirstName("de");
		tech.setLastName("sdd");
		tech.setRole("oil change");
		tech.setPhoneNo("514");
		tech.setUserId("helo");
		tech.setRating(0);
		
		
		
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		String id = "cdde";
	
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setDate(date);
		timeSlot.setEndTime(endTime);
		timeSlot.setStartTime(startTime);
		timeSlot.setTsId(id);
		timeSlot.setTechnician(tech);
		timeSlotRepository.save(timeSlot);
		
        
		
		timeSlot = null;
		
		timeSlot = timeSlotRepository.findTimeSlotByTsId(id);
		
		assertNotNull(timeSlot);
		assertEquals(date, timeSlot.getDate());
		assertEquals(startTime,timeSlot.getStartTime());
		assertEquals(endTime,timeSlot.getEndTime());
		assertEquals(tech.getFirstName(),timeSlot.getTechnician().getFirstName());
		assertEquals(tech.getLastName(),timeSlot.getTechnician().getLastName());
		assertEquals(tech.getRole(),timeSlot.getTechnician().getRole());
		assertEquals(tech.getPhoneNo(),timeSlot.getTechnician().getPhoneNo());
		assertEquals(tech.getUserId(),timeSlot.getTechnician().getUserId());
		assertEquals(tech.getRating(),timeSlot.getTechnician());
		
		
	}
	
	@Test
	public void PersistAndLoadCustomer() {
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		
		 Technician tech = new Technician("xsd","213","cccwed","xdewdw",auto,5,"maintenance");
	        tech.setFirstName("de");
			tech.setLastName("sdd");
			tech.setRole("oil change");
			tech.setPhoneNo("514");
			tech.setUserId("helo");
			tech.setRating(0);
		
		
		String username = "saa";
		String lastName = "xsdw";
		String phoneNumber = "344";
		String userId = "dededw";
		
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setDate(date);
		timeSlot.setEndTime(endTime);
		timeSlot.setStartTime(startTime);
		
         String appointmentID = "45";
		
		Appointment appointment = new Appointment();
		appointment.setAppointmentID(appointmentID);
		
		
		Service service = new Service();
		String serviceType = "oil change";
		service.setServiceType(serviceType);
		
		Customer customer = new Customer("xsdw","900","defe","dttgtg",auto);
		
		customer.setFirstName(username);
		customer.setLastName(lastName);
		customer.setUserId(userId);
		customer.setPhoneNo(phoneNumber);
		customer.setAppointment(appointment);
		
		
		customerRepository.save(customer);
		
		customer = null;
		
		customer = customerRepository.findByCustomerAndAppointment(username,"45");
		
		assertNotNull(customer);
		assertEquals(username,customer.getFirstName());
		assertEquals(lastName,customer.getLastName());
		assertEquals(phoneNumber,customer.getPhoneNo());
		assertEquals(userId,customer.getUserId());
	
		assertEquals(appointment.getAppointmentID(),customer.getAppointment().getAppointmentID());	
		
	}
	
	@Test
	public void PersistAndLoadService() {
		
		AutoRepairShop auto = new AutoRepairShop();
		AutoRepairShop auto2 = new AutoRepairShop();
		
		Service service = new Service();
		String serviceType = "oil change";
		Double totalCost = 34.55;
		service.setServiceType(serviceType);
		
		//service.setServiceCost(totalCost);
		serviceRepository.save(service);
		
		service = null;
		
		service = serviceRepository.findSerivceByServiceType(serviceType);
		
		assertNotNull(service);
		assertEquals(serviceType,service.getServiceType());
	
		//assertEquals(totalCost,service.getServiceCost());
		
	}
	
	@Test
	public void PersistAndLoadPayment() {
		
		String cardName = "xsdwd";
		String cardNumber = "1234";
		String expirationDate = "234343";
		int cvc = 8;
		String paymentId = "kfrj";
		
		Payment payment = new Payment();
		payment.setCardName(cardName);
		payment.setCardNumber(cardNumber);
		payment.setExpirationDate(expirationDate);
		payment.setCvc(cvc);
		payment.setPaymentId(paymentId);
		paymentRepository.save(payment);
		
		payment = null;
		
		payment = paymentRepository.findPaymentByPaymentId(paymentId);
		
		assertNotNull(payment);
		assertEquals(cardName,payment.getCardName());
		assertEquals(cardNumber,payment.getCardNumber());
		assertEquals(expirationDate, payment.getExpirationDate());
		assertEquals(cvc, payment.getCvc());
		assertEquals(paymentId,payment.getPaymentId());
	}

}

