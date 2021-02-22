package ca.mcgill.ecse321.projectgroup15.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ca.mcgill.ecse321.projectgroup15.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	User findUserByUserId(String UserId);

}