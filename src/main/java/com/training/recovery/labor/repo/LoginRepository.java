package com.training.recovery.labor.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.training.recovery.labor.model.User;

@Repository
public interface LoginRepository extends CrudRepository<User, Integer> {

	@Query(value = "select * from user where username= :username and password= :password", nativeQuery = true)
	public User findUserByUsernameAndPassword(String username, String password);

}
