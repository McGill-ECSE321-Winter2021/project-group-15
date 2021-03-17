package ca.mcgill.ecse321.projectgroup15.service;

import java.sql.Date;
import java.sql.Time;
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

import ca.mcgill.ecse321.projectgroup15.model.*;
import ca.mcgill.ecse321.projectgroup15.model.Person;
import ca.mcgill.ecse321.projectgroup15.model.Appointment;
import ca.mcgill.ecse321.projectgroup15.model.TimeSlot;
import ca.mcgill.ecse321.projectgroup15.model.ServiceType;
//import ca.mcgill.ecse321.projectgroup15.model.Service;

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
	
	@Autowired
	TimeSlotRepository timeSlotRepository;
	
	private static Person loggedInUser = null;
	
	
	//Register as Customer
	
	@Transactional
	public Customer createCustomer(String email, String username, String password, String lastName, String firstname) {
		if (this.getAllCustomers().size() == 1) {
			throw new IllegalArgumentException("Can only have one Admin!");
		}
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
		customer.setFirstName(firstname);;
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
	public Technician createTechnician (String email, String username, String password, TechnicianRole technicianRole) {
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
		technician.setTechnicianRole(technicianRole);
		technicianRepository.save(technician);
		return technician;
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
	public List<Technician> getAllTechinicans(){
		return toList(technicianRepository.findAll());
	}
	
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
	public Appointment createAppointment(Customer customer, Technician technician, Service service, TimeSlot ts, Payment payment) {
		Appointment apt = new Appointment();
		apt.setCustomer(customer);
		apt.setTechnician(technician);
		apt.setTimeslot(ts);
		apt.setPayment(payment);
		apt.setId(apt.getCustomer().hashCode());
		appointmentRepository.save(apt);
		return apt;
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
		
	
}
