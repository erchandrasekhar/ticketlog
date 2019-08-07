package com.ticketlog.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ticketlog.models.Remark;
import com.ticketlog.models.Ticket;


public interface RemarkRepository extends CrudRepository<Remark, Integer>{

	public List<Remark> findByTicketId(Integer ticketId);
	
	@Query(value = "SELECT user_remarks FROM ticket.allremark where id=(select max(id) from ticket.allremark where ticket_id=?1)", nativeQuery = true)
    public String findLastUserRemarkt(int ticketId);
	
	
/*	
	@Query(value = "SELECT user_remarks FROM ticket.allremark where ticket_id=?1", nativeQuery = true)
    public ArrayList<String> findAllUserRemarks(Integer ticketId);
	*/
	  public List<Remark>findByTicketId(int ticketId);
	
}
