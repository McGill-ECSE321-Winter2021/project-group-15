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

import ca.mcgill.ecse321.projectgroup15.dao.AppointmentRepository;
import ca.mcgill.ecse321.projectgroup15.model.*;

@ExtendWith(MockitoExtension.class)
public class TestAutoRepairServiceAppointment {
	
	@Mock
	private AppointmentRepository appointmentDao;
	
	@InjectMocks
	private AutoRepairService service;
	
	private static final String APPOINTMENT_KEY = "TestAppointment";
	
	@BeforeEach
	public void setMockOutput() {
		
		lenient().when(appointmentDao.findPersonByName(anyString())).thenAnswer( (InvocationOnMock invocation) -> {
	        if(invocation.getArgument(0).equals(APPOINTMENT_KEY)) {
	            Appointment appointment = new Appointment();
	            appointment.setName(APPOINTMENT_KEY);
	            return appointment;
	        } else {
	            return null;
	        }
	    });
		
		@Test
		public void testGetAppointment() {
			Appointment appointment = null;
			
			try {
				appointment = service.getAppointment(APPOINTMENT_KEY);
			} catch (IllegalArgumentException e) {
				fail();
			}
			
			assertNotNull(appointment);
			assertEquals(APPOINTMENT_KEY,appointment.getService());
		}
		
		@Test
		public void testGetAppointmentInvalid() {
			Appointment appointment = null;
			String error = null;
			try {
				appointment = service.getAppointment(APPOINTMENT_KEY);
			} catch (IllegalArgumentException e) {
				fail();
			}
			
			assertNotNull(appointment);
			assertEquals("No oppointment foud with this Id", error);
		}
		@Test
		public void testCreateAppointment() {
			assertEquals(0, service.getAllAppointment().size());
			
			String service = "sdfses";
			String customer = "ffsrfv";
			String technician = "fsdggd";
			String ts = "srdgsg";
			String payment = "dsfscv";
			String Id = "sdfsd";
			Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
			
			Appointment appointment = null;
			try {
				customer = service.createAppointment(customer, technician, ts, payment, Id);
			} catch (IllegalArgumentException e) {
				fail();
				assertNotNull(appointment);
				assertEquals(customer,appointment.getCustomer());
				assertEquals(technician,appointment.getTechnician());
				assertEquals(ts,appointment.getTimeslot());
				assertEquals(payment,appointment.getPayment());
				assertEquals(Id,appointment.getId());
		}	
		
	}
}
