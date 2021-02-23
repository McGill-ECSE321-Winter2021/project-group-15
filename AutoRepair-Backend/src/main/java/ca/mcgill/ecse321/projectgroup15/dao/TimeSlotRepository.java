package ca.mcgill.ecse321.projectgroup15.dao;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.Service;
import ca.mcgill.ecse321.projectgroup15.model.Technician;
import ca.mcgill.ecse321.projectgroup15.model.TimeSlot;


@Repository
public interface TimeSlotRepository extends CrudRepository<TimeSlot, String> {

	//List all the time slots available for a service by specifying Type
	List<TimeSlot> findByService(Service serviceType);
	
	//List all the time slots of a technician using its userId
	List<TimeSlot> findByTechnician(Technician userId);
	
	TimeSlot findTimeSlotByTsId(String tsId);

}