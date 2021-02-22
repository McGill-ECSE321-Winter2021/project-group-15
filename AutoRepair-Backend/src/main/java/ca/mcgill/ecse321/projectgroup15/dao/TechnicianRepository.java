package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.projectgroup15.model.Technician;

public interface TechnicianRepository extends CrudRepository<Technician, String>{

	Technician findTechnicianByTechnicianID(String technicianID);

}