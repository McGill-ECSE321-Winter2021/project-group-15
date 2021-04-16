package ca.mcgill.ecse321.projectgroup15.dao;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Services;
import ca.mcgill.ecse321.projectgroup15.model.Technician;

@Repository
public interface ServiceRepository extends CrudRepository<Services, String> {
	//List all the services offered by a technician using its Id
		List<Services> findServiceByTechnician (Technician userId);
		
		Services findSerivceByServiceType(String serviceType);
		
		Services findServiceById(String Id);
}
