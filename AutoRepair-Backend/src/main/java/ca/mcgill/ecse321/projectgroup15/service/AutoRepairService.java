package ca.mcgill.ecse321.projectgroup15.service;

import java.sql.Date;
import java.sql.Time;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ca.mcgill.ecse321.projectgroup15.dao.*;
import ca.mcgill.ecse321.projectgroup15.dao.PersonRepository;
import ca.mcgill.ecse321.projectgroup15.dao.AppointmentRepository;
import ca.mcgill.ecse321.projectgroup15.dao.TimeSlotRepository;
import ca.mcgill.ecse321.projectgroup15.dao.ServiceRepository;
//import ca.mcgill.ecse321.projectgroup15.model.Service;
import ca.mcgill.ecse321.projectgroup15.model.*;
import ca.mcgill.ecse321.projectgroup15.model.*;

@Service
public class AutoRepairService {
	
	@Autowired
	PersonRepository personRepository;
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	TechnicianRepository technicianRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	AdministratorRepository administratorRepository;
	@Autowired
	ServiceRepository serviceRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	/**
	 * @return the loggedInUser
	 */
	public static Person getLoggedInUser() {
		return loggedInUser;
	}


	/**
	 * @param loggedInUser the loggedInUser to set
	 */
	public static void setLoggedInUser(Person loggedInUser) {
		AutoRepairService.loggedInUser = loggedInUser;
	}

	@Autowired
	TimeSlotRepository timeSlotRepository;
	
	private static Person loggedInUser = null;
	
	
	/*
	 * if (this.getAllCustomers().size() == 1) {
			throw new IllegalArgumentException("Can only have one Admin!");
		}
	 */
	
	//Register as Customer
	
	@Transactional
	public Customer createCustomer(String email, String username, String password, String lastName, String firstname, String cardNumber, String cvv, Month expiryMonth, Year expiryYear) {

		if ((username == null || username.trim().length() == 0)
				&& (password == null || password.trim().length() == 0)) {
			throw new IllegalArgumentException("Customer name and password cannot be empty!");
		}
		if (username == null || username.trim().length() == 0) {
			throw new IllegalArgumentException("Customer name cannot be empty!");
		}
		if (password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("Customer password cannot be empty!");
		}
		Customer customer = new Customer();
		customer.setEmail(email);
		customer.setUsername(username);
		customer.setPassword(password);
		customer.setLastName(lastName);
		customer.setFirstName(firstname);
		customer.setCardNumber(cardNumber);
		customer.setCvv(cvv);
		customer.setExpiryMonth(expiryMonth);
		customer.setExpiryYear(expiryYear);
		customerRepository.save(customer);
		return customer;
	}
	
	
	@Transactional
	public void saveCustomer(Customer c) {
		customerRepository.save(c);	
	}

	@Transactional
	public Customer getCustomer(String username) {
		Customer Customer = customerRepository.findCustomerByUsername(username);
		if (Customer == null) {
			throw new IllegalArgumentException("No admin found with this username!");
		}
		return Customer;
	}

	@Transactional
	public List<Customer> getAllCustomers() {
		return toList(customerRepository.findAll());
	}

	@Transactional
	public boolean deleteCustomer(String username) {
		if (username == null || username.trim().length() == 0) {
			throw new IllegalArgumentException("Username invalid!");
		}

		boolean deleted = false; // not deleted yet
		Customer Customer = customerRepository.findCustomerByUsername(username);
		if (Customer != null) {
			customerRepository.delete(Customer);
			deleted = true;
		} else {
			throw new IllegalArgumentException("No Customer found with username!");
		}
		return deleted;
	}

	@Transactional
	public Customer changeCustomerPassword(String username, String password) {
		if (username == null) {
			throw new IllegalArgumentException("Username cannot be empty!");
		}
		if (password == null) {
			throw new IllegalArgumentException("New password cannot be empty!");
		}
		Customer Customer = getCustomer(username);
		Customer.setPassword(password);
		customerRepository.save(Customer);

		return Customer;
	}

	
	//Register as Technician
	@Transactional
	public Technician createTechnician (String email, String username, String password, String lastName, String firstName, TechnicianRole technicianRole) {
		if ((username == null || username.trim().length() == 0)
				&& (password == null || password.trim().length() == 0)) {
			throw new IllegalArgumentException("Username and password cannot be empty!");
		}
		if (username == null || username.trim().length() == 0) {
			throw new IllegalArgumentException("Username cannot be empty!");
		}
		if (password == null || password.trim().length() == 0) {
			throw new IllegalArgumentException("Password cannot be empty!");
		}
		if (email == null || email.trim().length() == 0) {
			throw new IllegalArgumentException("Email is required!");
		}
		Technician technician = new Technician();
		technician.setEmail(email);
		technician.setPassword(password);
		technician.setLastName(lastName);
		technician.setFirstName(firstName);
		technician.setUsername(username);
		technician.setTechnicianRole(technicianRole);
		technicianRepository.save(technician);
		return technician;
	}
	
	@Transactional
	public List<Technician> getAllTechnicians() {
		return toList(technicianRepository.findAll());
	}
	
	@Transactional
	public Technician getTechnician(String username) {
		Technician technician = technicianRepository.findTechnicianByUsername(username);
		if (technician == null) {
			throw new IllegalArgumentException("No technician found with this username!");
		}
		return technician;
	}

	@Transactional
	public boolean deleteTechnician(String username) {
		if (username == null || username.trim().length() == 0) {
			throw new IllegalArgumentException("Username invalid!");
		}

		boolean deleted = false; // not deleted yet
		Technician technician = technicianRepository.findTechnicianByUsername(username);
		if (technician != null) {
			technicianRepository.delete(technician);
			deleted = true;
		} else {
			throw new IllegalArgumentException("No technician found with username!");
		}
		return deleted;
	}
	
	@Transactional
	public Technician changeTechnicianPassword(String username, String password) {
		if (username == null) {
			throw new IllegalArgumentException("Username cannot be empty!");
		}
		if (password == null) {
			throw new IllegalArgumentException("New password cannot be empty!");
		}
		Technician technician = getTechnician(username);
		technician.setPassword(password);
		technicianRepository.save(technician);

		return technician;
	}

	
	//TimeSlot
	
	@Transactional
	public TimeSlot createTimeSlot(int id,Date date, Time startTime, Time endTime, Technician technician ) {
		TimeSlot ts = new TimeSlot();
		ts.setId(ts.getDate().hashCode() * ts.getStartTime().hashCode() * ts.getEndTime().hashCode() * ts.getTechnician().hashCode());
		ts.setDate(date);
		ts.setStartTime(startTime);
		ts.setEndTime(endTime);
		ts.setTechnician(technician);
		//ts.setService(service);
		timeSlotRepository.save(ts);
		return ts;
	}
	
	@Transactional
	public List<TimeSlot> getAllTimeSlots(){
		return toList(timeSlotRepository.findAll());
	}
	
	@Transactional
	public TimeSlot getTimeSlot(int id) {
		TimeSlot timeSlot = timeSlotRepository.findTimeSlotById(id);
		if (timeSlot == null) {
			throw new IllegalArgumentException("No timeSlot found with this Id!");
		}
		return timeSlot;
	}
	
	@Transactional
	public boolean deleteTimeSlot(int id) {
	
		boolean deleted = false; // not deleted yet
		TimeSlot timeSlot = timeSlotRepository.findTimeSlotById(id);
		if (timeSlot != null) {
			timeSlotRepository.delete(timeSlot);
			deleted = true;
		} else {
			throw new IllegalArgumentException("No timeslot found with this Id!");
		}
		return deleted;
	}
	
	@Transactional
	public TimeSlot updateTimeSlot(Time startTime, Time EndTime, Date date, int id) {
		
		TimeSlot timeSlot = getTimeSlot(id);
		timeSlot.setDate(date);
		timeSlot.setEndTime(EndTime);
		timeSlot.setStartTime(startTime);
		timeSlotRepository.save(timeSlot);

		return timeSlot;
	}
	//services
	
	@Transactional
	public Services createService(String name, float cost, int duration, String id, ServiceType serviceType) {
		Services serv = new Services();
		serv.setName(name);
		serv.setCost(cost);
		serv.setDuration(duration);
		serv.setId(id);
		serv.setServiceType(serviceType);
		serviceRepository.save(serv);
		return serv;
	}
	
	@Transactional
	public List<Services> getAllServices(){
		return toList(serviceRepository.findAll());
	}
	
	@Transactional
	public Services getServices(String id) {
		Services service = serviceRepository.findServiceById(id);
		if (service == null) {
			throw new IllegalArgumentException("No service found with this Id!");
		}
		return service;
	}
	
	@Transactional
	public boolean deleteService(String id) {
	
		boolean deleted = false; // not deleted yet
		Services serv = serviceRepository.findServiceById(id);
		if (serv != null) {
			serviceRepository.delete(serv);
			deleted = true;
		} else {
			throw new IllegalArgumentException("No service found with this Id!");
		}
		return deleted;
	}
	
	
	
	
	//appointment
	
	@Transactional
	public Appointment createAppointment(Customer customer, Technician technician, Services service, TimeSlot ts, Payment payment) {
		Appointment apt = new Appointment();
		apt.setCustomer(customer);
		apt.setTechnician(technician);
		apt.setTimeslot(ts);
		apt.setPayment(payment);
		apt.setId(apt.getCustomer().hashCode());
		appointmentRepository.save(apt);
		return apt;
	}
	
	
	@Transactional
	public List<Appointment> getAllAppointments(){
		return toList(appointmentRepository.findAll());
	}
	
	@Transactional
	public Appointment getAppointment(int id) {
		Appointment a = appointmentRepository.findApointmentById(id);
		if (a == null) {
			throw new IllegalArgumentException("No Appointment found with this Id!");
		}
		return a;
	}
	
	
	@Transactional
	public boolean deleteAppointment(int id) {
	
		boolean deleted = false; // not deleted yet
		Appointment apt = appointmentRepository.findApointmentById(id);
		if (apt != null) {
			appointmentRepository.delete(apt);
			deleted = true;
		} else {
			throw new IllegalArgumentException("No appointment found with this Id!");
		}
		return deleted;
	}
	
	
	
	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
	//login 
	
		@Transactional
		public Customer loginAsCustomer(String username, String password) {

			if (username == null || username.trim().length() == 0) {
				throw new IllegalArgumentException("Username cannot be empty.");
			}
			if (password == null || password.trim().length() == 0) {
				throw new IllegalArgumentException("Password cannot be empty.");
			}

			List<Customer> Customers = getAllCustomers();

			Customer foundCustomer = null;
			for (Customer Customer : Customers) {
				if (Customer.getUsername().equals(username) && Customer.getPassword().equals(password)) {
					loggedInUser = Customer;
					foundCustomer = Customer;
					break;
				}
			}

			if (foundCustomer == null) {
				throw new IllegalArgumentException("This user account could not be found.");
			}

			return foundCustomer;

		}
		
		
		@Transactional
		public Technician loginAsTechnician(String username, String password) {

			if (username == null || username.trim().length() == 0) {
				throw new IllegalArgumentException("Username cannot be empty.");
			}
			if (password == null || password.trim().length() == 0) {
				throw new IllegalArgumentException("Password cannot be empty.");
			}
			List<Technician> technicians = getAllTechnicians();

			Technician foundTechnician = null;
			for (Technician technician : technicians) {
				if (technician.getUsername().equals(username) && technician.getPassword().equals(password)) {
					loggedInUser = technician;
					foundTechnician = technician;
					break;
				
			
				}
			}

			if (foundTechnician == null) {
				throw new IllegalArgumentException("This user account could not be found.");
			}

			return foundTechnician;

		}
		
		
		
		
		
	//Payment
		
		public Payment createPayment(String id, float totalCost, Date date) {
			if (id == null) {
				throw new IllegalArgumentException("There is no payment with this id");
			}
			if (date == null) {
				throw new IllegalArgumentException("please mention the date");
			}
			Payment payment =  new Payment();
			payment.setId(id);
			payment.setDate(date);
			payment.setTotalCost(totalCost);
			paymentRepository.save(payment);
			return payment;
			
		}
		
		

		@Transactional
		public Payment getPayment(String id) {
			Payment payment = paymentRepository.findPaymentById(id);
			if (payment == null) {
				throw new IllegalArgumentException("No Payment found with this Id!");
			}
			return payment;
		}

		@Transactional
		public List<Payment> getAllPayments() {
			return toList(paymentRepository.findAll());
		}

		@Transactional
		public boolean deletePayment(String paymentId) {
			if (paymentId == null) {
				throw new IllegalArgumentException("PaymentId invalid!");
			}

			boolean deleted = false; // not deleted yet
			Payment payment = paymentRepository.findPaymentById(paymentId);
			if (payment != null) {
				paymentRepository.delete(payment);
				deleted = true;
			} else {
				throw new IllegalArgumentException("Payment must be valid!");
			}
			return deleted;
		}
	
		//Administrator
		
		@Transactional
		public Administrator changeAdministratorPassword(String username, String password) {
			if (username == null) {
				throw new IllegalArgumentException("Username cannot be empty!");
			}
			if (password == null) {
				throw new IllegalArgumentException("New password cannot be empty!");
			}
			List<Administrator> admins = getAdministrators();
			Administrator foundAdmin = null;
			for(Administrator admin : admins) {
				if (admin.getUsername().equals(username)) {
					foundAdmin = admin;
					break;
				
			
				}
				if(foundAdmin == null) {
					throw new IllegalArgumentException("No Administrator found with username!");
				}
			}
			foundAdmin.setPassword(password);
			administratorRepository.save(foundAdmin);

			return foundAdmin;
		}
		
		@Transactional
		public List<Administrator> getAdministrators() {
			return toList(administratorRepository.findAll());
		}
		
		@Transactional
		public Administrator loginAsAdministrator(String username, String password) {
			if (username == null || username.trim().length() == 0) {
				throw new IllegalArgumentException("Username cannot be empty.");
			}
			if (password == null || password.trim().length() == 0) {
				throw new IllegalArgumentException("Password cannot be empty.");
			}
			List<Administrator> admins = getAdministrators();
			Administrator foundAdmin = null;
			for(Administrator admin : admins) {
				if (admin.getUsername().equals(username) && admin.getPassword().equals(password)) {
					loggedInUser = admin;
					foundAdmin = admin;
					break;
				
			
				}
			}
			if (foundAdmin == null) {
				throw new IllegalArgumentException("This adminsitrator account could not be found.");
			}

			return foundAdmin;

			
		}
		
		@Transactional
		public Administrator createAdministrator(String email, String username, String password, String firstName, String lastName) {
			if ((username == null || username.trim().length() == 0)
					&& (password == null || password.trim().length() == 0)) {
				throw new IllegalArgumentException("Username and password cannot be empty!");
			}
			if (username == null || username.trim().length() == 0) {
				throw new IllegalArgumentException("Username cannot be empty!");
			}
			if (password == null || password.trim().length() == 0) {
				throw new IllegalArgumentException("Password cannot be empty!");
			}
			if (email == null || email.trim().length() == 0) {
				throw new IllegalArgumentException("Email is required!");
			}
			Administrator admin = new Administrator();
			admin.setEmail(email);
			admin.setUsername(username);
			admin.setPassword(password);
			admin.setFirstName(firstName);
			admin.setLastName(lastName);
			administratorRepository.save(admin);
			
			return admin;
			
		}
		






		
		
		
		


}
