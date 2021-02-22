package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;

import ca.mcgill.ecse321.projectgroup15.model.AdminstrativeAssistant;

public interface AdministrativeAssistantRepository extends CrudRepository<AdminstrativeAssistant, String>{

	AdminstrativeAssistant findAdministrativeAssistantByAdminID(String adminID);

}