package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;
import ca.mcgill.ecse321.projectgroup15.model.Administrator;

public interface AdministratorRepository extends CrudRepository<Administrator, String>{

	Administrator findAdministratorById(int id);	

}
