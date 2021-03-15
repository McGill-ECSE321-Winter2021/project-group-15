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
		
		String adminId = "123";
		String lastName = "dsf";
		String password = "514";
		String email = "sdd";
		String id = "cdde";
		auto2.setId(id);
		Administrator assistant = new Administrator();
		
		assistant.setId(adminId);
		assistant.setUsername(lastName);
		assistant.setPassword(password);
		assistant.setEmail(email);
		assistant.setRepairShop(auto2);
		administratorRepository.save(assistant);
		
		assistant = null;
		
		assistant = administratorRepository.findAdministratorById(adminId);
		
		assertNotNull(assistant);
		assertEquals(adminId,assistant.getId());
		assertEquals(lastName,assistant.getUsername());
		assertEquals(password,assistant.getPassword());
		assertEquals(email,assistant.getEmail());
		assertEquals(auto2,assistant.getRepairShop());
		assertEquals(id,assistant.getRepairShop().getId());
		
		
		
	}
}
