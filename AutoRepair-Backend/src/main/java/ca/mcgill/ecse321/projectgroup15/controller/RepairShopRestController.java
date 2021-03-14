package ca.mcgill.ecse321.projectgroup15.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.mcgill.ecse321.projectgroup15.service.AutoRepairService;

@CrossOrigin(origins = "*")
@RestController
public class RepairShopRestController {
	
	@Autowired
	private AutoRepairService autoRepairService;

	@GetMapping("/home")
	public String home() {
		return "it's working";
	}
	
}
