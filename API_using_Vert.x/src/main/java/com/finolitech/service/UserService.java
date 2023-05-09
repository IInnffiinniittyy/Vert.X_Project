package com.finolitech.service;

import java.util.List;
import com.finolitech.entity.User;

public interface UserService {

     public List<User> getAllUserDetails();
	
	 public String addUserDetails(User user);
	 
	 public User updateUserDetails(Integer id, User user);
	
}