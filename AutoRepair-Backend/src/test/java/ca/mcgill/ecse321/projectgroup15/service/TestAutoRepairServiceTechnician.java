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
import java.time.LocalTime;
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
import ca.mcgill.ecse321.projectgroup15.dao.TechnicianRepository;
import ca.mcgill.ecse321.projectgroup15.model.*;

@ExtendWith(MockitoExtension.class)
public class TestAutoRepairServiceTechnician {
	
	@Mock
	private TechnicianRepository technicianDao;
	
	@InjectMocks
	private AutoRepairService service;
	
	private static final String TECHNICIAN_KEY = "TestCustomer";
	
	private static final String TECHNICIAN_PASSWORD = "csxa";
	
	@BeforeEach
	public void setMockOutput() {
		
		lenient().when(technicianDao.findTechnicianByUsername(anyString())).thenAnswer(
				(InvocationOnMock invocation) -> {
					                            if (invocation.getArgument(0).equals(TECHNICIAN_KEY)) {
					                            	Technician technician = new Technician();
					                            	technician.setUsername(TECHNICIAN_KEY);
					                            	technician.setPassword(TECHNICIAN_PASSWORD);
					                            	return technician;
					                            } else {
					                            	return null;
					                            }
					
				});
		Answer<?> returnParameterAsAnswer = (InvocationOnMock invocation) -> {
			return invocation.getArgument(0);
		};
		
		lenient().when(technicianDao.save(any(Technician.class))).thenAnswer(returnParameterAsAnswer);
	}
	
	@Test
	public void testCreateTechnician() {
		assertEquals(0, service.getAllTechnicians().size());
		
		//createTechnician (String email, String username, String password, String lastName, String firstName, TechnicianRole technicianRole)
		String email = "wedsdw";
		String username = "vgbjrfe";
		String password = "crgerf";
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		
		Technician technician = null;
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertNotNull(technician);
		assertEquals(email,technician.getEmail());
		assertEquals(username,technician.getUsername());
		assertEquals(password,technician.getPassword());
		assertEquals(TechnicianRole.BodyRepair,technician.getTechnicianRole());
		
	}
	
	@Test
	public void testCreateTechnicianUsernameNull() {
		
		String email = "wedsdw";
		String username = null;
		String password = "crgerf";
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		
		String error = null;
		Technician technician = null;
		
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("Username cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateTechnicianUsernameEmpty() {
		
		String email = "wedsdw";
		String username = "";
		String password = "crgerf";
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		
		String error = null;
		Technician technician = null;
		
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("Username cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateTechnicianPasswordNull() {
		
		String email = "wedsdw";
		String username = "xewcweckw";
		String password = null;
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		
		String error = null;
		Technician technician = null;
		
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("Password cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateTechnicianPasswordEmpty() {
		
		String email = "wedsdw";
		String username = "xewcweckw";
		String password = "";
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		
		String error = null;
		Technician technician = null;
		
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("Password cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateTechnicianUsernameAndPasswordNull() {
		String email = "wedsdw";
		String username = null;
		String password = null;
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		
		String error = null;
		Technician technician = null;
		
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("Username and password cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateTechnicianUsernameAndPasswordEmpty() {
		String email = "wedsdw";
		String username = "";
		String password = "";
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		
		String error = null;
		Technician technician = null;
		
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("Username and password cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateTechnicianEmailEmpty() {
		
		String email = "";
		String username = "xewcweckw";
		String password = "cxjced";
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		
		String error = null;
		Technician technician = null;
		
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("Email is required!",error);
		
	}
	
	@Test
	public void testCreateTechnicianEmailNull() {
		
		String email = null;
		String username = "xewcweckw";
		String password = "cxjced";
		String lastName = "xdnqw";
		String firstName = "ncjdqw";
		String error = null;
		Technician technician = null;
		
		try {
			technician = service.createTechnician(email, username, password,lastName,firstName, TechnicianRole.BodyRepair);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("Email is required!",error);
		
	}
	
	@Test
	public void testGetTechnician() {
		Technician technician = null;
		
		try {
			technician = service.getTechnician(TECHNICIAN_KEY);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertNotNull(technician);
		assertEquals(TECHNICIAN_KEY,technician.getUsername());
		
	}
	
	@Test
	public void testGetTechnicianInvalid() {
		Technician technician = null;
		String error = null;
		try {
			technician = service.getTechnician("cewxdqw");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(technician);
		assertEquals("No technician found with this username!",error);
	}
	

	
	@Test
	public void testChangeTechnicianPassword() {
		String password = "dewdwdx";
		Technician technician = null;
		try {
			technician = service.changeTechnicianPassword(TECHNICIAN_KEY, password);
		} catch (IllegalArgumentException e) {
			
			fail();
			
		}
		assertNotNull(technician);
		assertEquals(TECHNICIAN_KEY,technician.getUsername());
		assertEquals(password,technician.getPassword());
	}
	
	@Test
	public void testChangeTechnicianPasswordUsernameNull() {
		String password = "dewdwdx";
		Technician technician = null;
		String error = null;
		try {
			technician = service.changeTechnicianPassword(null, password);
		} catch (IllegalArgumentException e) {
			
			error = e.getMessage();
			
		}
		assertNull(technician);
		assertEquals("Username cannot be empty!",error);
		
		
	}
	
	@Test
	public void testChangeTechnicianPasswordNull() {
		String password = null;
		Technician technician = null;
		String error = null;
		try {
			technician = service.changeTechnicianPassword(TECHNICIAN_KEY, password);
		} catch (IllegalArgumentException e) {
			
			error = e.getMessage();
			
		}
		assertNull(technician);
		assertEquals("New password cannot be empty!",error);
		
		
	}
	
	
	
	@Test
	public void testLoginAsTechnician() {
		
		
		Technician technician = null;
		
		try {
			technician = service.loginAsTechnician(TECHNICIAN_KEY, TECHNICIAN_PASSWORD);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertNotNull(technician);
		assertEquals(TECHNICIAN_KEY,technician.getUsername());
		assertEquals(TECHNICIAN_PASSWORD,technician.getPassword());
		
	}
	
	@Test
	public void testLoginAsTechnicianUsernameNull() {
		Technician technician = null;
		String error = null;
		
		try {
			technician = service.loginAsTechnician(null, TECHNICIAN_PASSWORD);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(technician);
		assertEquals("Username cannot be empty.",error);
	}
	
	@Test
	public void testLoginAsTechnicianUsernameEmpty() {
		Technician technician = null;
		String error = null;
		
		try {
			technician = service.loginAsTechnician("", TECHNICIAN_PASSWORD);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(technician);
		assertEquals("Username cannot be empty.",error);
	}
	
	@Test
	public void testLoginAsTechnicianPasswordEmpty() {
		Technician technician = null;
		String error = null;
		
		try {
			technician = service.loginAsTechnician(TECHNICIAN_KEY, "");
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(technician);
		assertEquals("Password cannot be empty.",error);
	}
	
	@Test
	public void testLoginAsCustomerPasswordNull() {
		Technician technician = null;
		String error = null;
		
		try {
			technician = service.loginAsTechnician(TECHNICIAN_KEY, null);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(technician);
		assertEquals("Password cannot be empty.",error);
	}
	
	

}
