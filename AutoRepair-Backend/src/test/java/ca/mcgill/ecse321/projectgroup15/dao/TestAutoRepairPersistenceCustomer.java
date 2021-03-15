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
public class TestAutoRepairPersistenceCustomer {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	
	
	@AfterEach
	public void clearDatabase() {
		
		
		customerRepository.deleteAll();
		
		
		
		
	}
	
	@Test
	public void PersistAndLoadCustomer() {
		
		RepairShop auto2 = new RepairShop();
		
		 
		
		
		String username = "saa";
		String cardNumber = "xsdw";
		String password = "344";
		String userId = "dededw";
		String cvv = "xwdqwdq";
		String email = "wesfr";
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		String id = "dejiejd";
		auto2.setId(id);
		
		
		
		
		Customer customer = new Customer();
		
		customer.setUsername(username);
		customer.setCardNumber(cardNumber);
		customer.setId(userId);
		customer.setPassword(password);
		customer.setCvv(cvv);
		customer.setEmail(email);
		customer.setExpiry(date);
		customer.setRepairShop(auto2);
		
		
		customerRepository.save(customer);
		
		customer = null;
		
		customer = customerRepository.findCustomerById(userId);
		
		assertNotNull(customer);
		assertEquals(username,customer.getUsername());
		assertEquals(cardNumber,customer.getCardNumber());
		assertEquals(password,customer.getPassword());
		assertEquals(userId,customer.getId());
		assertEquals(cvv,customer.getCvv());
		assertEquals(email,customer.getEmail());
		assertEquals(date,customer.getExpiry());
		assertEquals(auto2,customer.getRepairShop());
		assertEquals(auto2.getId(),customer.getRepairShop().getId());
		
	}
	

}
