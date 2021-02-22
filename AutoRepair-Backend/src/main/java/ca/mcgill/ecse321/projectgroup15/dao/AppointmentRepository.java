package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Appointment;
import ca.mcgill.ecse321.projectgroup15.model.Customer;
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String>{
	
	List<Appointment> findByPerson(Customer lastName);

	Appointment findApointmentByAppointmentID(String appointmentID);

}