package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Service;
@Repository
public interface ServiceRepository extends CrudRepository<Service, String> {

	Service findSerivceByServiceType(String serviceType);

}