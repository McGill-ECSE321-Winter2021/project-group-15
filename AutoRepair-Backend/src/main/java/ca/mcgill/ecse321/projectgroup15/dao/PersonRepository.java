package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.projectgroup15.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
	Person findPersonById(String UserId);
}
