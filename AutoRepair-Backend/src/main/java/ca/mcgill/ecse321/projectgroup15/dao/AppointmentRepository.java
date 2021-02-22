package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Appointment;
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, String>{

	Appointment findApointmentByAppointmentID(String appointmentID);

}