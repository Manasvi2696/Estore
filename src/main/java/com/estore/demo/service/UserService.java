package com.estore.demo.service;

import java.util.List;
import java.util.Optional;

import com.estore.demo.model.User;

public interface UserService {
	
	
	List<User> getAll();
	
	Optional<User> getbyId(int id);
	
	User Create(User user);
	
	void deleteById(int id);
	
}
