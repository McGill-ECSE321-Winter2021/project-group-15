package ca.mcgill.ecse321.projectgroup15.service;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import ca.mcgill.ecse321.projectgroup15.*;
import ca.mcgill.ecse321.projectgroup15.dao.PersonRepository;
import ca.mcgill.ecse321.projectgroup15.dao.AppointmentRepository;
import ca.mcgill.ecse321.projectgroup15.dao.TimeSlotRepository;
import ca.mcgill.ecse321.projectgroup15.dao.ServiceRepository;


import ca.mcgill.ecse321.projectgroup15.model.Person;
import ca.mcgill.ecse321.projectgroup15.model.Appointment;
import ca.mcgill.ecse321.projectgroup15.model.TimeSlot;
import ca.mcgill.ecse321.projectgroup15.model.ServiceType;
//import ca.mcgill.ecse321.projectgroup15.model.Service;

import ca.mcgill.ecse321.projectgroup15.model.*;

@Service
public class AutoRepairService {
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Autowired
	TimeSlotRepository timeSlotRepository;

	
	// to change since Person is abstract class (cannot be instanciated)
	@Transactional
	public Person createPerson(String email, String username, String password ) {
		Person person = new Person();
		person.setEmail(email);
		person.setPassword(password);
		person.setUsername(username);
		//person.setId(id);
		personRepository.save(person);
		return person;
	}
	
	@Transactional
	public Person getPerson(String id) {
		Person person = personRepository.findPersonById(id);
		return person;
	}
	
	@Transactional
	public List<Person> getAllPersons(){
		return toList(personRepository.findAll());
	}
	

	@Transactional
	public TimeSlot createTimeSlot(int id,Date date, Time startTime, Time endTime, Technician technician ) {
		TimeSlot ts = new TimeSlot();
		ts.setId(ts.getDate().hashCode() * ts.getStartTime().hashCode() * ts.getEndTime().hashCode() * ts.getTechnician().hashCode());
		ts.setDate(date);
		ts.setStartTime(startTime);
		ts.setEndTime(endTime);
		ts.setTechnician(technician);
		//ts.setService(service);
		timeSlotRepository.save(ts);
		return ts;
	}
	
//	@Transactional
//	public TimeSlot getTimeSlot(Service service) {
//		TimeSlot ts = timeSlotRepository.findTimeSlotByService(service);
//		return ts;
//	}
	
	@Transactional
	public List<TimeSlot> getAllTimeSlots(){
		return toList(timeSlotRepository.findAll());
	}
	
	@Transactional
	public Appointment createAppointment(Customer customer, Technician technician, Service service, TimeSlot ts, Payment payment) {
		Appointment apt = new Appointment();
		apt.setCustomer(customer);
		apt.setTechnician(technician);
		apt.setTimeslot(ts);
		apt.setPayment(payment);
		apt.setId(apt.getCustomer().hashCode());
		appointmentRepository.save(apt);
		return apt;
	}

	
	private <T> List<T> toList(Iterable<T> iterable){
		List<T> resultList = new ArrayList<T>();
		for (T t : iterable) {
			resultList.add(t);
		}
		return resultList;
	}
	
}
