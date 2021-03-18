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
import ca.mcgill.ecse321.projectgroup15.model.*;

@ExtendWith(MockitoExtension.class)
public class TestAutoRepairServicePayment {
	
	@Mock
	private PaymentRepository paymentDao;
	
	@InjectMocks
	private AutoRepairService service;
	
	private static final String PAYMENT_KEY = "TestPayment";
	
	
	
	@BeforeEach
	public void setMockOutput() {
		
		lenient().when(paymentDao.findPaymentById(anyString())).thenAnswer(
				(InvocationOnMock invocation) -> {
					                            if (invocation.getArgument(0).equals(PAYMENT_KEY)) {
					                            	Payment payment = new Payment();
					                            	payment.setId(PAYMENT_KEY);
					                            	return payment;
					                            } else {
					                            	return null;
					                            }
					
				});
		Answer<?> returnParameterAsAnswer = (InvocationOnMock invocation) -> {
			return invocation.getArgument(0);
		};
		
		lenient().when(paymentDao.save(any(Payment.class))).thenAnswer(returnParameterAsAnswer);
	}
	
	
	
	@Test
	public void testCreatePayment() {
		String id = "xqwjbq";
		float totalCost = 8;
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Payment payment = null;
		try {
			payment = service.createPayment(id, totalCost, date);
		} catch(IllegalArgumentException e) {
			fail();
		}
		assertNotNull(payment);
		assertEquals(id,payment.getId());
		assertEquals(totalCost,payment.getTotalCost());
		assertEquals(date,payment.getDate());
	}
	
	@Test
	public void testCreatePaymentIdNull() {
		String id = null;
		float totalCost = 8;
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Payment payment = null;
		String error = null;
		try {
			payment = service.createPayment(id, totalCost, date);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(payment);
		assertEquals("There is no payment with this id",error);
		
	}
	
	@Test
	public void testCreatePaymentDateNull() {
		String id = "xghwvd";
		float totalCost = 8;
		Date date = null;
		Payment payment = null;
		String error = null;
		try {
			payment = service.createPayment(id, totalCost, date);
		} catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		assertNull(payment);
		assertEquals("please mention the date",error);
		
	}
	
	@Test
	public void testGetPayment() {
		
		Payment payment = null;
		try {
			payment = service.getPayment(PAYMENT_KEY);
		} catch(IllegalArgumentException e) {
			fail();
		}
		
		assertNotNull(payment);
		assertEquals(PAYMENT_KEY,payment.getId());
	}
	
	@Test 
	public void testGetPaymentInvalid() {
		Payment payment = null;
		String error = null;
		try {
			payment = service.getPayment("nxsbjcb");
		}catch(IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(payment);
		assertEquals("No Payment found with this Id!",error);
	}

}
