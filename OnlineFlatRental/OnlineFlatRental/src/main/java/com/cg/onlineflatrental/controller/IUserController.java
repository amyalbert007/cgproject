package com.cg.onlineflatrental.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineflatrental.exception.UserNotFoundException;
import com.cg.onlineflatrental.model.*;
import com.cg.onlineflatrental.service.IUserService;

@RestController 
@RequestMapping("/flatbooking")
public class IUserController { 
	Logger logger=LoggerFactory.getLogger(IUserController.class);
	@Autowired 
	private IUserService iUserService;
	
	@GetMapping("/viewAllUser")
	public List<User> viewAllUser(){
		logger.info("In controller.....viewAllUser() started");
		return  iUserService.viewAllUser();//(List<User>)
	} 
	
/*	@GetMapping("/viewUser/{userId}")
	public User viewUser(@PathVariable Integer userId) throws UserNotFoundException {
		return iUserService.viewUser(userId);
	}	*/
	
	@GetMapping("/viewUser/{userId}")
	public ResponseEntity viewUser(@PathVariable Integer userId) throws UserNotFoundException {
		User user= iUserService.viewUser(userId);
		logger.info("In controller.....viewUser() started");
		return new ResponseEntity(user,HttpStatus.OK); 
		
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User users) {
		logger.info("In controller.....addUser() started");
		return iUserService.addUser(users);
	}
	
/*	@DeleteMapping("/removeUser/{userId}")
	public void removeUser(@PathVariable Integer userId ) {
		//return 
				iUserService.removeUser(userId);
	}*/

/*	@DeleteMapping("/removeUser/{userId}")
	public ResponseEntity removeUser(@PathVariable Integer userId ) {
		//return 
				iUserService.removeUser(userId);
				logger.info("In controller.....removeUser() started");
				return new ResponseEntity("User data deleted succesfully",HttpStatus.OK);
	}		*/
	
	@DeleteMapping("/removeUser/{userId}")
	public ResponseEntity removeUser(@PathVariable Integer userId ) throws UserNotFoundException {
		//return 
				iUserService.removeUser(userId);
				logger.info("In controller.....removeUser() started");
				return new ResponseEntity("User data deleted succesfully",HttpStatus.OK);
	}	
	
	@PutMapping("/updatePassword/{password:.+}/{userId}")
	public User updatePassword(@PathVariable String password ,@PathVariable Integer userId) {
		logger.info("In controller.....updatePassword() started");
		return iUserService.updatePassword(userId, password);
		
	}
	
	@GetMapping("validateUser/{userName}/{password}")
	public ResponseEntity validateUser(@PathVariable String userName,@PathVariable String password) throws UserNotFoundException {
		iUserService.validateUser(userName, password);
		logger.info("In controller.....validateUser() started");
		return new ResponseEntity("User Validation Completed Succesfully!",HttpStatus.OK);
	} 
	
	
/*	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User users) {
		users.setUserId(users.getUserId());
		users.setPassword(users.getPassword());
		users.getUserName();
		users.getUserType();
		return	iUserService.updateUser(users);
		//return iUserService.updateUser(userName,userType);
	}*/
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User users){
		User user1=iUserService.updateUser(users);
		logger.info("In controller.....updateUser() started");
		return user1; 
	}

}
