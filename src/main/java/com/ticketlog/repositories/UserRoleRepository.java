package com.ticketlog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ticketlog.models.Role;
import com.ticketlog.models.UserRole;



public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
	public List<UserRole> findByRole(Role role);
	
	
	
}
