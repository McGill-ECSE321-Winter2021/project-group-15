package ca.mcgill.ecse321.projectgroup15.dao;
import java.util.List;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Service;
import ca.mcgill.ecse321.projectgroup15.model.Technician;
<<<<<<< HEAD
@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {

	//List all the services offered by a technician using its Id
	List<Service> findByTechnician (Technician userId);
	
	Service findSerivceByServiceType(String serviceType);
}
=======

@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {
	//List all the services offered by a technician using its Id
		List<Service> findServiceByTechnician (Technician userId);
		
		Service findSerivceByServiceType(String serviceType);
}
>>>>>>> Rania1
