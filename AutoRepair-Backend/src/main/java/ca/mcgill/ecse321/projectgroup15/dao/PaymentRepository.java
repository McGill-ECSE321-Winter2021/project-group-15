package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Customer;
import ca.mcgill.ecse321.projectgroup15.model.Payment;
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long>{

	//List all the payments made by a customer using its ID
	List<Payment> findPaymentByCustomer(Customer id);
		
	Payment findPaymentById(Long paymentId);

}
