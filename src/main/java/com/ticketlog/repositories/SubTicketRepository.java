package com.ticketlog.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.ticketlog.models.SubTicket;


public interface SubTicketRepository extends CrudRepository<SubTicket, Integer>{

	List<SubTicket> findByTicketId(String ticketicketId);
	List <SubTicket> findByAssineedFlag(String assignFlag);
	

	public List<SubTicket> findByAssineedFlagAndStatusAndDeveloperUserName(String asignFlag,String status,String devloperUserId);
	
	

	List<SubTicket> findByAssineedFlagAndDeveloperUserName(String asignFlag, String dvId);
	

}

