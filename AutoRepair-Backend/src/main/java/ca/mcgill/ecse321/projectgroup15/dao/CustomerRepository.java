package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.projectgroup15.model.Customer;
import ca.mcgill.ecse321.projectgroup15.model.Appointment;

<<<<<<< HEAD
public interface CustomerRepository extends CrudRepository<Customer, String>{

	List<Customer> findCustomerByUsername(String username);
	
	Customer findByCustomerAndAppointment(String username, String appointmentID);
	
}
=======
public interface CustomerRepository extends CrudRepository<Customer, Long>{
	
	Customer findCustomerById(Long id);
}
>>>>>>> Rania1
