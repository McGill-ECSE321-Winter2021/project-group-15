package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.projectgroup15.model.Customer;
import ca.mcgill.ecse321.projectgroup15.model.Appointment;

public interface CustomerRepository extends CrudRepository<Customer, String>{
	
	Customer findCustomerById(String id);
}
