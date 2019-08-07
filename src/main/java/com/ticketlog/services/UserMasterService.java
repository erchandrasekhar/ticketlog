package com.ticketlog.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ticketlog.models.Role;
import com.ticketlog.models.UserMaster;
import com.ticketlog.models.UserRole;
import com.ticketlog.repositories.RoleRepository;
import com.ticketlog.repositories.UserMasterRepository;


@Service
public class UserMasterService {

	
	@Autowired
	UserMasterRepository userMasterRepository;
	
	@Autowired
	RoleRepository roleRepository;
	public UserMaster findUserByid(Long id){
		UserMaster userMaster=null;
		try{
			userMaster = userMasterRepository.findOne(id);
		}catch(Exception ex){
			 userMaster=null;
		}	
		return userMaster;
	}
	
	
	public UserMaster findUserByUserName(String userName){
		UserMaster userMaster=null;
		try{
			userMaster = userMasterRepository.findByUserName(userName);
		}catch(Exception ex){
			 userMaster=null;
		}	
		return userMaster;
	}
	public UserMaster saveUser(){
		UserMaster user = new UserMaster();
        user.setUserName("user");
        user.setFirstName("User first");
        user.setActive(true);
        user.setEmail("user@gmail.com");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode("password"));
        user.setMobile("1234");
        
        UserRole userRole = new UserRole();
        //Role role = roleRepo.findOne(new Long(150));
        Role role = new Role();
        role.setRoleDesc("user1");
        role.setRoleName("USER");
        roleRepository.save(role);
        
        userRole.setRole(role);
        userRole.setUserMaster(user);
        Set<UserRole> roles = new HashSet<>();
        roles.add(userRole);
        user.setUserRole(roles);
        userMasterRepository.save(user);	
		return user;
	}
	
	public UserMaster findUserById(long id){
		UserMaster userMaster=null;
		try{
			userMaster = userMasterRepository.findOne(id);
		}catch(Exception ex){
			 userMaster=null;
		}	
		return userMaster;
	}
	
	
}
