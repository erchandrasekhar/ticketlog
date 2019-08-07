package com.ticketlog.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.ticketlog.models.DeveloperRemarks;

public interface DevelopersRepository extends CrudRepository<DeveloperRemarks, Integer>{
	public List<DeveloperRemarks>findByTicketId(int ticketId);
	
}
