package ca.mcgill.ecse321.projectgroup15.controller;





import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	// APP USER //

		@GetMapping(value = { "/customer", "/customer/" })
		public List<CustomerDto> getAllCustomer() {
			return service.getAllCustomers().stream().map(a -> convertToDto(a)).collect(Collectors.toList());
		}
		
		
		//@PathVariable("username")  String username, @RequestParam("email") String email, @RequestParam("password") String password, @RequestParam("lastName") String lastName, @RequestParam("firstName") String firstName
		
		//@RequestMapping(value = { "/Customerregister/{username}", "/Customerregister/{username}/"}, method = RequestMethod.POST)
		@PostMapping(value = { "/Customerregister", "/Customerregister/" })
		
		public CustomerDto createCustomerDto(@RequestBody Customer c) throws IllegalArgumentException {
			//service.saveCustomer(c);
			
			
			Customer cus = service.createCustomer(c.getEmail(), c.getUsername(), c.getPassword(), c.getLastName(), c.getFirstName(), c.getCardNumber(), c.getCvv(), c.getExpiry());
			return convertToDto(cus);
		}

		private CustomerDto convertToDto(Customer a) {
			if (a == null) {
				throw new IllegalArgumentException("There is no such app user!");
			}
			CustomerDto CustomerDto = new CustomerDto(a.getEmail(), a.getUsername(), a.getPassword(), a.getLastName(), a.getFirstName(), a.getCardNumber(), a.getCvv(), a.getExpiry());
			return CustomerDto;
		}

	
		//@RequestParam String personUsername, @RequestParam String password
	
	
	
	@PostMapping(value = { "/loginuser" })
	@ResponseBody
	public String CustomerLogin(@RequestParam("username") String username, @RequestParam("password") String password) {  
		try {
			service.loginAsCustomer(username, password);
			return "Login Successful!";
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}

	}
	
	
	@PostMapping(value = { "/technicianregister", "/technicianregister/" })
	
	public TechnicianDto createTechnicianDto(@RequestBody Technician t) throws IllegalArgumentException {
		//service.saveCustomer(c);
		
		
		Technician tech = service.createTechnician(t.getEmail(), t.getUsername(), t.getPassword(), t.getLastName(), t.getFirstName(), t.getTechnicianRole());
		return convertTechDto(tech);
	}

	private TechnicianDto convertTechDto(Technician t) {
		if (t == null) {
			throw new IllegalArgumentException("There is no such app user!");
		}
		TechnicianDto technicianDto = new TechnicianDto(t.getTechnicianRole(), t.getEmail(), t.getUsername(), t.getPassword(), t.getLastName(), t.getFirstName());
		return technicianDto;
	}
	
	
	@PostMapping(value = {"/payment", "/payment/"})
	public PaymentDto createPayment(@RequestBody Payment p) throws IllegalArgumentException {
		
		Payment payment = service.createPayment(p.getId(), p.getTotalCost(), p.getDate());
		
		return convertpToDto(payment);
	}
	
	private PaymentDto convertpToDto(Payment p) {
		PaymentDto paymentDto = new PaymentDto(p.getDate(), p.getTotalCost(), p.getId());
		return paymentDto;
	}
	 
	@GetMapping(value = {"/appointments", "/appointments/" })
 	public List<AppointmentDto> getAllAppointments(){
	 	List<AppointmentDto> aDtos = new ArrayList<>();
	 	for(Appointment a : service.getAllAppointments()) {
		 	aDtos.add(convertToDto(a));
	 	}
	 	return aDtos;
	 
 }

	@GetMapping(value = {"/appointments/{id}", "/appointments/{id}/" })
	 public AppointmentDto getAppointmentById(@PathVariable("id")int id) throws IllegalArgumentException{
	 	return convertToDto(service.getAppointment(id));
 }
	
		private TimeSlotDto convertToDto(TimeSlot ts) {
		if(ts == null) {
			throw new IllegalArgumentException("There is no such Time Slot");
		}
		TimeSlotDto tsDto = new TimeSlotDto(ts.getId(), ts.getDate(), ts.getStartTime(), ts.getEndTime());
		return tsDto;
	}
	
	private AppointmentDto convertToDto(Appointment a){
		if(a == null) {
			throw new IllegalArgumentException("There is no such Appointment ");
		}
		AppointmentDto aDto = new AppointmentDto(a.getId());
		return aDto;
		}
	
	private ServiceDto convertToDto(Service s) {
		if(s == null) {
			throw new IllegalArgumentException("There is no such service !");
		}
		ServiceDto sDto = new ServiceDto(s.getId());
		return sDto;
	}
}
