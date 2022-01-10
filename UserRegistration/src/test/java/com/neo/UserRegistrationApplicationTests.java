package com.neo;

import java.util.Date;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.neo.model.User;
import com.neo.repository.UserRepository;

@SpringBootTest
class UserRegistrationApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	
	

	@Test
	void findUserById() {
		Assert.notNull(userRepository.findById(1));
	}
	
	@Test
	void findAllUser() {
		Assert.notNull(userRepository.findAll());
	}
	
	@Test
	void addUser() {
		Date date = new Date();
		User user = new User(1,"Saurabh","Dharamkar","Akola","1234",date,date,0);
		Assert.notNull(userRepository.save(user));
	}
	
	@Test
	void updateUser() {
		Date date = new Date();
		User user = new User(1,"Saurabh","Dharamkar","Akola","1234",date,date,0);
		Assert.notNull(userRepository.save(user));
	}
	
	@Test
	void findByFirstName() {
		Assert.notNull(userRepository.findByFirstName("Abhi"));
	}
	
	@Test
	void findByLastName() {
		Assert.notNull(userRepository.findByLastName("Ugale"));
	}
	
	@Test
	void findByPinCode() {
		Assert.notNull(userRepository.findByPinCode("444108"));
	}
	
	@Test
	void findByOrderByDob() {
		Assert.notNull(userRepository.findByOrderByDobAsc());
	}
	
	@Test
	void findByOrderByDoj() {
		Assert.notNull(userRepository.findByOrderByDojAsc());
	}
	
	@Test
	void deleteUserById() {
		userRepository.deleteById(3);
		assertThat(userRepository.existsById(3)).isFalse();
	}
	
	@Test
	void deleteFlagStatus() {
		Assert.notNull(userRepository.findByUserId(2));
	}
	
	@Test
	void getAllActiveUsers() {
		Assert.notNull(userRepository.getAllActiveUsers());
	}
	
	@Test
	void getByFNameLNameOrPinCode() {
		Assert.notNull(userRepository.findByFirstNameOrLastNameOrPinCode("Samadhan","Ugale","444108"));
	}

}
