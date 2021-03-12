package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Technician;
@Repository
public interface TechnicianRepository extends CrudRepository<Technician, Long>{

	Technician findTechnicianById(Long id);
}
