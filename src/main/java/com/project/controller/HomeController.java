package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Users;
import com.project.service.MyUserDetailService;

@RestController
public class HomeController {
	
	@Autowired
	MyUserDetailService userService;
	
	@GetMapping("/")
	public String getHome() {
		return "At Home!!!";
	}
	
	@GetMapping("/allUsers")
	public List<Users> getAllUsers(){
		return userService.getAllUsers();
	}
	
	

}
