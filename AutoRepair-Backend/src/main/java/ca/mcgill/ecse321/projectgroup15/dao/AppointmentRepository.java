package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Appointment;
import ca.mcgill.ecse321.projectgroup15.model.Customer;
import ca.mcgill.ecse321.projectgroup15.model.Service;
import ca.mcgill.ecse321.projectgroup15.model.Technician;
import ca.mcgill.ecse321.projectgroup15.model.TimeSlot;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String>{

	//List all the appointments booked by a customer using its Id
		List<Appointment> findAppointmentByCustomer(Customer id);
		
		//List all the appointments for a technician using its Id
		List<Appointment> findAppointmentByTechnician(Technician id) ;

		// Check if a specified time slot and service exists
		boolean existsByTimeslotAndService(TimeSlot tsId, Service service);
		
		Appointment findApointmentById(int appointmentID);

}