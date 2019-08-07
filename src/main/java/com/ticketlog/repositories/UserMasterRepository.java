package com.ticketlog.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ticketlog.models.UserMaster;





public interface UserMasterRepository extends CrudRepository<UserMaster, Long>{	

	
	public UserMaster findByUserName(String user_name);
	
}
