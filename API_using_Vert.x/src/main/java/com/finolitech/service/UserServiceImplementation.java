package com.finolitech.service;

import java.util.List;

import com.finolitech.entity.User;
import com.finolitech.repository.UserRepository;

public class UserServiceImplementation implements UserService {

	// creating a new object of UserRepository type, which can be used later in the code...
	private UserRepository userRepository = new UserRepository();
	
	
	@Override
	public List<User> getAllUserDetails() {
		return userRepository.getAllUsers();
	}

	@Override
	public String addUserDetails(User user) {
		return userRepository.registerUser(user);
	}

	@Override
	public User updateUserDetails(Integer id, User user) {
		return userRepository.updateUser(id, user);
	}

}
