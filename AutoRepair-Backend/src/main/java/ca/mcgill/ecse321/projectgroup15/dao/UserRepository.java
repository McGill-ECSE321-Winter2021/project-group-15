package ca.mcgill.ecse321.projectgroup15.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ca.mcgill.ecse321.projectgroup15.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	List<User> findByFirstName(String firstName);
	
	List<User> findByLastName(String lastName);
		
	List<User> findByFirstAndLast(String firstName, String lastName);
	 // to check
	boolean existsByUser(User user);
	
	User findUserByUserId(String UserId);
	
}