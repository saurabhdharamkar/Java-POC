package com.neo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.neo.model.User;

public interface UserRepository extends JpaRepository<User,Integer>{

	User findByFirstName(String firstName);

	User findByLastName(String lastName);

	User findByPinCode(String pinCode);

	User findByUserId(int userId);

	User findByOrderByDob();
	
	List<User> findByOrderByDojAsc();

	List<User> findByOrderByDobAsc();

	@Query("from User u where u.deleted=0")
	List<User> getAllActiveUsers();
    
	List<User> findByFirstNameOrLastNameOrPinCode(String firstName, String lastName, String pinCode);



}
