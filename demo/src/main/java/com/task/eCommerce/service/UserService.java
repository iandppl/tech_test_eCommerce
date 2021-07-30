package com.task.eCommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.eCommerce.model.UserAccount;
import com.task.eCommerce.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public UserAccount findUserByEmail(String email) {
		return userRepository.findById(email).orElse(null);
	}
	
	public UserAccount createNewUser(UserAccount user) {
		return userRepository.save(user);
	}
}
