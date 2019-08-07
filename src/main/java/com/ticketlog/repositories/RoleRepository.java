package com.ticketlog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketlog.models.Role;


public interface RoleRepository extends CrudRepository<Role, Long>{
	
	public Role findByRoleName(String roleName);

}
