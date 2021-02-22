package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.projectgroup15.model.AdministrativeAssistant;

public interface AdministrativeAssistantRepository extends CrudRepository<AdministrativeAssistant, String>{

	AdministrativeAssistant findAdministrativeAssistantByAdminID(String adminID);

}