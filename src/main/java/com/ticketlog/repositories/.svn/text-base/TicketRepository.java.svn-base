package com.ticketlog.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ticketlog.models.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer>{
	
	@Query(value = "SELECT *FROM ticket.allticket where assineed_flag='A' and status='O'", nativeQuery = true)
     public List<Ticket> findAllAssinedTicket();
	
	@Query(value = "SELECT *FROM ticket.allticket where assineed_flag IS  NULL OR status='RO'", nativeQuery = true)
    public List<Ticket> findAllTicketWithoutAssign();
	
	@Query(value = "SELECT *FROM ticket.allticket where assineed_flag='A'", nativeQuery = true)
    public List<Ticket> findAllAssinedTiketForClose();
	
	
	@Query(value = "SELECT *FROM ticket.allticket where developer_user_name=?1 and assineed_flag='A' and (status='RO' or status='O') ORDER BY id DESC;", nativeQuery = true)
    public List<Ticket> getByDeveloperUserName(String userId);
    
    
	@Query(value = "SELECT *FROM ticket.allticket where developer_user_name=?1 and status='C' ORDER BY id DESC;", nativeQuery = true)
    public List<Ticket> findAllCompletedbyDeveloper(String userId);
    
    public List<Ticket> findBySenderName(String sName);

    @Query(value = "SELECT *FROM ticket.allticket where status='C' ORDER BY id DESC;", nativeQuery = true)
	public List<Ticket> getCompletedTicket();
    
   public List<Ticket>findByPrirityAndStatus(String pririty,String status);
  
   public List<Ticket>findBystatus(String status);	
   
   public List<Ticket>findByDeveloperUserNameAndStatus(String userId,String status);	
   
   public List<Ticket>findByDeveloperUserName(String developerUserId);
   
   
   /* this method give all ticket list having assign flag A*/
   @Query(value = "SELECT *FROM ticket.allticket where assineed_flag='A' and subticket_id is null ", nativeQuery = true)
   public List<Ticket> findAllTicket();
  
   public List<Ticket> findByPrirityAndAssineedFlag(String pririty,String assignFlag);
   public List<Ticket> findByDeveloperUserNameAndAssineedFlag(String userId,String assignFlag);
   
 //  public List<Ticket> findByTicketRaisedDateBetweenAndAssineedFlag(Date d1,Date d2,String saasigFlag);//
   public List<Ticket> findByTicketRaisedDateBetween(Date d1,Date d2);//
   
   public List<Ticket> findByAssinedDateBetweenAndAssineedFlag(Date d1,Date d2,String saasigFlag);
   
   public List<Ticket> findByActualEnddateBetweenAndAssineedFlag(Date d1,Date d2,String saasigFlag);
   
   
   public List<Ticket> findByPrirityAndDeveloperUserNameAndAssineedFlag(String priority,String userName,String assignflag);
   
   public List<Ticket> findByPrirityAndDeveloperUserNameAndAssineedFlagAndTicketRaisedDateBetween(String priority,String userName,String assignflag,Date d1,Date d2);
   
   public List<Ticket> findByPrirityAndDeveloperUserNameAndAssineedFlagAndAssinedDateBetween(String priority,String userName,String assignflag,Date d1,Date d2);
   
   public List<Ticket> findByPrirityAndDeveloperUserNameAndAssineedFlagAndActualEnddateBetween(String priority,String userName,String assignflag,Date d1,Date d2);
   
   
   public List<Ticket> findByDeveloperUserNameAndAssineedFlagAndTicketRaisedDateBetween(String userName,String assignflag,Date d1,Date d2);
   
   public List<Ticket> findByDeveloperUserNameAndAssineedFlagAndAssinedDateBetween(String userName,String assignflag,Date d1,Date d2);
   
   public List<Ticket> findByDeveloperUserNameAndAssineedFlagAndActualEnddateBetween(String userName,String assignflag,Date d1,Date d2);
   
   public List<Ticket> findByDeveloperUserNameAndTicketRaisedDateBetween(String userName,Date d1,Date d2);
   
   /* combination of priority and date type*/
   
   public List<Ticket> findByPrirityAndTicketRaisedDateBetweenAndAssineedFlag(String priority, Date d1,Date d2,String assignFlag);
   public List<Ticket> findByPrirityAndAssinedDateBetweenAndAssineedFlag(String priority,Date d1,Date d2,String assignFlag);
   public List<Ticket> findByPrirityAndActualEnddateBetweenAndAssineedFlag(String priority,Date d1,Date d2,String assignFlag);
  
  public List<Ticket> findByDeveloperUserNameAndAssineedFlagAndStatus(String developerId,String assignFlag,String status);
  
  
  public List<Ticket> findBySubticketIdAndAssineedFlag(String subTicketId,String flag);
  
  public List<Ticket> findBySubticketId(String subTicketId);
  
  
  /*monthly report list*/
  
 
  public List<Ticket> findByStatus(String status);
 
  
  
  
  /*  */
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
   
   
   
	
}
