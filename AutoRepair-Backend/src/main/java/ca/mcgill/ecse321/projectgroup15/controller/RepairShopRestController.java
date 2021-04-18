package ca.mcgill.ecse321.projectgroup15.controller;





import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.projectgroup15.service.AutoRepairService;

import ca.mcgill.ecse321.projectgroup15.model.*;
import ca.mcgill.ecse321.projectgroup15.dto.*;

@CrossOrigin(origins = "*")
@RestController
public class RepairShopRestController {
	
	//the parameters are being recorded but I am not able to save them to the repository.
	//It's giving me the id error. I guess we have to chage all the ids to int or long
	// I changed a few.
	
	@Autowired
	private AutoRepairService service;
	
	
	@GetMapping("/home")
	public String home() {
		return "it's working";
	}
	
	
	// Customer
	
	//Register Page
	
	
	//register as a customer
	/**
	 * 
	 * @param c
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/Customerregister", "/Customerregister/" })
	
	public CustomerDto createCustomerDto(@RequestBody Customer c) throws IllegalArgumentException {
		//service.saveCustomer(c);
		
		
		Customer cus = service.createCustomer(c.getEmail(), c.getUsername(), c.getPassword(), c.getLastName(), c.getFirstName(), c.getCardNumber(), c.getCvv(), c.getExpiryMonth(), c.getExpiryYear());
		return convertToDto(cus);
	}
	/**
	 * 
	 * @param a
	 * @return
	 */
	private CustomerDto convertToDto(Customer a) {
		if (a == null) {
			throw new IllegalArgumentException("There is no such app user!");
		}
		CustomerDto CustomerDto = new CustomerDto(a.getEmail(), a.getUsername(), a.getPassword(), a.getLastName(), a.getFirstName(), a.getCardNumber(), a.getCvv(), a.getExpiryMonth(), a.getExpiryYear());
		return CustomerDto;
	}
	

	//Register as a technician
	/**
	 * 
	 * @param t
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/technicianregister", "/technicianregister/" })
	
	public TechnicianDto createTechnicianDto(@RequestBody Technician t) throws IllegalArgumentException {
		//service.saveCustomer(c);
		
		
		Technician tech = service.createTechnician(t.getEmail(), t.getUsername(), t.getPassword(), t.getLastName(), t.getFirstName(), t.getTechnicianRole());
		return convertTechDto(tech);
	}
	/**
	 * 
	 * @param t
	 * @return
	 */
	private TechnicianDto convertTechDto(Technician t) {
		if (t == null) {
			throw new IllegalArgumentException("There is no such app user!");
		}
		TechnicianDto technicianDto = new TechnicianDto(t.getTechnicianRole(), t.getEmail(), t.getUsername(), t.getPassword(), t.getLastName(), t.getFirstName());
		return technicianDto;
	}

/*	

	//Register as a administrator
	@PostMapping(value = { "/adminregister", "/adminregister/" })
	
	public AdministratorDto createAdministratorDto(@RequestBody Administrator a) throws IllegalArgumentException {
		//service.saveCustomer(c);
		
		
		Administrator admin = service.createAdministrator(a.getEmail(), a.getUsername(), a.getPassword(), a.getLastName(), a.getFirstName());
		return convertTechDto(tech);
	}

	private TechnicianDto convertTechDto(Technician t) {
		if (t == null) {
			throw new IllegalArgumentException("There is no such app user!");
		}
		TechnicianDto technicianDto = new TechnicianDto(t.getTechnicianRole(), t.getEmail(), t.getUsername(), t.getPassword(), t.getLastName(), t.getFirstName());
		return technicianDto;
	}
	
	
	
	
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	// Customer //

	
	//get all the customers in the database
	/**
	 * 
	 * @return
	 */
		@GetMapping(value = { "/customer", "/customer/" })
		public List<CustomerDto> getAllCustomer() {
			return service.getAllCustomers().stream().map(a -> convertToDto(a)).collect(Collectors.toList());
		}
		
	
	
		
	//login as a customer
		/**
		 * 
		 * @param username
		 * @param password
		 * @return
		 */
	@PostMapping(value = { "/logincustomer/{username}/{password}" })
	@ResponseBody
	public String CustomerLogin(@PathVariable("username") String username, @PathVariable("password") String password) {  
		try {
			service.loginAsCustomer(username, password);
			return "Login Successful!";
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}

	}
	
	
	
	//login as a Technician
	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
		@PostMapping(value = { "/logintechnician/{username}/{password}" })
		@ResponseBody
		public String TechnicianLogin(@PathVariable("username") String username, @PathVariable("password") String password) {  
			try {
				service.loginAsTechnician(username, password);
				return "Login Successful!";
			} catch (IllegalArgumentException e) {
				return e.getMessage();
			}

		}
	
	
	// create a Payment
		/**
		 * 
		 * @param p
		 * @return
		 * @throws IllegalArgumentException
		 */
	@PostMapping(value = {"/payment", "/payment/"})
	public PaymentDto createPayment(@RequestBody Payment p) throws IllegalArgumentException {
		
		Payment payment = service.createPayment(p.getId(), p.getTotalCost(), p.getDate());
		
		return convertpToDto(payment);
	}
	/**
	 * 
	 * @param p
	 * @return
	 */
	private PaymentDto convertpToDto(Payment p) {
		PaymentDto paymentDto = new PaymentDto(p.getDate(), p.getTotalCost(), p.getId());
		return paymentDto;
	}
	
	// get all the Payments in the database
	/**
	 * 
	 * @return
	 */
		@GetMapping(value = {"/payments", "/payments/" })
	 	public List<PaymentDto> getAllPayments(){
		 	List<PaymentDto> payDtos = new ArrayList<>();
		 	for(Payment pay : service.getAllPayments()) {
			 	payDtos.add(convertpToDto(pay));
		 	}
		 	return payDtos;
		 
	 }
		
		//get the payment corresponding to the id
		/**
		 * 
		 * @param id
		 * @return
		 * @throws IllegalArgumentException
		 */
		@GetMapping(value = {"/payments/{id}", "/payments/{id}/" })
		 public PaymentDto getPaymentById(@PathVariable("id")String id) throws IllegalArgumentException{
		 	return convertpToDto(service.getPayment(id));
	 }
		
		//Delete TimeSlot
		/**
		 * 
		 * @param id
		 * @return
		 */
				@DeleteMapping(value = { "/payment/delete/{id}", "/payments/delete/{id}/" })
				public boolean deletePayment(@PathVariable(name = "id") String id) {
					
						return service.deletePayment(id);
					
				}
	 
		
				
			// create a Appointment
				/**
				 * 
				 * @param a
				 * @return
				 * @throws IllegalArgumentException
				 */
			@PostMapping(value = {"/appointment", "/appointment/"})
			public AppointmentDto createAppointment(@RequestBody Appointment a) throws IllegalArgumentException {
				
				Appointment appointment = service.createAppointment(a.getCustomer(), a.getTechnician(), a.getService(), a.getTimeslot(), a.getPayment());
			
				return convertToDto(appointment);
			}
							
	
	// get all the appointments in the database
			/**
			 * 
			 * @return
			 */
	@GetMapping(value = {"/appointments", "/appointments/" })
 	public List<AppointmentDto> getAllAppointments(){
	 	List<AppointmentDto> aDtos = new ArrayList<>();
	 	for(Appointment a : service.getAllAppointments()) {
		 	aDtos.add(convertToDto(a));
	 	}
	 	return aDtos;
	 
 }
	
	//get the appointment corresponding to the id
	/**
	 * 
	 * @param id
	 * @return
	 * @throws IllegalArgumentException
	 */
	@GetMapping(value = {"/appointments/{id}", "/appointments/{id}/" })
	 public AppointmentDto getAppointmentById(@PathVariable("id")int id) throws IllegalArgumentException{
	 	return convertToDto(service.getAppointment(id));
 }
	
	
	//Delete Appointment
	/**
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = { "/appointment/delete/{id}", "/payments/delete/{id}/" })
	public boolean deleteAppointment(@PathVariable(name = "id") int id) {
		
			return service.deleteAppointment(id);
		
	}
	
	
	
		
	/**
	 * 
	 * @param a
	 * @return
	 */
	private AppointmentDto convertToDto(Appointment a){
		if(a == null) {
			throw new IllegalArgumentException("There is no such Appointment ");
		}
		AppointmentDto aDto = new AppointmentDto(a.getId(), converttsToDto(a.getTimeslot()), convertToDto(a.getService()), convertTechDto(a.getTechnician()));
		return aDto;
		}
	
	// Create Service 
	/**
	 * 
	 * @param s
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/createservice", "/createservice/" })
	public ServiceDto createServiceDto(@RequestBody Services s) throws IllegalArgumentException {
		
		Services ss = service.createService(s.getName(), s.getCost(), s.getDuration(), s.getId(), s.getServiceType());
		return convertToDto(ss);
	}
	
	
	// get all the services in the database
	/**
	 * 
	 * @return
	 */
			@GetMapping(value = {"/services", "/services/" })
		 	public List<ServiceDto> getAllService(){
			 	List<ServiceDto> ssDtos = new ArrayList<>();
			 	for(Services ts : service.getAllServices()) {
				 	ssDtos.add(convertToDto(ts));
			 	}
			 	return ssDtos;
			 
		 }
			
			//get the timeSlot corresponding to the id
			/**
			 * 
			 * @param id
			 * @return
			 * @throws IllegalArgumentException
			 */
			@GetMapping(value = {"/services/{id}", "/services/{id}/" })
			 public ServiceDto getServicesById(@PathVariable("id")String id) throws IllegalArgumentException{
			 	return convertToDto(service.getServices(id));

	}
			//Delete TimeSlot
			/**
			 * 
			 * @param id
			 * @return
			 */
			@DeleteMapping(value = { "/services/delete/{id}", "/services/delete/{id}/" })
			public boolean deleteServices(@PathVariable(name = "id") String id) {
				
					return service.deleteService(id);
				
			}
	
	
	
	
			/**
			 * 
			 * @param s
			 * @return
			 */
	private ServiceDto convertToDto(Services s) {
		if(s == null) {
			throw new IllegalArgumentException("There is no such service !");
		}
		ServiceDto sDto = new ServiceDto(s.getId(), null, 0, 0, null);
		return sDto;
	}
	
	
	
	
	
	//Create TimeSlot
	/**
	 * 
	 * @param id
	 * @param date
	 * @param startTime
	 * @param endTime
	 * @param username
	 * @return
	 * @throws IllegalArgumentException
	 */
	@PostMapping(value = { "/createtimeslot/{id}/{date}/{startTime}/{endTime}/{username}", "/createtimeslot/{id}/{date}/{startTime}/{endTime}/{username}/" })
	
	public TimeSlotDto createTimeSlotDto(@PathVariable("id") int id, @PathVariable("date")  String date, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime, @PathVariable("username") String username) throws IllegalArgumentException {
		
		Technician t = service.getTechnician(username);
		Time startTimeA = Time.valueOf(startTime);
		Time endTimeA = Time.valueOf(endTime);
		Date dateA = Date.valueOf(date);
		TimeSlot ts1 = service.createTimeSlot(id,dateA, startTimeA, endTimeA, t);
		return converttsToDto(ts1);
	}
	/**
	 * 
	 * @param tso
	 * @return
	 */
	private TimeSlotDto converttsToDto(TimeSlot tso) {
		if (tso == null) {
			throw new IllegalArgumentException("There is no such TimeSlot!");
		}
		TimeSlotDto timeSlotDto = new TimeSlotDto(tso.getId(),tso.getDate(), tso.getStartTime(), tso.getEndTime());
		return timeSlotDto;
	}
	
	
	// get all the timeSlots in the database
	/**
	 * 
	 * @return
	 */
		@GetMapping(value = {"/timeslots", "/timeslots/" })
	 	public List<TimeSlotDto> getAllTimeSlots(){
		 	List<TimeSlotDto> tsDtos = new ArrayList<>();
		 	for(TimeSlot ts : service.getAllTimeSlots()) {
			 	tsDtos.add(converttsToDto(ts));
		 	}
		 	return tsDtos;
		 
	 }
		
		//get the timeSlot corresponding to the id
		/**
		 * 
		 * @param id
		 * @return
		 * @throws IllegalArgumentException
		 */
		@GetMapping(value = {"/timeslot/{id}", "/timeslot/{id}/" })
		 public TimeSlotDto getTimeSlotById(@PathVariable("id")int id) throws IllegalArgumentException{
		 	return converttsToDto(service.getTimeSlot(id));

}
		//Delete TimeSlot
		/**
		 * 
		 * @param id
		 * @return
		 */
		@DeleteMapping(value = { "/timeslot/delete/{id}", "/timeslot/delete/{id}/" })
		public boolean deleteTimeSlot(@PathVariable(name = "id") Integer id) {
			
				return service.deleteTimeSlot(id);
			
		}
		
		// change timeslot details
		/**
		 * 
		 * @param id
		 * @param endTime
		 * @param startTime
		 * @param date
		 */
				@PutMapping(value = { "/timeslot/change/{id}", "/timeslot/change/{id}/" })
				public void changeTimeSlotDetails(@PathVariable("id") int id, @RequestParam Time endTime, @RequestParam Time startTime, @RequestParam Date date) {
					
						service.updateTimeSlot(startTime, endTime, date, id);
					
				}
		
		
		
		
		// change Customer password
				/**
				 * 
				 * @param username
				 * @param password
				 */
		@PutMapping(value = { "/Customerregister/password/{username}", "/Customerregister/password/{username}/" })
		public void changeCustomerPassword(@PathVariable("username") String username, @RequestParam String password) {
			if (username == null) {
				throw new IllegalArgumentException("Username cannot be empty!");
			}
			if (password == null) {
				throw new IllegalArgumentException("New password cannot be empty!");
			} else {
				service.changeCustomerPassword(username, password);
			}
		}
		
		// change Technician password
		/**
		 * 
		 * @param username
		 * @param password
		 */
				@PutMapping(value = { "/technicianregister/password/{username}", "/technicianregister/password/{username}/" })
				public void changeTechnicianPassword(@PathVariable("username") String username, @RequestParam String password) {
					if (username == null) {
						throw new IllegalArgumentException("Username cannot be empty!");
					}
					if (password == null) {
						throw new IllegalArgumentException("New password cannot be empty!");
					} else {
						service.changeTechnicianPassword(username, password);
					}
				}
		
		//login as Administrator
				/**
				 * 
				 * @param username
				 * @param password
				 * @return
				 */
				@PostMapping(value = { "/loginadministrator/{username}/{password}" })
				@ResponseBody
				public String AdministratorLogin(@RequestParam("username") String username, @RequestParam("password") String password) {  
					try {
						service.loginAsAdministrator(username, password);
						return "Login Successful!";
					} catch (IllegalArgumentException e) {
						return e.getMessage();
					}

				}
				
				
		// change Administrator password
				/**
				 * 
				 * @param username
				 * @param password
				 */
			@PutMapping(value = { "/administratorregister/password/{username}", "/administratorregister/password/{username}/" })
			public void changeAdministratorPassword(@PathVariable("username") String username, @RequestParam String password) {
				if (username == null) {
					throw new IllegalArgumentException("Username cannot be empty!");
				}
				if (password == null) {
					throw new IllegalArgumentException("New password cannot be empty!");
				} else {
					service.changeAdministratorPassword(username, password);
				}
			}
			/**
			 * 
			 * @param a
			 * @return
			 */
			private AdministratorDto convertToDto(Administrator a) {
				if (a == null) {
					throw new IllegalArgumentException("There is no such administrator!");
				}
				
				AdministratorDto adminDto = new AdministratorDto(a.getEmail(), a.getUsername(), a.getPassword(), a.getLastName(), a.getFirstName());
				return adminDto;
				
				
			}
			
			//Register as a administrator
			/**
			 * 
			 * @param a
			 * @return
			 * @throws IllegalArgumentException
			 */
			@PostMapping(value = { "/administratorregister", "/administratorregister/" })
			
			public AdministratorDto createAdministratorDto(@RequestBody Administrator a) throws IllegalArgumentException {
				
				
				Administrator admin = service.createAdministrator(a.getEmail(), a.getUsername(), a.getPassword(), a.getLastName(), a.getFirstName());
				return convertToDto(admin);
			}		

}
