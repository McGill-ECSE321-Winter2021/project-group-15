package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.AdministrativeAssistant;

@Repository
public interface AdministrativeAssistantRepository extends CrudRepository<AdministrativeAssistant, String>{

	AdministrativeAssistant findAdministrativeAssistantByUserID(String userId);

}