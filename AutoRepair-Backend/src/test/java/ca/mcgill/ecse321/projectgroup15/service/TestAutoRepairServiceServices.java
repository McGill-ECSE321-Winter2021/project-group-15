package ca.mcgill.ecse321.projectgroup15.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.projectgroup15.dao.CustomerRepository;
import ca.mcgill.ecse321.projectgroup15.dao.PaymentRepository;
import ca.mcgill.ecse321.projectgroup15.dao.ServiceRepository;
import ca.mcgill.ecse321.projectgroup15.model.*;

@ExtendWith(MockitoExtension.class)
public class TestAutoRepairServiceServices {
	
	@Mock
	private ServiceRepository serviceDao;
	
	@InjectMocks
	private AutoRepairService service;
	
	private static final String SERVICE_KEY = "TestService";
	
	@BeforeEach
	public void setMockOutput() {
		
		lenient().when(serviceDao.findServiceById(anyString())).thenAnswer(
				(InvocationOnMock invocation) -> {
					                            if (invocation.getArgument(0).equals(SERVICE_KEY)) {
					                            	Services service = new Services();
					                            	service.setId(SERVICE_KEY);
					                            	return service;
					                            } else {
					                            	return null;
					                            }
					
				});
		Answer<?> returnParameterAsAnswer = (InvocationOnMock invocation) -> {
			return invocation.getArgument(0);
		};
		
		lenient().when(serviceDao.save(any(Services.class))).thenAnswer(returnParameterAsAnswer);
	}
	
	
	
	@Test
	public void testCreateService() {
		String name = "jxnwqjdbq";
		float cost = 6;
		int duration = 4;
		String id = "wjqdq";
		ServiceType serviceType = ServiceType.BodyRepair;
		Services services = null;
		services = service.createService(name, cost, duration, id, serviceType);
		assertNotNull(services);
	}

	
	@Test
	public void testGetServices() {
		Services services = null;
		
		try {
			services = service.getServices(SERVICE_KEY);
		} catch(IllegalArgumentException e) {
			fail();
		}
		
		assertNotNull(services);
		assertEquals(SERVICE_KEY,services.getId());
	}
	
	@Test
	public void testGetServicesInvalid() {
		Services services = null;
		String error = null;
		try {
			services = service.getServices("xhsbdj");
		} 
		 catch(IllegalArgumentException e) {
		  error = e.getMessage();
	}
		assertNull(services);
		assertEquals("No service found with this Id!",error);
		
}

}
