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
public class TestAutoRepairPersistencePayment {
	
	
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	
	@AfterEach
	public void clearDatabase() {
		
		
		paymentRepository.deleteAll();
	
		
		
		
	}
	
	@Test
	public void PersistAndLoadPayment() {
		
		RepairShop auto2 = new RepairShop();
		
		String username = "saa";
		String cardNumber = "xsdw";
		String password = "344";
		int userId = 5;
		String cvv = "xwdqwdq";
		String email = "wesfr";
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		int id = 4;
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
		
		
		String paymentId = "kfrj";
		
		float cost = 34;
		
		Payment payment = new Payment();
		payment.setDate(date);
		payment.setId(paymentId);
		payment.setRepairShop(auto2);
		payment.setTotalCost(cost);
		
		paymentRepository.save(payment);
		
		payment = null;
		
		payment = paymentRepository.findPaymentById(paymentId);
		
		assertNotNull(payment);
		assertEquals(date,payment.getDate());
		assertEquals(paymentId,payment.getId());
		assertEquals(customer.getRepairShop(), payment.getRepairShop());
		assertEquals(cost, payment.getTotalCost());
		assertEquals(customer.getUsername(),payment.getCustomer().getUsername());
		assertEquals(customer.getCardNumber(),payment.getCustomer().getCardNumber());
		assertEquals(customer.getId(),payment.getCustomer().getId());
		assertEquals(customer.getPassword(),payment.getCustomer().getPassword());
		assertEquals(customer.getCvv(),payment.getCustomer().getCvv());
		assertEquals(customer.getEmail(),payment.getCustomer().getEmail());
		assertEquals(customer.getExpiry(),payment.getCustomer().getExpiry());
	}

	


}
