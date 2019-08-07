package com.ticketlog.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ticketlog.models.DeveloperRemarks;
import com.ticketlog.models.Remark;
import com.ticketlog.models.Ticket;
import com.ticketlog.repositories.DevelopersRepository;
import com.ticketlog.repositories.RemarkRepository;
import com.ticketlog.repositories.RoleRepository;
import com.ticketlog.repositories.TicketRepository;
import com.ticketlog.repositories.UserMasterRepository;
import com.ticketlog.repositories.UserRoleRepository;

@Controller
public class AjaxControllar {

	@Autowired
	TicketRepository ticketRepository;

	@Autowired
	UserMasterRepository userMasterRepository;

	@Autowired
	UserMasterRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	UserRoleRepository userRoleRepository;

	
	 @Autowired
	 RemarkRepository remarkRepository;
	
	 @Autowired
	 DevelopersRepository developerRepository;
	 
	 @ResponseBody
	 @RequestMapping(value="getAssignDev",method=RequestMethod.GET)
		public ArrayList<Ticket> getDeveloperList(HttpServletRequest request,Model modelMap)
		
		{  
			
			 List<Ticket> assinedTicketList=(List<Ticket>) ticketRepository.findAllAssinedTicket();
			
			   return (ArrayList<Ticket>) assinedTicketList;
			
		}
		
	 
	 @ResponseBody
	 @RequestMapping(value="priotityList",method=RequestMethod.GET)
		public ArrayList<Ticket> ticketListByPriority(HttpServletRequest request,Model modelMap, @RequestParam(required=true)String priority)
		
		{  
			
		 ArrayList<Ticket> ticketList=new ArrayList<>();
		
		 String status="C";
			
		 if(priority.equals("ALL"))
		 {
			 ticketList =(ArrayList<Ticket>) ticketRepository.findBystatus(status);
		 }
		 else{
			 ticketList =(ArrayList<Ticket>) ticketRepository.findByPrirityAndStatus(priority,status);  
			  
		 }
		
		    return ticketList;
			
		}
	 
	 
	 @ResponseBody
	 @RequestMapping(value="ticketListByUserId",method=RequestMethod.GET)
		public ArrayList<Ticket> getTicketListByUserId(HttpServletRequest request,Model modelMap, @RequestParam(required=true)String userId)
		
		{  
			
		 ArrayList<Ticket> ticketList=new ArrayList<>();
		
		 String status="C";
		 	
		 String userIName=userId.toString();
		
			 ticketList =(ArrayList<Ticket>) ticketRepository.findByDeveloperUserNameAndStatus(userIName, status);
		    return ticketList;
			
		}
	 
	 
	 
	 @ResponseBody
	 @RequestMapping(value="getAllRemaks",method=RequestMethod.GET)
		public ArrayList<Remark> getAllRemaks(HttpServletRequest request,Model modelMap, @RequestParam(required=true)String ticketId)
		
		{  
		 int  ticketIdPk=Integer.parseInt(ticketId);
		
		 ArrayList<Remark> remaksList=new ArrayList<>();
		 
		 remaksList=(ArrayList<Remark>) remarkRepository.findByTicketId(ticketIdPk);
		
		     return remaksList;
			
		}
	 
	 
	 @ResponseBody
	 @RequestMapping(value="getAllDeveloperRemaks",method=RequestMethod.GET)
		public ArrayList<DeveloperRemarks> getAllDeveloperRemaks(HttpServletRequest request,Model modelMap, @RequestParam(required=true)String ticketId)
		
		{  
		 int  ticketIdPk=Integer.parseInt(ticketId);
		
		 ArrayList<DeveloperRemarks> devloperRemaksList=new ArrayList<>();
		 
		 devloperRemaksList=(ArrayList<DeveloperRemarks>) developerRepository.findByTicketId(ticketIdPk);
		
		     return devloperRemaksList;
			
		}
	 
	 
	 @ResponseBody
	 @RequestMapping(value="getPrivousAssignmentDeveloperList",method=RequestMethod.GET)
		public ArrayList<Ticket>  getPrivousAssignmentDeveloperList(HttpServletRequest request,Model modelMap, @RequestParam(required=true)String devloperUserId)
		{   
		      String userId=request.getParameter("devloperUserId");
		
		       List<Ticket>assignTicketList=ticketRepository.findByDeveloperUserName(userId);
		      /* modelMap.addAttribute("assignTicketList", assignTicketList);*/
			   return (ArrayList<Ticket>) assignTicketList;
			
		}
	
	 
	 
	 @ResponseBody
	 @RequestMapping(value="getAllSubTicket",method=RequestMethod.GET)
		public ArrayList<Ticket>  getAllSubTicketList(HttpServletRequest request,Model modelMap, @RequestParam(required=true)String parentTicketId)
		{   
		 int  parentTicketIdPk=Integer.parseInt(parentTicketId);
		       System.out.println("parent ticket Id from ajax controller:"+parentTicketIdPk);
		       
		       List<Ticket>assignTicketList=ticketRepository.findBySubticketIdAndAssineedFlag(parentTicketId,"A");
		       System.out.println(assignTicketList.size());
		     
			   return (ArrayList<Ticket>) assignTicketList;
			
		}
	 
	 
	 @ResponseBody
	 @RequestMapping(value="getList",method=RequestMethod.GET)
		public ArrayList<Ticket>  getList(HttpServletRequest request,Model modelMap, @RequestParam(required=true)String cid)
		{   
		 int  cId=Integer.parseInt(cid);
		      
		       System.out.println("from ajax");
		 List<Ticket>ticketList=new ArrayList<>();
		       
		     if(cId==1)
				{

		    	ticketList=ticketRepository.findByStatus("C");
			    
			      
				}
				if(cId==2)
				{
				
					ticketList=ticketRepository.findByStatus(null);
				      
				}
				if(cId==3)
				{
				
					 ticketList=ticketRepository.findByStatus("O");
							
				} 
				
		     
			   return (ArrayList<Ticket>) ticketList;
			
		}
	 
	 
	 
	
	 
	
}
