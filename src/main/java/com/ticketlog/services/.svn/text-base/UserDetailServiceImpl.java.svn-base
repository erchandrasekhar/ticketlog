package com.ticketlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ticketlog.models.CustomUserMaster;
import com.ticketlog.models.UserMaster;


@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	UserMasterService userMasterService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserMaster user = userMasterService.findUserByUserName(username);
		
		if(user != null){
			return new CustomUserMaster(user);
		}
		else{
			throw new UsernameNotFoundException("User " + username + " was not found in the database");
		}
		
	}

}
