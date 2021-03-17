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
			
			
			//Customer cus = service.createCustomer(c.getEmail(), c.getUsername(), c.getPassword(), c.getLastName(), c.getFirstName());
			return convertToDto(cus);
		}

		private CustomerDto convertToDto(Customer a) {
			if (a == null) {
				throw new IllegalArgumentException("There is no such app user!");
			}
			CustomerDto CustomerDto = new CustomerDto(a.getEmail(), a.getUsername(), a.getPassword(), a.getLastName(), a.getFirstName());
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
	
}
