package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.projectgroup15.model.Technician;

public interface TechnicianRepository extends CrudRepository<Technician, String>{
<<<<<<< Updated upstream

	Technician findTechnicianByTechnicianID(String technicianID);
=======
	
	Technician findTechnicianByUserID(String UserID);
>>>>>>> Stashed changes

}