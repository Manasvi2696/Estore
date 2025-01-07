package com.estore.demo.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estore.demo.model.User;
import com.estore.demo.repository.UserRepository;
import com.estore.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userrepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userrepository = userRepository;
    }
    
	@Override
	public List<User> getAll() {
		return userrepository.findAll();
	}

	@Override
	public Optional<User> getbyId(int id) {
		return userrepository.findById(id);
	}

	@Override
	public User Create(User user) {
		return userrepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		userrepository.deleteById(id);
	}
}
