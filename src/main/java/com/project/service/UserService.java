package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.model.Users;
import com.project.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo repo;
	
	private BCryptPasswordEncoder ecoder = new BCryptPasswordEncoder(12);
	
	public Users register(Users user) {
		user.setPassword(ecoder.encode(user.getPassword()));
		return repo.save(user);
	}
}
