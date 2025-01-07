package com.estore.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estore.demo.model.User;
import com.estore.demo.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {

	private static final Logger logger = LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userservice;
	
	@GetMapping("/all")
	public List<User> getUser(){
		logger.info("Fatching All Users...");
		return userservice.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable int id){
		Optional<User> user = userservice.getbyId(id);
		if (user.isPresent()) {
			logger.info("Fatching User with id : "+id);
            return ResponseEntity.ok(user.get());
        } else {
			logger.info("User with id : "+id+" is not found");
            return ResponseEntity.notFound().build();
        }
	}
	
	@PostMapping("/CreateUser")
	public User CreateUser(@RequestBody User user) {
		logger.info("Creating new User...");
		return userservice.Create(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
		logger.info("Deleting user with id:"+id);
	Optional<User> user = userservice.getbyId(id);
    if (user.isPresent()) {
    	userservice.deleteById(id);
		logger.info("User with id : "+id+" deleted");
        return ResponseEntity.noContent().build();
    } else {
		logger.info("User with id : "+id+" not found");
        return ResponseEntity.notFound().build();
    }
    }
}
