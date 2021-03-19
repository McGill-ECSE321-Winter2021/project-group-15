package ca.mcgill.ecse321.projectgroup15.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.anyInt;
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

import ca.mcgill.ecse321.projectgroup15.dao.TimeSlotRepository;
import ca.mcgill.ecse321.projectgroup15.model.*;

@ExtendWith(MockitoExtension.class)
public class TestAutoRepairServiceTimeSlot {

	@Mock
	private TimeSlotRepository timeSlotDao;
	
	@InjectMocks
	private AutoRepairService service;
	
	private static final int TIMESLOT_KEY = 4;
	
	@BeforeEach
	public void setMockOutput() {
		
		lenient().when(timeSlotDao.findTimeSlotById(anyInt())).thenAnswer(
				(InvocationOnMock invocation) -> {
					                            if (invocation.getArgument(0).equals(TIMESLOT_KEY)) {
					                            	TimeSlot ts = new TimeSlot();
					                            	ts.setId(TIMESLOT_KEY);
					                            	return ts;
					                            } else {
					                            	return null;
					                            }
					
				});
		Answer<?> returnParameterAsAnswer = (InvocationOnMock invocation) -> {
			return invocation.getArgument(0);
		};
		
		lenient().when(timeSlotDao.save(any(TimeSlot.class))).thenAnswer(returnParameterAsAnswer);
	}
	
	@Test
	public void testCreateTimeSlot() {
		assertEquals(0, service.getAllTimeSlots().size());
		
		//createTimeSlot(int id,Date date, Time startTime, Time endTime, Technician technician )
		
		int id = 26;
		Date date = java.sql.Date.valueOf(LocalDate.of(2020, Month.JANUARY, 31));
		Time startTime = java.sql.Time.valueOf(LocalTime.of(14, 56));
		Time endTime = java.sql.Time.valueOf(LocalTime.of(17, 57));
		Technician technician = new Technician();
		TimeSlot ts = null;
		
		try {
			ts = service.createTimeSlot(id, date, startTime, endTime, technician);
		} catch (IllegalArgumentException e) {
			fail();
		}
		assertNotNull(ts);
		assertEquals(id,ts.getId());
		assertEquals(date,ts.getDate());
		assertEquals(startTime,ts.getStartTime());
		assertEquals(endTime,ts.getEndTime());
		assertEquals(technician,ts.getTechnician());
	}
	
	@Test
	public void testGetTimeSlot() {
		TimeSlot ts = null;
		
		try {
			ts = service.getTimeSlot(TIMESLOT_KEY);
		} catch (IllegalArgumentException e) {
			fail();
		}
		
		assertNotNull(ts);
		assertEquals(TIMESLOT_KEY,ts.getId());
	}
	
	@Test
	public void testGetTimeSlotInvalid() {
		TimeSlot ts = null;
		String error = null;
		
		try {
			ts = service.getTimeSlot(0);
		} catch (IllegalArgumentException e) {
			error = e.getMessage();
		}
		
		assertNull(ts);
		assertEquals("No timeSlot found with this Id!",error);
	}
	

	
}
