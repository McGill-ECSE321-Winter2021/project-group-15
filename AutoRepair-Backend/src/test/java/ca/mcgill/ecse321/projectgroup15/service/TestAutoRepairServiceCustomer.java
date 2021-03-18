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
import ca.mcgill.ecse321.projectgroup15.model.*;

@ExtendWith(MockitoExtension.class)
public class TestAutoRepairServiceCustomer {
	
	@Mock
	private CustomerRepository customerDao;
	
	@InjectMocks
	private AutoRepairService service;
	
	private static final String CUSTOMER_KEY = "TestCustomer";
	
	private static final String CUSTOMER_PASSWORD = "cefw";
	
	@BeforeEach
	public void setMockOutput() {
		
		lenient().when(customerDao.findCustomerByUsername(anyString())).thenAnswer(
				(InvocationOnMock invocation) -> {
					                            if (invocation.getArgument(0).equals(CUSTOMER_KEY)) {
					                            	Customer customer = new Customer();
					                            	customer.setUsername(CUSTOMER_KEY);
					                            	customer.setPassword(CUSTOMER_PASSWORD);
					                            	return customer;
					                            } else {
					                            	return null;
					                            }
					
				});
		Answer<?> returnParameterAsAnswer = (InvocationOnMock invocation) -> {
			return invocation.getArgument(0);
		};
		
		lenient().when(customerDao.save(any(Customer.class))).thenAnswer(returnParameterAsAnswer);
	}
	
	@Test
	public void testCreateCustomer() {
		assertEquals(0, service.getAllCustomers().size());
		
		//createCustomer(String email, String username, String password, String lastName, String firstname)
		
		String email = "wedsdw";
		String username = "vgbjrfe";
		String password = "crgerf";
		String lastName = "swsewf";
		String firstName = "zsdqw";
		Customer customer = null;
		try {
			customer = service.createCustomer(email, username, password, lastName, firstName);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertNotNull(customer);
		assertEquals(email,customer.getEmail());
		assertEquals(username,customer.getUsername());
		assertEquals(password,customer.getPassword());
		assertEquals(lastName,customer.getLastName());
		assertEquals(firstName,customer.getFirstName());
	}
	
	@Test
	public void testCreateCustomerUsernameNull() {
		
		String email = "wedsdw";
		String username = null;
		String password = "crgerf";
		String lastName = "swsewf";
		String firstName = "zsdqw";
		String error = null;
		Customer customer = null;
		
		try {
			customer = service.createCustomer(email, username, password, lastName, firstName);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(customer);
		assertEquals("Customer name cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateCustomerUsernameEmpty() {
		
		String email = "wedsdw";
		String username = "";
		String password = "crgerf";
		String lastName = "swsewf";
		String firstName = "zsdqw";
		String error = null;
		Customer customer = null;
		
		try {
			customer = service.createCustomer(email, username, password, lastName, firstName);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(customer);
		assertEquals("Customer name cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateCustomerPasswordNull() {
		
		String email = "wedsdw";
		String username = "xewcweckw";
		String password = null;
		String lastName = "swsewf";
		String firstName = "zsdqw";
		String error = null;
		Customer customer = null;
		
		try {
			customer = service.createCustomer(email, username, password, lastName, firstName);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(customer);
		assertEquals("Customer password cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateCustomerPasswordEmpty() {
		
		String email = "wedsdw";
		String username = "xewcweckw";
		String password = "";
		String lastName = "swsewf";
		String firstName = "zsdqw";
		String error = null;
		Customer customer = null;
		
		try {
			customer = service.createCustomer(email, username, password, lastName, firstName);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(customer);
		assertEquals("Customer password cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateCustomerUsernameAndPasswordNull() {
		String email = "wedsdw";
		String username = null;
		String password = null;
		String lastName = "swsewf";
		String firstName = "zsdqw";
		String error = null;
		Customer customer = null;
		
		try {
			customer = service.createCustomer(email, username, password, lastName, firstName);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(customer);
		assertEquals("Customer name and password cannot be empty!",error);
		
	}
	
	@Test
	public void testCreateCustomerUsernameAndPasswordEmpty() {
		String email = "wedsdw";
		String username = "";
		String password = "";
		String lastName = "swsewf";
		String firstName = "zsdqw";
		String error = null;
		Customer customer = null;
		
		try {
			customer = service.createCustomer(email, username, password, lastName, firstName);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(customer);
		assertEquals("Customer name and password cannot be empty!",error);
		
	}
	
	@Test
	public void testGetCustomer() {
		Customer customer = null;
		
		try {
			customer = service.getCustomer(CUSTOMER_KEY);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertNotNull(customer);
		assertEquals(CUSTOMER_KEY,customer.getUsername());
		
	}
	
	@Test
	public void testGetCustomerInvalid() {
		Customer customer = null;
		String error = null;
		try {
			customer = service.getCustomer("dewd");
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(customer);
		assertEquals("No admin found with this username!",error);
	}
	
	
	
	@Test
	public void testChangeCustomerPassword() {
		String password = "dewdwdx";
		Customer customer = null;
		try {
			customer = service.changeCustomerPassword(CUSTOMER_KEY, password);
		} catch (IllegalArgumentException e) {
			
			fail();
			
		}
		assertNotNull(customer);
		assertEquals(CUSTOMER_KEY,customer.getUsername());
		assertEquals(password,customer.getPassword());
	}
	
	@Test
	public void testChangeCustomerPasswordUsernameEmpty() {
		String password = "dewdwdx";
		Customer customer = null;
		String error = null;
		try {
			customer = service.changeCustomerPassword(null, password);
		} catch (IllegalArgumentException e) {
			
			error = e.getMessage();
			
		}
		assertNull(customer);
		assertEquals("Username cannot be empty!",error);
		
		
	}
	
	@Test
	public void testChangeCustomerPasswordEmpty() {
		String password = null;
		Customer customer = null;
		String error = null;
		try {
			customer = service.changeCustomerPassword(CUSTOMER_KEY, password);
		} catch (IllegalArgumentException e) {
			
			error = e.getMessage();
			
		}
		assertNull(customer);
		assertEquals("New password cannot be empty!",error);
		
		
	}
	
	
	
	@Test
	public void testLoginAsCustomer() {
		Customer customer = null;
		
		try {
			customer = service.loginAsCustomer(CUSTOMER_KEY, CUSTOMER_PASSWORD);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertNotNull(customer);
		assertEquals(CUSTOMER_KEY,customer.getUsername());
		assertEquals(CUSTOMER_PASSWORD,customer.getPassword());
		
	}
	
	@Test
	public void testLoginAsCustomerUsernameNull() {
		Customer customer = null;
		String error = null;
		
		try {
			customer = service.loginAsCustomer(null, CUSTOMER_PASSWORD);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(customer);
		assertEquals("Username cannot be empty.",error);
	}
	
	@Test
	public void testLoginAsCustomerUsernameEmpty() {
		Customer customer = null;
		String error = null;
		
		try {
			customer = service.loginAsCustomer("", CUSTOMER_PASSWORD);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(customer);
		assertEquals("Username cannot be empty.",error);
	}
	
	@Test
	public void testLoginAsCustomerPasswordEmpty() {
		Customer customer = null;
		String error = null;
		
		try {
			customer = service.loginAsCustomer(CUSTOMER_KEY, "");
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(customer);
		assertEquals("Password cannot be empty.",error);
	}
	
	@Test
	public void testLoginAsCustomerPasswordNull() {
		Customer customer = null;
		String error = null;
		
		try {
			customer = service.loginAsCustomer(CUSTOMER_KEY, null);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(customer);
		assertEquals("Password cannot be empty.",error);
	}
	
	

}
