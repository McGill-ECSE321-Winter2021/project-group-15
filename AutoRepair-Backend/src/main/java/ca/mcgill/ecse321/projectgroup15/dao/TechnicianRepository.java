package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;

<<<<<<< HEAD
=======


>>>>>>> Rania1
import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.projectgroup15.model.Technician;
<<<<<<< HEAD

public interface TechnicianRepository extends CrudRepository<Technician, String>{

	Technician findTechnicianByTechnicianID(String technicianID);

	
	Technician findTechnicianByUserID(String UserID);


}
=======
@Repository
public interface TechnicianRepository extends CrudRepository<Technician, Long>{

	Technician findTechnicianById(Long id);
}
>>>>>>> Rania1
