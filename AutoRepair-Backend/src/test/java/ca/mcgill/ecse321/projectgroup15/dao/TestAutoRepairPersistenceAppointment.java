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
public class TestAutoRepairPersistenceAppointment {
	
	
	
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	
	
	@AfterEach
	public void clearDatabase() {
		
		
		appointmentRepository.deleteAll();
		
		
		
		
	}
	
	@Test
	public void PersistAndLoadAppointment() {
		
		RepairShop auto2 = new RepairShop();
		
        Technician tech = new Technician();
		
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(11, 35));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(13, 25));
		int id = 8;
		int timeId = 0;
	
		TimeSlot timeSlot = new TimeSlot();
		timeSlot.setDate(date);
		timeSlot.setEndTime(endTime);
		timeSlot.setStartTime(startTime);
		timeSlot.setId(timeId);
		timeSlot.setRepairShop(auto2);
		timeSlot.setTechnician(tech);
		auto2.setId(id);
		
		int techId = 6;
		String email = "sdd";
		String firstName = "x";
		String password = "388";
		
		tech.setUsername(firstName);
		tech.setEmail(email);
		tech.setId(techId);
		tech.setPassword(password);
		tech.setRepairShop(auto2);
		tech.setTechnicianRole(TechnicianRole.Inspector);
		
		
		
		int appointmentID = 9;
		
		
		Appointment appointment = new Appointment();
		appointment.setId(appointmentID);
		appointment.setTimeslot(timeSlot);
		appointment.setRepairShop(auto2);
		appointment.setTechnician(tech);
		List<Appointment> appointments = new ArrayList<Appointment>();
		tech.setAppointments(appointments);
		tech.getAppointments().add(appointment);
		
		
		appointmentRepository.save(appointment);
		
		appointment = null;
		
		appointment = appointmentRepository.findApointmentById(appointmentID);
		
		assertNotNull(appointment);
		assertEquals(appointmentID,appointment.getId());
	
		assertEquals(timeSlot.getDate(),appointment.getTimeslot().getDate());
		assertEquals(timeSlot.getEndTime(),appointment.getTimeslot().getEndTime());
		assertEquals(timeSlot.getStartTime(), appointment.getTimeslot().getStartTime());
		assertEquals(auto2,appointment.getRepairShop());
		assertEquals(auto2.getId(),appointment.getRepairShop().getId());
		assertEquals(tech.getUsername(),appointment.getTechnician().getUsername());
		assertEquals(tech.getPassword(),appointment.getTechnician().getPassword());
		assertEquals(tech.getEmail(),appointment.getTechnician().getEmail());
		assertEquals(tech.getId(),appointment.getTechnician().getId());
		
	}

}
