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
public class TestAutoRepairPersistenceTechnician {
	
	

	
	@Autowired
	private TechnicianRepository technicianRepository;
	
	
	@AfterEach
	public void clearDatabase() {
		
		
		technicianRepository.deleteAll();
	
		
		
	}
	

	
	@Test
	public void PersistAndLoadTechnician() {
		
		RepairShop auto2 = new RepairShop();
		Technician tech = new Technician();
		
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		String id = "cdde";
	
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setDate(date);
		timeSlot.setEndTime(endTime);
		timeSlot.setStartTime(startTime);
		timeSlot.setId(id);
		timeSlot.setRepairShop(auto2);
		timeSlot.setTechnician(tech);
		auto2.setId(id);
		
		String techId = "789";
		String email = "sdd";
		String firstName = "x";
		String password = "388";
		
		tech.setUsername(firstName);
		tech.setEmail(email);
		tech.setId(techId);
		tech.setPassword(password);
		tech.setRepairShop(auto2);
		tech.setTechnicianRole(TechnicianRole.Inspector);
		
		
		
		
		
		technicianRepository.save(tech);
		
		tech = null;
		tech = technicianRepository.findTechnicianById(techId);
		assertNotNull(tech);
		assertEquals(techId,tech.getId());
		assertEquals(firstName,tech.getUsername());
		assertEquals(email,tech.getEmail());
		assertEquals(password,tech.getPassword());
		assertEquals(auto2,tech.getRepairShop());
		assertEquals(TechnicianRole.Inspector,tech.getTechnicianRole());
		assertEquals(id,tech.getRepairShop().getId());
		
		
		
	}
}
	
