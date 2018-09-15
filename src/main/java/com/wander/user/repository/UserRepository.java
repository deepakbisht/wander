package com.wander.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wander.user.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username,String password);
}
