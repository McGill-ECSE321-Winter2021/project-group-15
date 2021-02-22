package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Payment;
@Repository
public interface PaymentRepository extends CrudRepository<Payment, String>{

	Payment findPaymentByPaymentId(String paymentId);

}