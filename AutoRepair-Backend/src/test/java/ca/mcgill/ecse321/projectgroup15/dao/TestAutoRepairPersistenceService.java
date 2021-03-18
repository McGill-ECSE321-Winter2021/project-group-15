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
public class TestAutoRepairPersistenceService {
	
	
	
	@Autowired
	private ServiceRepository serviceRepository;
	
	
	
	@AfterEach
	public void clearDatabase() {
		
		
		serviceRepository.deleteAll();
		
		
		
		
	}
	
	@Test
	public void PersistAndLoadService() {
		
		
		RepairShop auto2 = new RepairShop();
		
		Service service = new Service();
		
		float cost = 34;
		int duration = 9;
		String serviceId = "xwdqd";
		String name = "fcwcd";
		String serviceType = "Checkup";
		
		int techId = 9;
		String email = "sdd";
		String firstName = "x";
		String password = "388";
		
		Technician tech = new Technician();
		
		tech.setUsername(firstName);
		tech.setEmail(email);
		tech.setId(techId);
		tech.setPassword(password);
		tech.setRepairShop(auto2);
		tech.setTechnicianRole(TechnicianRole.Inspector);
		
		service.setCost(cost);
		service.setDuration(duration);
		service.setId(serviceId);
		service.setName(name);
		service.setRepairShop(auto2);
		service.setServiceType(ServiceType.Checkup);
		service.setTechnician(tech);
		
		
		//service.setServiceCost(totalCost);
		serviceRepository.save(service);
		
		service = null;
		
		service = serviceRepository.findSerivceByServiceType(serviceType);
		
		assertNotNull(service);
		assertEquals(serviceType,service.getServiceType());
		assertEquals(cost,service.getCost());
		assertEquals(duration,service.getDuration());
		assertEquals(serviceId,service.getId());
		assertEquals(name,service.getName());
		assertEquals(tech.getRepairShop(),service.getRepairShop());
		assertEquals(ServiceType.Checkup,service.getServiceType());
		assertEquals(tech,service.getTechnician());
		assertEquals(tech.getUsername(),service.getTechnician().getUsername());
		assertEquals(tech.getEmail(),service.getTechnician().getEmail());
		assertEquals(tech.getId(),service.getTechnician().getId());
		assertEquals(tech.getPassword(),service.getTechnician().getPassword());
		assertEquals(tech.getTechnicianRole(),service.getTechnician().getTechnicianRole());	
		
	}

}
