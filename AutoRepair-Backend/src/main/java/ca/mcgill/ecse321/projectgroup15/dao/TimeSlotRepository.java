package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.TimeSlot;

@Repository
public interface TimeSlotRepository extends CrudRepository<TimeSlot, String> {

	TimeSlot findTimeSlotByTsId(String tsId);

}