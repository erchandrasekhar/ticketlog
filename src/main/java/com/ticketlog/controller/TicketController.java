package com.ticketlog.controller;



import java.security.Principal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ticketlog.models.DeveloperRemarks;
import com.ticketlog.models.InstanceType;
import com.ticketlog.models.Remark;
import com.ticketlog.models.SubTicket;
import com.ticketlog.models.Ticket;
import com.ticketlog.models.UserMaster;
import com.ticketlog.models.UserRole;
import com.ticketlog.repositories.DevelopersRepository;
import com.ticketlog.repositories.InstanceTypeRepository;
import com.ticketlog.repositories.RemarkRepository;
import com.ticketlog.repositories.RoleRepository;
import com.ticketlog.repositories.SubTicketRepository;
import com.ticketlog.repositories.TicketRepository;
import com.ticketlog.repositories.UserMasterRepository;
import com.ticketlog.repositories.UserRoleRepository;

import javassist.expr.NewArray;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@Controller
public class TicketController {

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
	    private JavaMailSender sender;
	
	 @Autowired
	 RemarkRepository remarkRepository;
	 
	 @Autowired
	 DevelopersRepository developerRepository;
	 
	 @Autowired
	 InstanceTypeRepository instanceTypeRepository;
	 @Autowired
	 SubTicketRepository subTicketRepository;
	 
	 
	 private static final Logger LOGGER = LogManager.getLogger(TicketController.class);
		
	   
	/* this method is responsible rise new Ticket */
	@RequestMapping(value="addTicket",method=RequestMethod.POST)
	public ModelAndView getTicketLog(HttpServletRequest request,Model modelMap,Principal principal)
	{   
		Remark remark=new Remark();
		
		Ticket ticket=new Ticket();
		
	 	String name=request.getParameter("empName");
		String email=request.getParameter("email");
		String mobile=request.getParameter("mobile");
		String priority=request.getParameter("priority");
		String subject=request.getParameter("subject").replace("'", "").replace("\"", "").replace("@", "").replace("#", "").replace("$", "").replace("%", "").replace("^", "").replace("_", "").replace("+", "");		
		String sorce=request.getParameter("instance");
		String ticketType=request.getParameter("ticketType");
		
	    
		ticket.setSenderName(name);
		ticket.setSenderEmail(email);
		ticket.setMobileMobile(mobile);
		ticket.setPririty(priority);
		ticket.setTicketText(subject);
		ticket.setSorce(sorce);
		ticket.setTicketType(ticketType);
		ticket.setTicketRiseDateAndTime(new Date());
		ticket.setTicketRaisedDate(new Date());
		ticket.setSubticketId(null);
		
		ticketRepository.save(ticket);
		
      /*adding userRemarks into table*/
		
		remark.setUserRemarks(subject);
		remark.setUserRemarksTimeAndDate(new Date());
		remark.setTicketId(ticketRepository.save(ticket).getTicketId());
		remarkRepository.save(remark);
		
		if(ticketRepository.save(ticket).getTicketId()!=0)
		{
			System.out.println("sending email here");
			
			 MimeMessage message = sender.createMimeMessage();
		        MimeMessageHelper helper = new MimeMessageHelper(message);
		        String autoReplyText="This is a system generated message. Please do not reply to this e-mail.";
		       /* String adminEmail="";*/
		       String adminEmail="er.chandrasekharyadav@gmail.com";
		        try 
		        {        
		        	
		        	  /*List<UserRole> userRole = userRoleRepository.findByRole(roleRepo.findByRoleName("ADMIN"));
		        	    List<UserMaster> userList = new ArrayList<>();
		        	    for(UserRole u:userRole)
		        	    {
		        	    	UserMaster um = new UserMaster();
		        	     	um = u.getUserMaster();
		        	    	adminEmail=um.getEmail();
		        	    	
		        	        
		        	    }*/
		                
			           /* Sending mail for admin*/
			            helper.setTo(adminEmail);
			            helper.setText(name.toUpperCase()+"\n"+"Has Raised a ticket & his Ticket ID :"+ticketRepository.save(ticket).getTicketId()+"\n\n\n"+autoReplyText);
			            helper.setSubject("Pending Ticket");
			            
			            
			            
		        }
		        catch (MessagingException e) 
		        {
		            e.printStackTrace();
		           
		        }
		        sender.send(message);
		}
		
		modelMap.addAttribute("successMsg", "You have Successfully raised a Ticket and Your Ticket Id is::"+ticketRepository.save(ticket).getTicketId());
		
		
		  if(principal != null)
			{
				String name1 = principal.getName();
		        UserMaster loginUserDetails=userRepo.findByUserName(name1);
		       // System.out.println(loginUserDetails.getFirstName()+loginUserDetails.getEmail()+loginUserDetails.getMobile());
		        modelMap.addAttribute("loginUserDetails", loginUserDetails);
		        
			}
		    
		    List<InstanceType> instanceList=(List<InstanceType>) instanceTypeRepository.findAll();
			
			modelMap.addAttribute("instanceList", instanceList);
		    
		
		LOGGER.info("One ticket Raised");
		return new ModelAndView("ticketLoad");
		
	}
	

	
	
	@RequestMapping(value="getAllTicket",method=RequestMethod.GET)
	public ModelAndView getAllTicket(HttpServletRequest request,Model modelMap)
	{   
    List<Ticket> tiketList=(List<Ticket>) ticketRepository.findAllTicketWithoutAssign();
    
   /* sending all user list to jsp*/
    
    List<UserRole> userRole = userRoleRepository.findByRole(roleRepo.findByRoleName("DEVELOPER"));
    List<UserMaster> userList = new ArrayList<>();
    for(UserRole u:userRole){
    	UserMaster um = new UserMaster();
    	um = u.getUserMaster();
    	userList.add(um);
    }
    
    
    //List<UserMaster> userList=(List<UserMaster>) userMasterRepository.findAll();
		
		if(tiketList!=null)
			{
			   
				modelMap.addAttribute("tiketList", tiketList);
			}
		
		
		 if(userList!=null)
		 {
			 modelMap.addAttribute("userList", userList);
		 }
		 
		// List<SubTicket> subTicketList=(List<SubTicket>) subTicketRepository.findAll();
		 List<SubTicket>subTicketList=subTicketRepository.findByAssineedFlag(null);
		
		 modelMap.addAttribute("subTicketList", subTicketList);
		 
		return new ModelAndView("ticketListLoad");
		
	}
	
	
/*	######################################################this method assign ticket to developer#################################################*/
	
	@RequestMapping(value="assign",method=RequestMethod.GET)
	public ModelAndView assignTodeveloper(HttpServletRequest request,Model modelMap)
	{   
		
		
         Ticket ticket=new Ticket();
         int ticketId=Integer.parseInt(request.getParameter("ticketId"));
         String tlRemark=request.getParameter("tlRemark");
         int developerId=Integer.parseInt(request.getParameter("ticketId"));
         String developerUserName=request.getParameter("developerName");
         String planStartDate=request.getParameter("planStartDate");
         String planCompleteDate=request.getParameter("planCompleteDate");
         
         Date date1=null;
         Date date2=null;
       
        
		try {
			 date1 =(Date) new SimpleDateFormat("dd-MM-yyyy").parse(planStartDate);
			 date2=(Date)new SimpleDateFormat("dd-MM-yyyy").parse(planCompleteDate);
			 
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
      
        UserMaster userObject= userMasterRepository.findByUserName(developerUserName);
         
         String developerName=userObject.getFirstName();
         String assignFlage="A";
         String status="O";
        
          if(!tlRemark.equals(""))
          {   
        	  
              System.out.println(ticketId);
              System.out.println(tlRemark);
              System.out.println(developerId);
              
        	  ticket=ticketRepository.findOne(ticketId);
              ticket.setTlRemark(tlRemark);
              ticket.setAssinedDateAndTimeByTl(new Date());
              ticket.setAssinedDate(new Date());
              ticket.setAssineedFlag(assignFlage);
              ticket.setStatus(status);
              ticket.setDeveloperUserName(developerUserName);
              ticket.setDeveloperName(developerName);
              ticket.setTicketRiseDateAndTime(new Date());
             
               ticket.setPlanStartDate(date1);
              
              ticket.setPlanCompleteDate(date2);
              
              
           Ticket t =  ticketRepository.save(ticket);
           modelMap.addAttribute("successMsg", "You have Successfully Assigned Ticket");
   		
             
          }
          else
          {
        	  
        	  LOGGER.info("cant assign because remarks is blank");
          }
         
         List<Ticket> tiketList=(List<Ticket>) ticketRepository.findAllTicketWithoutAssign();
 		
 		if(tiketList!=null)
 			{
 			   
 				modelMap.addAttribute("tiketList", tiketList);
 			}
 		
 		
 		/*loading subticket list*/
 		
 		// List<SubTicket> subTicketList=(List<SubTicket>) subTicketRepository.findAll();
 		 List<SubTicket>subTicketList=subTicketRepository.findByAssineedFlag(null);
 		
 		 modelMap.addAttribute("subTicketList", subTicketList);
 		
 		 /* sending all user list to jsp*/
 	    
 	    List<UserRole> userRole = userRoleRepository.findByRole(roleRepo.findByRoleName("DEVELOPER"));
 	    List<UserMaster> userList = new ArrayList<>();
 	    for(UserRole u:userRole){
 	    	UserMaster um = new UserMaster();
 	    	um = u.getUserMaster();
 	    	userList.add(um);
 	    }
 	    

		 if(userList!=null)
		 {
			 modelMap.addAttribute("userList", userList);
		 }
 		
		 List<SubTicket>subList=subTicketRepository.findByAssineedFlag(null);
		 LOGGER.info("list subTicketList::::::"+subList.size());
		 
		return new ModelAndView("ticketListLoad");
		
	}
	
	
	@RequestMapping(value="getAllTicketByUserId",method=RequestMethod.GET)
	public ModelAndView getAllTicketByUserId(HttpServletRequest request,Model modelMap,Principal principal)
	{   
		String userId = principal.getName();
        List<Ticket> tiketListByUserId=(List<Ticket>) ticketRepository.getByDeveloperUserName(userId);
        List<UserMaster> userList=(List<UserMaster>) userMasterRepository.findAll();
		
       
		if(tiketListByUserId!=null)
			{
			   
				modelMap.addAttribute("tiketListByUserId", tiketListByUserId);
			}
		
		 if(userList!=null)
		 {
			 modelMap.addAttribute("userList", userList);
		 }
		 
		 List<SubTicket> subTicketListByUserId=subTicketRepository.findByAssineedFlagAndStatusAndDeveloperUserName("A", "O", userId);
		 LOGGER.info("subTicketListByUserId size::"+subTicketListByUserId.size());
		 
		 modelMap.addAttribute("subTicketListByUserId", subTicketListByUserId);
		 
		 
		return new ModelAndView("ticketListForDeveloperLoad");
		
	}
	
	
	@RequestMapping(value="getAllcompletedTicketByDeveloper",method=RequestMethod.GET)
	public ModelAndView getAllcompletedTicketByDeveloper(HttpServletRequest request,Model modelMap,Principal principal)
	{   
		String userId = principal.getName();
        List<Ticket> tiketListByUserId=(List<Ticket>) ticketRepository.findAllCompletedbyDeveloper(userId);
        
        LOGGER.info("meme..."+tiketListByUserId);
        List<UserMaster> userList=(List<UserMaster>) userMasterRepository.findAll();
		
       
		if(tiketListByUserId!=null)
			{
			   
				modelMap.addAttribute("tiketListByUserId", tiketListByUserId);
			}
		
		 if(userList!=null)
		 {
			 modelMap.addAttribute("userList", userList);
		 }
		 
		 
		
		 
		return new ModelAndView("completedByDeveloperLoad");
		
	}
	
	
	/* my ticket list page */
	
	@RequestMapping(value="getAllTicketByName",method=RequestMethod.GET)
	public ModelAndView getAllTicketByName(HttpServletRequest request,Model modelMap,Principal principal)
	{   
		String userId = principal.getName();
		
		UserMaster userMasterObject=new UserMaster();
		
		userMasterObject=userMasterRepository.findByUserName(userId);
		String senderName=userMasterObject.getFirstName();
		
		System.out.println("senderName::::::"+senderName);
		
        List<Ticket> tiketListBySenderName=(List<Ticket>) ticketRepository.findBySenderName(senderName);
        
        
        System.out.println(tiketListBySenderName.size());
        List<UserMaster> userList=(List<UserMaster>) userMasterRepository.findAll();
		
        
       
		if(tiketListBySenderName!=null)
			{
			   
				modelMap.addAttribute("tiketListBySenderName", tiketListBySenderName);
			}
		
		 if(userList!=null)
		 {
			 modelMap.addAttribute("userList", userList);
		 }
		return new ModelAndView("myTicketLoad");
		
	}
	
    
	@RequestMapping(value="raise",method=RequestMethod.GET)
	public ModelAndView ticket(HttpServletRequest request,Model modelMap,Principal principal)
	{   
   
		    if(principal != null)
			{
				String name = principal.getName();
		        UserMaster loginUserDetails=userRepo.findByUserName(name);
		       // System.out.println(loginUserDetails.getFirstName()+loginUserDetails.getEmail()+loginUserDetails.getMobile());
		        modelMap.addAttribute("loginUserDetails", loginUserDetails);
		        
			}
		    
		    List<InstanceType> instanceList=(List<InstanceType>) instanceTypeRepository.findAll();
			
			modelMap.addAttribute("instanceList", instanceList);
		    
		    
		return new ModelAndView("ticketLoad");
		
	}
	
	

	
	
	
	
	/*############# getting all assigned ticket list###########*/
	@RequestMapping(value="getAssignedTicket",method=RequestMethod.GET)
	public ModelAndView getAssignetTicket(HttpServletRequest request,Model modelMap)
	{   
		
     List<Ticket> assinedTicketList=(List<Ticket>) ticketRepository.findAllAssinedTicket();
		
       modelMap.addAttribute("assinedTicketList", assinedTicketList);
		   return new ModelAndView("assinedTicketLoad");
		
	}
	
	
	/*############# getting all completed ticket list###########*/
	@RequestMapping(value="getCompletedTicket",method=RequestMethod.GET)
	public ModelAndView getCompletedTicket(HttpServletRequest request,Model modelMap)
	{   
		
     List<Ticket> completedTicketList=(List<Ticket>) ticketRepository.getCompletedTicket();
		
       modelMap.addAttribute("completedTicketList", completedTicketList);
		   return new ModelAndView("completedTicketLoad");
		
	}
	
	
	
	/*############# get close ticket  ###########*/
	
	@RequestMapping(value="getclose",method=RequestMethod.GET)
	public ModelAndView getClose(HttpServletRequest request,Model modelMap)
	{   
		
     List<Ticket> assinedTicketList=(List<Ticket>) ticketRepository.findAllAssinedTiketForClose();
		
       modelMap.addAttribute("assinedTicketListForClose", assinedTicketList);
		   return new ModelAndView("closeTicketLoad");
		
	}
	
	
	/*############# close ticket after resolving  issues ###########*/
	
	@RequestMapping(value="closeTicket",method=RequestMethod.GET)
	public ModelAndView closeTicket(HttpServletRequest request,Model modelMap,Principal principal)
	{   
		 String userId = principal.getName();
		 Ticket ticket=new Ticket();
		  int ticketId=Integer.parseInt(request.getParameter("ticketId"));
		  String closeRemark=request.getParameter("closeRemark");
		  String deployedFlge=request.getParameter("deployed");
		  
		     String actualStartdate=request.getParameter("actualStartDate");
	         String actualEnddate=request.getParameter("actualEndDate");
	         String deployedDate=request.getParameter("deployedDate");
	         
	         /* formating string to stander date which coming from jsp */
	         Date asd=null;
			 
			 Date aed=null;
			 Date dd=null;
			 
			 try {
			     
				
				 asd =(Date) new SimpleDateFormat("dd-MM-yyyy").parse(actualStartdate);
				 aed=(Date)new SimpleDateFormat("dd-MM-yyyy").parse(actualEnddate);
				 if(!deployedDate.equals("")){
					 dd=(Date)new SimpleDateFormat("dd-MM-yyyy").parse(deployedDate); 
				 }
				 else{
					dd=null; 
				 }
				 
				 
				 
				 
			 } catch (ParseException e) {
			    
			     e.printStackTrace();
			 }
		  
			 
		
		  String status="C";
		  
		 
		  
		  
        	  ticket=ticketRepository.findOne(ticketId);
              ticket.setCloseRemark(closeRemark);
              ticket.setCompletedDateAndTime(new Date());
              ticket.setStatus(status);
              ticket.setDeploymentFlage(deployedFlge);
              ticket.setActualStartdate(asd);
              ticket.setActualEnddate(aed);
              ticket.setDeployedDate(dd);
              
        /*  saving developer Remarks into table */
              DeveloperRemarks devRemark=new DeveloperRemarks();
              devRemark.setDeveloperRemarks(closeRemark);
              devRemark.setDeveloperRemarksTimeAndDate(new Date());
              devRemark.setTicketId(ticketId);
              developerRepository.save(devRemark);
              
              ticketRepository.save(ticket);
               List<Ticket> tiketListByUserId=(List<Ticket>) ticketRepository.getByDeveloperUserName(userId);
		
              modelMap.addAttribute("tiketListByUserId", tiketListByUserId);
              
              List<SubTicket> subTicketListByUserId=subTicketRepository.findByAssineedFlagAndStatusAndDeveloperUserName("A", "O", userId);
              modelMap.addAttribute("subTicketListByUserId", subTicketListByUserId);
              modelMap.addAttribute("successMsg", "You have Successfully closed Ticket");
      		
        
		   return new ModelAndView("ticketListForDeveloperLoad");
		
	}
	
	
	
	
/*############# get developer list who already assigned some  ticket  ###########*/
	
	@RequestMapping(value="geAssinedDeveloper",method=RequestMethod.GET)
	public ModelAndView get(HttpServletRequest request,Model modelMap)
	{   ArrayList<Ticket> tlList=new ArrayList<>();
		
		 List<Ticket> assinedTicketList=(List<Ticket>) ticketRepository.findAllAssinedTicket();
		 for (Ticket ticket : assinedTicketList) 
		 {
			if(ticket.getAssineedFlag().equals("A"))
			{
				
				
				tlList.add(ticket);
				
			}
		}
		 
		 for (Ticket ticket : tlList)
		 {
			LOGGER.info("this ticket id:"+ticket.getTicketId()+"::is:Assined to:"+ticket.getDeveloperName());
		}
		   return new ModelAndView("closeTicketLoad");
		
	}
	
	
	
	
	
	@RequestMapping(value="reopenTicket",method=RequestMethod.GET)
	public ModelAndView reopenTicket(HttpServletRequest request,Model modelMap,Principal principal)
	{   
		  Ticket ticket=new Ticket();
		  int ticketId=Integer.parseInt(request.getParameter("ticketId"));
		  String reopenFlage=request.getParameter("reopenFlage");
		  String reopenRemark=request.getParameter("reopenRemark");
		  String status="RO";
		  
		  if(!reopenFlage.equals(""))
          {   
        	  
          
        	  ticket=ticketRepository.findOne(ticketId);
              ticket.setReopenTicket(reopenFlage);
              ticket.setReopenTicketText(reopenRemark);
              ticket.setReopenTicketDate(new Date());
              ticket.setReopenTicketDate(new Date());
              ticket.setStatus(status);
              ticket.setTicketText(reopenRemark);
              
             /* saving new remarks into remark table*/
              Remark remark=new Remark();
              
            remark.setUserRemarks(reopenRemark);
      		remark.setUserRemarksTimeAndDate(new Date());
      		remark.setTicketId(ticketId);
      		remarkRepository.save(remark);
      		
              ticketRepository.save(ticket);
          }
          else
          {
        	  LOGGER.info("cant assign because remarks is blank");
          }
		
     
		  String userId = principal.getName();
			
			UserMaster userMasterObject=new UserMaster();
			
			userMasterObject=userMasterRepository.findByUserName(userId);
			String senderName=userMasterObject.getFirstName();
			
	        List<Ticket> tiketListBySenderName=(List<Ticket>) ticketRepository.findBySenderName(senderName);
	        
	        LOGGER.info(tiketListBySenderName.size());
	        List<UserMaster> userList=(List<UserMaster>) userMasterRepository.findAll();
			
	       
			if(tiketListBySenderName!=null)
				{
				   
					modelMap.addAttribute("tiketListBySenderName", tiketListBySenderName);
				}
			
			 if(userList!=null){
				 modelMap.addAttribute("userList", userList);
			 }
		   return new ModelAndView("myTicketLoad");
		
	}

	
	/*###########method for reopen ticket###########*/
	
	@RequestMapping(value="replanDate",method=RequestMethod.GET)
	public ModelAndView replanDate(HttpServletRequest request,Model modelMap)
	{   
		 Ticket ticket=new Ticket();
		  int ticketId=Integer.parseInt(request.getParameter("ticketId"));
		  String tlRemark=request.getParameter("tlRemark");
		
		     /*getting date from page*/
		     String planStartDate=request.getParameter("planStartDate");
	         String planCompleteDate=request.getParameter("planCompleteDate");
	         
	         /* formating string to stander date */
	         
	         Date psd=null;
			 Date pcd=null;
			
			 try {
			     
				 psd =(Date) new SimpleDateFormat("dd-MM-yyyy").parse(planStartDate);
				 pcd=(Date)new SimpleDateFormat("dd-MM-yyyy").parse(planCompleteDate);
				 
			 } catch (ParseException e) {
			    
			     e.printStackTrace();
			 }
		  
			  ticket=ticketRepository.findOne(ticketId);
        	 
              ticket.setCloseRemark(tlRemark);
              ticket.setPlanStartDate(psd);
              ticket.setPlanCompleteDate(pcd);
            
              ticketRepository.save(ticket);
      
        List<Ticket> assinedTicketList=(List<Ticket>) ticketRepository.findAllAssinedTiketForClose();
		
      
        if(assinedTicketList!=null)
        {
        	  modelMap.addAttribute("assinedTicketList", assinedTicketList);
        }
             
        
		 return new ModelAndView("assinedTicketLoad");
		  
		
	}
	
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public ModelAndView searchByPririty(HttpServletRequest request,Model modelMap)
	{   ArrayList<Ticket> ticketList=new ArrayList<>();
		
	    String pririty=request.getParameter("pririty");
	    ticketList=(ArrayList<Ticket>) ticketRepository.findByPrirityAndStatus(pririty, "C");
	    LOGGER.info("critical ticket list:"+ticketList.size());
		
		 /* sending all user list to jsp*/
	    
	    List<UserRole> userRole = userRoleRepository.findByRole(roleRepo.findByRoleName("DEVELOPER"));
	    List<UserMaster> userList = new ArrayList<>();
	    for(UserRole u:userRole)
	    {
	    	UserMaster um = new UserMaster();
	    	um = u.getUserMaster();
	    	userList.add(um);
	    }
	    modelMap.addAttribute("userList",userList);
	     /*  ArrayList<Remark> remarkList=(ArrayList<Remark>) remarkRepository.findByTicketId(2401);
           ArrayList<DeveloperRemarks>devList=(ArrayList<DeveloperRemarks>) developerRepository.findByTicketId(2401);
	       
	       System.out.println("user Remarks"+remarkList);
	       System.out.println("devRemarks"+devList);*/
	    
	       List<Ticket>allTicketList=ticketRepository.findAllTicket();
	       modelMap.addAttribute("allTicketList", allTicketList);
	      
	   
	       
		   return new ModelAndView("reportLoad");
	}
	
	
	@RequestMapping(value="getReport",method=RequestMethod.GET)
	public ModelAndView getReport(HttpServletRequest request,Model modelMap)
	
	{   
	    String priority=request.getParameter("priority");
	    String developerUserId=request.getParameter("userName");
	 
	    String dateType=request.getParameter("dateType"); 
	    String fromDate=request.getParameter("fromDate");
	    String toDate=request.getParameter("toDate");
	   
	  
	    
	    List<UserRole> userRole = userRoleRepository.findByRole(roleRepo.findByRoleName("DEVELOPER"));
	    List<UserMaster> userList = new ArrayList<>();
	    for(UserRole u:userRole)
	    {
	    	UserMaster um = new UserMaster();
	    	um = u.getUserMaster();
	    	userList.add(um);
	    }
	    modelMap.addAttribute("userList",userList);
	   
	      
	      if(dateType.equals("0"))
	      {   
	    	  List<Ticket>allTicketList=ticketRepository.findByPrirityAndDeveloperUserNameAndAssineedFlag(priority,developerUserId,"A");
	    	  modelMap.addAttribute("allTicketList", allTicketList);  
	    	  System.out.println("date type equal to zero");
	      }
	      
	      if(!dateType.equals("0") && (!priority.equals("0")) && (!developerUserId.equals("0")))
	      {   
	    	/*  parsing jsp date to standard date*/
	    	  
	    	  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	    	    
	    	    Date d1=null;
	    		 
	    		 Date d2=null;
	    		 try {
	    		     
	    			 d1 = sdf1.parse(fromDate);
	    			 d2 = sdf1.parse(toDate);
	    			
	    			 
	    		 } catch (ParseException e) {
	    		    
	    		     e.printStackTrace();
	    		 }
	    	   LOGGER.info("here date type not equal to zero");
	    	   if(dateType.equals("tr"))
		    	  {   
	    		      System.out.println(""+dateType);
	    		      List<Ticket>allTicketList=ticketRepository.findByPrirityAndDeveloperUserNameAndAssineedFlagAndTicketRaisedDateBetween(priority,developerUserId,"A",d1,d2);
			    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
		    	  
		    	 if(dateType.equals("ta"))
		    	  {
		    		 List<Ticket>allTicketList=ticketRepository.findByPrirityAndDeveloperUserNameAndAssineedFlagAndAssinedDateBetween(priority,developerUserId,"A",d1,d2);
			    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
		    	  
		    	
		    	 if(dateType.equals("tc"))
		    	  { 
		    		 List<Ticket>allTicketList=ticketRepository.findByPrirityAndDeveloperUserNameAndAssineedFlagAndActualEnddateBetween(priority,developerUserId,"A",d1,d2);
		    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
	      }
	      
	      
	     if(!dateType.equals("0") && (priority.equals("0")) && (!developerUserId.equals("0")))
	      {
	    	   System.out.println("here date type not equal to zero and developer id not equal to zero but priority is zero");
	    	   
	    	   SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	    	    
	    	    Date d1=null;
	    		 
	    		 Date d2=null;
	    		 try {
	    		     
	    			 d1 = sdf1.parse(fromDate);
	    			 d2 = sdf1.parse(toDate);
	    			
	    			 
	    		 } catch (ParseException e) {
	    		    
	    		     e.printStackTrace();
	    		 }
	    	   
	    	   if(dateType.equals("tr"))
		    	  {   
	    		      System.out.println(""+dateType);
	    		      List<Ticket>allTicketList=ticketRepository.findByDeveloperUserNameAndAssineedFlagAndTicketRaisedDateBetween(developerUserId,"A",d1,d2);
			    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
		    	  
		    	 if(dateType.equals("ta"))
		    	  {
		    		 System.out.println(""+dateType);
	    		      List<Ticket>allTicketList=ticketRepository.findByDeveloperUserNameAndAssineedFlagAndAssinedDateBetween(developerUserId,"A",d1,d2);
			    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
		    	  
		    	 
		    	 
		    	 if(dateType.equals("tc"))
		    	  { 
		    		 System.out.println(""+dateType);
	    		      List<Ticket>allTicketList=ticketRepository.findByDeveloperUserNameAndAssineedFlagAndActualEnddateBetween(developerUserId,"A",d1,d2);
			    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
	      }
	      
	     /* combination of priority and date type*/
	     else if(!dateType.equals("0") && (!priority.equals("0")) &&(developerUserId.equals("0")))
	    	 
	     {
	    	
	    	 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	    	    
	    	    Date d1=null;
	    		 
	    		 Date d2=null;
	    		 try {
	    		     
	    			 d1 = sdf1.parse(fromDate);
	    			 d2 = sdf1.parse(toDate);
	    			
	    			 
	    		 } catch (ParseException e) {
	    		    
	    		     e.printStackTrace();
	    		 }
	    	   
	    	   if(dateType.equals("tr"))
		    	  {   
	    		      System.out.println(""+dateType);
	    		      List<Ticket>allTicketList=ticketRepository.findByPrirityAndTicketRaisedDateBetweenAndAssineedFlag(priority,d1,d2,"A");
			    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
		    	  
		    	 if(dateType.equals("ta"))
		    	  {
		    		 System.out.println(""+dateType);
	    		      List<Ticket>allTicketList=ticketRepository.findByPrirityAndAssinedDateBetweenAndAssineedFlag(priority,d1,d2,"A");
			    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
		    	  
		    	 
		    	 
		    	 if(dateType.equals("tc"))
		    	  { 
		    		 System.out.println(""+dateType);
	    		      List<Ticket>allTicketList=ticketRepository.findByPrirityAndActualEnddateBetweenAndAssineedFlag(priority,d1,d2,"A");
			    	  modelMap.addAttribute("allTicketList", allTicketList);  
		    	  }
	     }
	      
	      
	      if(developerUserId.equals("0") && (dateType.equals("0")))
	      {
	    	  List<Ticket>allTicketList=ticketRepository.findByPrirityAndAssineedFlag(priority,"A");
	    	  modelMap.addAttribute("allTicketList", allTicketList);
	      }  
	      
	      if(priority.equals("0") && (dateType.equals("0")))
	      {
	    	  List<Ticket>allTicketList=ticketRepository.findByDeveloperUserNameAndAssineedFlag(developerUserId,"A");
	    	  modelMap.addAttribute("allTicketList", allTicketList);  
	      }
	       
	      if(priority.equals("0") && (developerUserId.equals("0")) &&(!dateType.equals("0")))
	      {  
	    	  SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	    	    
	    	    Date d1=null;
	    		 
	    		 Date d2=null;
	    		 try {
	    		     
	    			 d1 = sdf1.parse(fromDate);
	    			 d2 = sdf1.parse(toDate);
	    			
	    			 
	    		 } catch (ParseException e) {
	    		    
	    		     e.printStackTrace();
	    		 }
	    	  
	    	  if(dateType.equals("tr"))
	    	  {
	    		  List<Ticket>allTicketList=ticketRepository.findByTicketRaisedDateBetween(d1,d2);
		    	  modelMap.addAttribute("allTicketList", allTicketList);  
	    	  }
	    	  
	    	 if(dateType.equals("ta"))
	    	  {
	    		  List<Ticket>allTicketList=ticketRepository.findByAssinedDateBetweenAndAssineedFlag(d1,d2,"A");
		    	  modelMap.addAttribute("allTicketList", allTicketList);  
	    	  }
	    	  
	    	 
	    	 if(dateType.equals("tc"))
	    	  {
	    		  List<Ticket>allTicketList=ticketRepository.findByActualEnddateBetweenAndAssineedFlag(d1,d2,"A");
		    	  modelMap.addAttribute("allTicketList", allTicketList);  
	    	  }
	    	
	      }
	      
	  	   return new ModelAndView("reportLoad");
		
	}
	

	@RequestMapping(value="getPrivousAssignment",method=RequestMethod.GET)
	public ModelAndView getPrivousAssignment(HttpServletRequest request,Model modelMap)
	{      String userId=request.getParameter("devloperUserId");
	
	       List<Ticket>assignTicketList=ticketRepository.findByDeveloperUserName(userId);
	       modelMap.addAttribute("assignTicketList", assignTicketList);
		   return new ModelAndView("prevoiusAssign");
		
	}
	
	/*Create sub ticket 
	 * on clicking this method one sub-ticket will generate automatically   */
	
	
	@RequestMapping(value="genrateSubTicket",method=RequestMethod.GET)
	public ModelAndView genrateSubTicket(HttpServletRequest request,Model modelMap)
	
	{    
		 
		String ticketId=request.getParameter("ticketId");
		Ticket ticket=ticketRepository.findOne(Integer.parseInt(ticketId.trim()));
		
		String ticketRaisedDate=request.getParameter("ticketRaisedDate");
		String senderName=request.getParameter("sName");
		String senderMobile=request.getParameter("mobile");
		String instance=request.getParameter("instance");
		String pririty=request.getParameter("pririty");
		String issues=request.getParameter("issues");
		String status="O";
	
		String tType=request.getParameter("tType");
		String sEmail=request.getParameter("sEmail");
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
 	    
 	   
 		 
 		 Date d1=null;
 		 try {
 		     
 			 d1 = sdf1.parse(ticketRaisedDate);
 		
 			
 			 
 		 } catch (ParseException e) {
 		    
 		     e.printStackTrace();
 		 }
 	  
		
 		 
 		 
        Ticket sb=new Ticket();
        
       
        sb.setSubticketId(ticket.getTicketId().toString());
       
        sb.setSenderName(senderName);
        sb.setSorce(instance);
        sb.setTicketText(issues);
        sb.setPririty(pririty.trim());
        sb.setMobileMobile(senderMobile);
        sb.setStatus(null);
        sb.setTicketRaisedDate(d1);
        /*sb.setStatus(status);*/
        sb.setSenderEmail(sEmail);
        sb.setTicketType(tType);
        ticketRepository.save(sb);
        
       /* updateSubTicket Flag*/
        
        Ticket ticketObj=ticketRepository.findOne(Integer.parseInt(ticketId.trim()));
        ticketObj.setSubTicketFlag("S");
        ticketRepository.save(ticketObj);
         
        modelMap.addAttribute("successMsgforSubTicket", "You have Successfully Created SubTicket");
		List<Ticket> tiketList=(List<Ticket>) ticketRepository.findAllTicketWithoutAssign();
       
        List<SubTicket>subTicketList=subTicketRepository.findByAssineedFlag(null);
        
	if(tiketList!=null)
	{
	   
		modelMap.addAttribute("tiketList", tiketList);
	}

	 modelMap.addAttribute("subTicketList", subTicketList);
   /* sending all Developer  list to jsp page */
    
    List<UserRole> userRole = userRoleRepository.findByRole(roleRepo.findByRoleName("DEVELOPER"));
    List<UserMaster> userList = new ArrayList<>();
    for(UserRole u:userRole){
    	UserMaster um = new UserMaster();
    	um = u.getUserMaster();
    	userList.add(um);
    }
    if(userList!=null)
	 {
		 modelMap.addAttribute("userList", userList);
	 }  
    	LOGGER.info("one ticket Sub ticket created");
		   return new ModelAndView("ticketListLoad");
		
	}
	
	@RequestMapping(value="deleteSubTicket",method=RequestMethod.GET)
	public ModelAndView deleteSubticket(HttpServletRequest request,Model modelMap)
	
	{   
		
		  ticketRepository.delete(Integer.parseInt(request.getParameter("ticketId").trim()));
		  String parentTicketIdId=request.getParameter("parentTicketId");
		  System.out.println("parent ticketId:"+parentTicketIdId);
	      List<Ticket>stl=ticketRepository.findBySubticketId(parentTicketIdId.trim());
	      System.out.println("subTicketList::::::::::::"+stl.size());
	      if(stl.size()==0){
	    	  Ticket ticketObj=ticketRepository.findOne(Integer.parseInt(parentTicketIdId.trim()));
	          ticketObj.setSubTicketFlag(null);
	          ticketRepository.save(ticketObj);
	      }
		  
		  modelMap.addAttribute("successMsgforSubTicket", "You have Successfully Deleted SubTicket");
    	
       
		List<Ticket> tiketList=(List<Ticket>) ticketRepository.findAllTicketWithoutAssign();
       // List<SubTicket> subTicketList=(List<SubTicket>) subTicketRepository.findAll();
        List<SubTicket>subTicketList=subTicketRepository.findByAssineedFlag(null);
       
	if(tiketList!=null)
	{
	   
		modelMap.addAttribute("tiketList", tiketList);
	}

	 modelMap.addAttribute("subTicketList", subTicketList);
   /* ###################################sending all Developer  list to jsp page ##################################*/
    
    List<UserRole> userRole = userRoleRepository.findByRole(roleRepo.findByRoleName("DEVELOPER"));
    List<UserMaster> userList = new ArrayList<>();
    for(UserRole u:userRole){
    	UserMaster um = new UserMaster();
    	um = u.getUserMaster();
    	userList.add(um);
    }
    if(userList!=null)
	 {
		 modelMap.addAttribute("userList", userList);
	 }  
		   return new ModelAndView("ticketListLoad");
		
	}
	
	@RequestMapping(value="getUserInstance",method=RequestMethod.GET)
	public ModelAndView getUserInstance(HttpServletRequest request,Model modelMap)
	{   
		   
		   List<InstanceType> userInstanceList = (List<InstanceType>) instanceTypeRepository.findAll();
		   modelMap.addAttribute("userInstanceList", userInstanceList);
		   return new ModelAndView("userInstanceLoad");
		   
		   
	}
	
	@RequestMapping(value="addInstance",method=RequestMethod.POST)
	public ModelAndView addInstance(HttpServletRequest request,Model modelMap,Principal principal)
	{
		InstanceType instance = new InstanceType();
		   
		   
		   String instanceName = request.getParameter("instance_text");
		   instance.setInstanceName(instanceName);
		   instanceTypeRepository.save(instance);
		   
		   List<InstanceType> userInstanceList = (List<InstanceType>) instanceTypeRepository.findAll();
			modelMap.addAttribute("userInstanceList", userInstanceList);
		   
		   modelMap.addAttribute("successMsg", "User instance created successfully");
		   return new ModelAndView("userInstanceLoad");
	}
	
	@RequestMapping(value="/getUpdateUserInstance")
	public ModelAndView getUpdateUserInstance(Principal principal,HttpServletRequest request,Model modelMap)
	{
		int insId = Integer.parseInt(request.getParameter("instance_id").trim());
		InstanceType instanceType=instanceTypeRepository.findOne(insId);
		modelMap.addAttribute("instanceType", instanceType);
		return new ModelAndView("updateInstanceLoad");
	}
	

	@RequestMapping(value="findAdmin",method=RequestMethod.GET)
	public void findAdmin(HttpServletRequest request,Model modelMap)
	
	{   
		
		
   /* ###################################sending all Developer  list to jsp page ##################################*/
    
    List<UserRole> userRole = userRoleRepository.findByRole(roleRepo.findByRoleName("ADMIN"));
    List<UserMaster> userList = new ArrayList<>();
    for(UserRole u:userRole){
    	UserMaster um = new UserMaster();
    	um = u.getUserMaster();
    	System.out.println(um.getEmail());
    
    }
    
		
	}
	
	

	@RequestMapping(value="/updateInstance")
	public ModelAndView updateInstance(Principal principal,HttpServletRequest request,Model modelMap)
	{
		List<InstanceType> userInstanceList = (List<InstanceType>) instanceTypeRepository.findAll();
		modelMap.addAttribute("userInstanceList", userInstanceList);
		int insId = Integer.parseInt(request.getParameter("instance_id"));
		String instanceName = request.getParameter("instance_text");
		InstanceType instanceObj = new InstanceType();
		instanceObj = instanceTypeRepository.findOne(insId);
		instanceObj.setInstanceName(instanceName);
		instanceTypeRepository.save(instanceObj);
		modelMap.addAttribute("successMsg", "You have Successfully Updated User Instance");
		return new ModelAndView("userInstanceLoad");
	}
	
	@RequestMapping(value="/deleteUserInstance")
	public ModelAndView deleteUserInstance(Principal principal,HttpServletRequest request,Model modelMap)
	{
		int insId = Integer.parseInt(request.getParameter("instance_id"));
		InstanceType instanceDel = instanceTypeRepository.findOne(insId);
		instanceTypeRepository.delete(instanceDel);
		List<InstanceType> userInstanceList = (List<InstanceType>) instanceTypeRepository.findAll();
		modelMap.addAttribute("userInstanceList", userInstanceList);
		modelMap.addAttribute("successMsg", "You have Successfully Deleted User Instance");
		return new ModelAndView("userInstanceLoad");
	}
	
	
	
	
	 @RequestMapping(value="/getCompletedList",method=RequestMethod.GET)
		public ModelAndView  getCompletedList(HttpServletRequest request,Model modelMap,Principal principal)
		{   
		 List<Ticket>completedTl=ticketRepository.findByStatus("C");
			    
			      
		 modelMap.addAttribute("completedTl", completedTl);
		 
		 List<Ticket>openTicketList=ticketRepository.findByStatus(null);
	       List<Ticket>assinedTicketList=ticketRepository.findByStatus("O");
	       List<Ticket>closedTicketList=ticketRepository.findByStatus("C");
	       
	       System.out.println("open Ticket:::"+ticketRepository.findByStatus(null).size());
	       System.out.println("assined Ticket:::"+ticketRepository.findByStatus("O").size());
	       System.out.println("closed Ticket:::"+ticketRepository.findByStatus("C").size());
	       
	       modelMap.addAttribute("openTicketList", openTicketList);
	       modelMap.addAttribute("assinedTicketList", assinedTicketList);
	       modelMap.addAttribute("closedTicketList", closedTicketList);
			   return new ModelAndView("homeload");
			
		}
	 
	 @RequestMapping(value="/getNewList",method=RequestMethod.GET)
		public ModelAndView  getNewList(HttpServletRequest request,Model modelMap,Principal principal)
		{   
		 List<Ticket>completedTl=ticketRepository.findByStatus(null);
			    
			      
		 modelMap.addAttribute("completedTl", completedTl);
		 
		 List<Ticket>openTicketList=ticketRepository.findByStatus(null);
	       List<Ticket>assinedTicketList=ticketRepository.findByStatus("O");
	       List<Ticket>closedTicketList=ticketRepository.findByStatus("C");
	       
	       System.out.println("open Ticket:::"+ticketRepository.findByStatus(null).size());
	       System.out.println("assined Ticket:::"+ticketRepository.findByStatus("O").size());
	       System.out.println("closed Ticket:::"+ticketRepository.findByStatus("C").size());
	       
	       modelMap.addAttribute("openTicketList", openTicketList);
	       modelMap.addAttribute("assinedTicketList", assinedTicketList);
	       modelMap.addAttribute("closedTicketList", closedTicketList);
			   return new ModelAndView("homeload");
			
		}
	 
	 

	 @RequestMapping(value="/getAssined",method=RequestMethod.GET)
		public ModelAndView  getAssined(HttpServletRequest request,Model modelMap,Principal principal)
		{   
		 List<Ticket>completedTl=ticketRepository.findByStatus("O");
			    
			      
		 modelMap.addAttribute("completedTl", completedTl);
		 
		 List<Ticket>openTicketList=ticketRepository.findByStatus(null);
	       List<Ticket>assinedTicketList=ticketRepository.findByStatus("O");
	       List<Ticket>closedTicketList=ticketRepository.findByStatus("C");
	       
	       System.out.println("open Ticket:::"+ticketRepository.findByStatus(null).size());
	       System.out.println("assined Ticket:::"+ticketRepository.findByStatus("O").size());
	       System.out.println("closed Ticket:::"+ticketRepository.findByStatus("C").size());
	       
	       modelMap.addAttribute("openTicketList", openTicketList);
	       modelMap.addAttribute("assinedTicketList", assinedTicketList);
	       modelMap.addAttribute("closedTicketList", closedTicketList);
			   return new ModelAndView("homeload");
			
		}

	 
	 @RequestMapping(value="/getDelete",method=RequestMethod.GET)
		public ModelAndView  getforDelete(HttpServletRequest request,Model modelMap,Principal principal)
		{   
		 List<Ticket>tiketList=(List<Ticket>) ticketRepository.findAll();
			    
			      
		 modelMap.addAttribute("tiketList", tiketList);
		 
		
			   return new ModelAndView("deleteTicketLoad");
			
		}
	 
	 
	 @RequestMapping(value="/dt",method=RequestMethod.GET)
		public ModelAndView  deleteTicket(HttpServletRequest request,Model modelMap,Principal principal)
		{   
		 
		 ticketRepository.delete(Integer.parseInt(request.getParameter("ticketId").trim()));
		 List<Ticket>tiketList=(List<Ticket>) ticketRepository.findAll();
			    
			      
		 modelMap.addAttribute("tiketList", tiketList);
		 modelMap.addAttribute("successMsg", " Ticket Deleted Successfully");
		
			   return new ModelAndView("deleteTicketLoad");
			
		}

	
}
	
	
	
	


	

