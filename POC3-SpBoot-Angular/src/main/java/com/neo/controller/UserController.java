package com.neo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neo.model.User;
import com.neo.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		user.setDeleted(0);
		return userService.addUser(user);
	}
	
	
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		List<User>list=null;
		return list=userService.getAllUsers();
	}
	
	@GetMapping("/getUserById/{userId}")
	public Optional<User> getUserById(@PathVariable("userId")int userId) {
		
		return userService.getUserById(userId);
	}
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@RequestBody User user,@PathVariable("userId")int userId) {
		Optional<User> check=userService.getUserById(userId);
		if(check.isPresent()) {
		user.setUserId(userId);
		 userService.addUser(user);
		}
		return user;
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	
	public void deleteUser(@PathVariable("userId")int userId) {
		userService.deleteUserById(userId);
	}
	
     @DeleteMapping("/deleteUserFlag/{userId}")
	
	public User deleteUserFlag(@PathVariable("userId")int userId) {
		User user=userService.getUserByFlagId(userId);
		
			user.setDeleted(1);
			
			return userService.addUser(user);
		
	}
	
	@GetMapping("/getByFirstName/{firstName}")
	public List<User> getByFirstName(@PathVariable("firstName") String firstName) {
		
		return userService.getByFirstNameLike(firstName);
		
	}


	@GetMapping("/getByLastName/{lastName}")
	public List<User> getByLastName(@PathVariable("lastName") String lastName) {
		
		return userService.getByLastName(lastName);
		
	}
	
	@GetMapping("/getByPinCode/{pinCode}")
	public List<User> getByPinCode(@PathVariable("pinCode") String pinCode) {
		
		return userService.getByPinCode(pinCode);
		
	}
	
	@GetMapping("/sortByDoj")	
	public List<User> findByOrderByDojAsc(){
		return userService.findByOrderByDojAsc();
	 }
	
	@GetMapping("/sortByDob")	
	public List<User> findByOrderByDobAsc(){
		
		return userService.findByOrderByDobAsc();
	 }
	
	@GetMapping("/sortByFirstName")	
	public List<User> findByOrderByFirstNameAsc(){
		
		return userService.findByOrderByDobAsc();
	 }

	@GetMapping("/getActiveUsers")//it shows record whose deleted=0
	public List<User> getAllActiveUser(){
		return userService.getAllActiveUsers();
	}
	
	
	@GetMapping("/get/{firstName}/{lastName}/{pinCode}")
	public List<User> getUserByFirstNameLastNamePinCode(@PathVariable("firstName")String  firstName,@PathVariable("lastName")String lastName,@PathVariable("pinCode")String pinCode){
		return userService.findByFirstLastNamePinCode(firstName,lastName,pinCode);
	}
	
	

}
