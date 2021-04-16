package ca.mcgill.ecse321.projectgroup15.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import ca.mcgill.ecse321.projectgroup15.model.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestAutoRepairPersistenceAdministrator {
	
	
	
	@Autowired
	private AdministratorRepository administratorRepository;
	
	
	@AfterEach
	public void clearDatabase() {
		
		
		administratorRepository.deleteAll();
		
		
		
		
	}
	
	@Test
	public void PersistAndLoadAdministrator() {
		
		RepairShop auto2 = new RepairShop();
		
		int adminId = 6;
		String username = "dsf";
		String firstname = "ewdwe";
		String lastname = "dhewjfwva";
		String password = "514";
		String email = "sdd";
		String name = "xsch";
		int id = 9;
		
		 List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
		  
		  List<Person> persons = new ArrayList<Person>();
		  List<Payment> payments = new ArrayList<Payment>();
		  List<Services> services = new ArrayList<Services>();
		 List<Appointment> appointments = new ArrayList<Appointment>();
		 auto2.setAppointments(appointments);
		 auto2.setPayments(payments);
		 auto2.setPersons(persons);
		 auto2.setServices(services);
		 auto2.setTimeSlots(timeSlots);
		 auto2.setId(id);
		Administrator assistant = new Administrator();
		
		assistant.setId(adminId);
		assistant.setUsername(username);
		assistant.setPassword(password);
		assistant.setFirstName(firstname);
		assistant.setLastName(lastname);
		
		assistant.setEmail(email);
		assistant.setRepairShop(auto2);
		administratorRepository.save(assistant);
		
	//	assistant = null;
		
		assistant = administratorRepository.findAdministratorById(adminId);
		
		assertNotNull(assistant);
		assertEquals(adminId,assistant.getId());
		assertEquals(username,assistant.getUsername());
		assertEquals(password,assistant.getPassword());
		assertEquals(email,assistant.getEmail());
		assertEquals(auto2,assistant.getRepairShop());
		assertEquals(id,assistant.getRepairShop().getId());
		
		
		
	}
}

		
		
