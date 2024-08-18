package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.model.UserPrincipal;
import com.project.model.Users;
import com.project.repo.UserRepo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MyUserDetailService  implements UserDetailsService{

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<Users> user = repo.findByUsername(username);
		
		if(user.isEmpty()) {
			log.info("User not found");
			throw new UsernameNotFoundException("User not found");
		}
		
		return new UserPrincipal(user.get());
	}
	
	
	public List<Users> getAllUsers(){
		return repo.findAll();
	}
	
	

}
