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
		int id = 6;
		int timeId = 0;
	
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setDate(date);
		timeSlot.setEndTime(endTime);
		timeSlot.setStartTime(startTime);
		timeSlot.setId(timeId);
		timeSlot.setRepairShop(auto2);
		timeSlot.setTechnician(tech);
		auto2.setId(id);
		
		int techId = 4;
		String email = "sdd";
		String userName = "x";
		String password = "388";
		String firstname = "whqbxq";
		String lastname = "xucbxasx";
		String name = "jbwdvwq";
		List<TimeSlot> timeSlots = new ArrayList<TimeSlot>();
		List<Appointment> appointments = new ArrayList<Appointment>();
		List<Services> services = new ArrayList<Services>();
		
		
		tech.setUsername(userName);
		tech.setFirstName(firstname);
		tech.setLastName(lastname);
		tech.setEmail(email);
		tech.setId(techId);
		tech.setPassword(password);
		tech.setRepairShop(auto2);
		tech.setTimeSlot(timeSlot);
		tech.setTechnicianRole(TechnicianRole.Inspector);
		
		
		
		
		
		technicianRepository.save(tech);
		
		tech = null;
		tech = technicianRepository.findTechnicianByUsername(userName);
		assertNotNull(tech);
		assertEquals(techId,tech.getId());
		assertEquals(userName,tech.getUsername());
		assertEquals(email,tech.getEmail());
		assertEquals(password,tech.getPassword());
		assertEquals(auto2,tech.getRepairShop());
		assertEquals(TechnicianRole.Inspector,tech.getTechnicianRole());
		assertEquals(id,tech.getRepairShop().getId());
		
		
		
	}
}
	
