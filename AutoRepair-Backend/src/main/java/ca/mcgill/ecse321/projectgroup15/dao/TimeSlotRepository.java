package ca.mcgill.ecse321.projectgroup15.dao;

<<<<<<< HEAD
import java.sql.Date;
import java.sql.Time;
=======

>>>>>>> Rania1
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Service;
import ca.mcgill.ecse321.projectgroup15.model.Technician;
import ca.mcgill.ecse321.projectgroup15.model.TimeSlot;


@Repository
<<<<<<< HEAD
public interface TimeSlotRepository extends CrudRepository<TimeSlot, String> {

	//List all the time slots available for a service by specifying Type
	List<TimeSlot> findByService(Service serviceType);
	
	//List all the time slots of a technician using its userId
	List<TimeSlot> findByTechnician(Technician userId);
	
	TimeSlot findTimeSlotByTsId(String tsId);

=======
public interface TimeSlotRepository  extends CrudRepository<TimeSlot, Long> {
	    //List all the time slots available for a service by specifying Type
		List<TimeSlot> findTimeSlotByService(Service serviceType);
		
		//List all the time slots of a technician using its userId
		List<TimeSlot> findTimeSlotByTechnician(Technician id);
		
		TimeSlot findTimeSlotById(Long tsId);
>>>>>>> Rania1
}