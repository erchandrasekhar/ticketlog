package com.ticketlog.controller;

import java.security.Principal;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;


import com.ticketlog.models.InstanceType;
import com.ticketlog.models.Role;
import com.ticketlog.models.Ticket;
import com.ticketlog.models.UserMaster;
import com.ticketlog.models.UserRole;
import com.ticketlog.repositories.InstanceTypeRepository;
import com.ticketlog.repositories.RoleRepository;
import com.ticketlog.repositories.TicketRepository;
import com.ticketlog.repositories.UserMasterRepository;



@Controller
public class LoginController {
	
	@Autowired
	UserMasterRepository userRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	InstanceTypeRepository instanceTypeRepository;
	
	@Autowired
	TicketRepository ticketRepository;
	
	 private static final Logger LOGGER = LogManager.getLogger(LoginController.class);
	
         @RequestMapping(value={"/login","/"})
	     public ModelAndView login() 
         {
        	 
           ArrayList<Role>roleList=new ArrayList<>();
        	 
           roleList=(ArrayList<Role>) roleRepo.findAll();
           
           if(roleList.isEmpty())
           {
        	   Role role1 = new Role();
  			   
 			    role1.setRoleDesc("ADMIN");
 		        role1.setRoleName("ADMIN");
 		        
 		        roleRepo.save(role1);
 		   
        	  
        	   LOGGER.info("admin role created");
           }
           
        	   
		        
        ArrayList<UserMaster>userList= (ArrayList<UserMaster>) userRepo.findAll();
      
        
        	if(userList.isEmpty())
        	{
        		
        		UserMaster user = new UserMaster();
 		        user.setUserName("admin");
 		        user.setFirstName("Mrinmoy Das");
 		        user.setActive(true);
 		        user.setEmail("mrinmoy@gmail.com");
 		        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
 		        user.setPassword(encoder.encode("password"));
 		        user.setMobile("7891331023");
 		        
 		        UserRole userRole = new UserRole();
 		        Role role = roleRepo.findByRoleName("ADMIN");
 		        userRole.setRole(role);
 		        
 		        
 		        userRole.setUserMaster(user);
 		        Set<UserRole> roles = new HashSet<>();
 		        roles.add(userRole);
 		        user.setUserRole(roles);
 		        userRepo.save(user);
 		   
 		       LOGGER.info("ADMIN Created");
 		   	
        	}
				
		        
			
        	 
		/*	UserMaster user = new UserMaster();
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
	        roleRepo.save(role);
	        
	        userRole.setRole(role);
	        userRole.setUserMaster(user);
	        Set<UserRole> roles = new HashSet<>();
	        roles.add(userRole);
	        user.setUserRole(roles);
	        userRepo.save(user);
			
			System.out.println("Inside login...");*/
	        return new ModelAndView("login");
	    }
	
		@RequestMapping(value={"/index/","/home"})
	    public ModelAndView home(Principal principal,HttpServletRequest request,Model modelMap) {
			
			if(principal != null)
			{
				String name = principal.getName(); //get logged in username, so now we can add user details to session
			
				LOGGER.info("Current user name : "+name);
				UserMaster user=userRepo.findByUserName(name);
				String currentUserName=user.getFirstName();
				String currentUserInstance=user.getUserInstance();
				request.getSession().setAttribute("currentUserName", currentUserName);
				Set<UserRole> role = user.getUserRole();
				for(UserRole ur: role)
				{
					String currentUserRole=ur.getRole().getRoleName();
					
					request.getSession().setAttribute("currentUserRole", currentUserRole);
					request.getSession().setAttribute("currentUserInstance", currentUserInstance);
					
					
					
				
					 LOGGER.info("Current User Role : "+currentUserRole);
					
					
				}
				
				
				 /*   logic for counting ticket details*/
			       
			     
			       List<Ticket>openTicketList=ticketRepository.findByStatus(null);
			       List<Ticket>assinedTicketList=ticketRepository.findByStatus("O");
			       List<Ticket>closedTicketList=ticketRepository.findByStatus("C");
			       
			       System.out.println("open Ticket:::"+ticketRepository.findByStatus(null).size());
			       System.out.println("assined Ticket:::"+ticketRepository.findByStatus("O").size());
			       System.out.println("closed Ticket:::"+ticketRepository.findByStatus("C").size());
			       
			       modelMap.addAttribute("openTicketList", openTicketList);
			       modelMap.addAttribute("assinedTicketList", assinedTicketList);
			       modelMap.addAttribute("closedTicketList", closedTicketList);
			       /*String tckt = request.getParameter("cid");
			       System.out.println(tckt);
			       if(tckt == null) {
			    	   modelMap.addAttribute("tt", null);
			       }
			       else if (tckt == "A") {
			    	   modelMap.addAttribute("tt", closedTicketList);
			       }
			       else if (tckt == "B") {
			    	   modelMap.addAttribute("tt", openTicketList);
			       }
			       else if (tckt == "C") {
			    	   modelMap.addAttribute("tt", assinedTicketList);
			       }
			       else {
			    	   return new ModelAndView("homeload");
			       }*/
			     /*  modelMap.addAttribute("tt", openTicketList);
			       modelMap.addAttribute("tt", assinedTicketList);
			       modelMap.addAttribute("tt", closedTicketList);*/
			       
			       /*   End logic for counting ticket details*/   
				
			}
			
			
			
	        return new ModelAndView("homeload");
	    }
		
	
		
		@RequestMapping(value="addRoleD")
	    public ModelAndView addRole(Principal principal,HttpServletRequest request) {
			
			   Role role = new Role();
			   
			   role.setRoleDesc("DEVELOPER");
		        role.setRoleName("DEVELOPER");
			
		        roleRepo.save(role);
		        
		    
		        LOGGER.info("role added ");

	        return new ModelAndView("homeload");
	    }
		
		@RequestMapping(value="addRoleU")
	    public ModelAndView addRoleU(Principal principal,HttpServletRequest request) {
			
			   Role role = new Role();
			   
			   role.setRoleDesc("USER");
		        role.setRoleName("USER");
		
		        
		        roleRepo.save(role);
		        
		        System.out.println("");
		        LOGGER.info(" User role added  ");
		        

	        return new ModelAndView("homeload");
	    }
		
		
		
		@RequestMapping(value="addDev")
	    public ModelAndView addUser(Principal principal,HttpServletRequest request) {
			
				UserMaster user = new UserMaster();
		        user.setUserName("parag");
		        user.setFirstName("parag");
		        user.setActive(true);
		        user.setEmail("parag@gmail.com");
		        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		        user.setPassword(encoder.encode("password"));
		        user.setMobile("789133177");
		        
		   
		        
		        UserRole userRole = new UserRole();
		        Role role = roleRepo.findByRoleName("DEVELOPER");
		        userRole.setRole(role);
		        userRole.setUserMaster(user);
		        Set<UserRole> roles = new HashSet<>();
		        roles.add(userRole);
		        user.setUserRole(roles);
		        userRepo.save(user);
				
		        
			
				  LOGGER.info(" one user Created... ");
				  return new ModelAndView("homeload");
}
		
		
		
		/*Adding new User*/
		@RequestMapping(value="addUser")
	    public ModelAndView addUserU(Principal principal,HttpServletRequest request,Model modelMap) {
			
			    String userName=request.getParameter("userId");
			    String firstName=request.getParameter("firstName");
			    String lastName=request.getParameter("lastName");
			    String email=request.getParameter("email");
			    Long roleId=Long.parseLong(request.getParameter("roleId"));
			    String  mobileNo=request.getParameter("mobile");
			    String  userInstanceName=request.getParameter("instanceName");
			     
			  
			    LOGGER.info(userName+"::"+firstName+"::"+email+"::"+mobileNo+"::"+lastName+"::"+roleId);
				UserMaster user = new UserMaster();
		        user.setUserName(userName);
		        user.setFirstName(firstName);
		        user.setLastName(lastName);
		        user.setActive(true);
		        user.setEmail(email);
		        user.setUserInstance(userInstanceName);
		        
		        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		        user.setPassword(encoder.encode("password"));
		        user.setMobile(mobileNo);
		        
		        String rolName="";
		        if(roleId==1)
		        {
		        	 rolName="DEVELOPER";
		        }
		        if(roleId==2)
		        {
		        	 rolName="USER";
		        }
		      
		        
		        UserRole userRole = new UserRole();
		        Role role = roleRepo.findByRoleName(rolName);
		        userRole.setRole(role);
		        userRole.setUserMaster(user);
		        Set<UserRole> roles = new HashSet<>();
		        roles.add(userRole);
		        user.setUserRole(roles);
		        userRepo.save(user);
		        modelMap.addAttribute("successMsg", "You have Successfully Created User");
		        
			
				  LOGGER.info(" One User Created...");
				  return new ModelAndView("registrationLoad");
}
		
		
		/*Update User*/
		@RequestMapping(value="updateaddUser")
	    public ModelAndView updateaddUser(Principal principal,HttpServletRequest request,Model modelMap) {
			    
		
		       
			
			   long IdPk=Long.parseLong(request.getParameter("id"));
			    String userName=request.getParameter("userId");
			    String firstName=request.getParameter("firstName");
			    String lastName=request.getParameter("lastName");
			    String email=request.getParameter("email");
			  //  Long roleId=Long.parseLong(request.getParameter("roleId"));
			    String  mobileNo=request.getParameter("mobile");
			    System.out.println(userName+"::"+firstName+"::"+email+"::"+mobileNo+"::"+lastName);
			    
				UserMaster user = new UserMaster();
				user=userRepo.findOne(IdPk);
				
				/*user.setId(IdPk);*/
		        user.setUserName(userName);
		        user.setFirstName(firstName);
		        user.setLastName(lastName);
		       
		        user.setEmail(email);
		       
		        user.setMobile(mobileNo);
		        
		       /* String rolName="";
		        if(roleId==1)
		        {
		        	 rolName="DEVELOPER";
		        }
		        if(roleId==2)
		        {
		        	 rolName="USER";
		        }
		        
		        if(roleId==3)
		        {
		        	 rolName="ADMIN";
		        }
		       UserRole userRole = new UserRole();
		        Role role = roleRepo.findByRoleName(rolName);
		        userRole.setRole(role);
		        userRole.setUserMaster(user);
		        Set<UserRole> roles = new HashSet<>();
		        roles.add(userRole);
		        user.setUserRole(roles);*/
		        userRepo.save(user);
		        modelMap.addAttribute("successMsg", "You have Successfully Updated User");
		        
				
				  LOGGER.info(" one user Created...");
				  return new ModelAndView("updateUserload");
}
		
		
		
	@RequestMapping(value="/help")
		public ModelAndView home()
		{
			return new ModelAndView("helpLoad");
			
			
			
	       
		}
	
	@RequestMapping(value="/gerReg")
	public ModelAndView gerRagistration(Principal principal,HttpServletRequest request,Model modelMap)
	{
		List<InstanceType> instanceList=(List<InstanceType>) instanceTypeRepository.findAll();
		
		modelMap.addAttribute("instanceList", instanceList);
		return new ModelAndView("registrationLoad");
		
       
	}



	@RequestMapping(value="/allUser")
	public ModelAndView getAllUser(Principal principal,HttpServletRequest request,Model modelMap)
	{
		List<UserMaster>userList=(List<UserMaster>) userRepo.findAll();
		modelMap.addAttribute("userList", userList);
		
		return new ModelAndView("userListLoad");
		
       
	}
	
	
	@RequestMapping(value="/getUpdateUser")
	public ModelAndView updateUser(Principal principal,HttpServletRequest request,Model modelMap)
	{
		List<UserMaster>userList=(List<UserMaster>) userRepo.findAll();
		modelMap.addAttribute("userList", userList);
		 long IdPk=Long.parseLong(request.getParameter("id"));
	
		UserMaster userMaster=userRepo.findOne(IdPk);
		
		modelMap.addAttribute("userMaster", userMaster);
		
		return new ModelAndView("updateUserload");
		
       
	}
	
	@RequestMapping(value="/changePwd")
	public ModelAndView getPassword(Principal principal,HttpServletRequest request,Model modelMap)
	{
		String name = principal.getName(); //get logged in username, so now we can add user details to session
		UserMaster user=userRepo.findByUserName(name);
		System.out.println("first Name:"+user.getFirstName());
		System.out.println("userPwd::::::::"+user.getPassword());
		modelMap.addAttribute("user", user);
		
			  return new ModelAndView("changePasswordLoad");
	
		
       
	}
	
	@RequestMapping(value="/changePassword")
	public ModelAndView changePassword(Principal principal,HttpServletRequest request,Model modelMap)
	{
		
		   long IdPk=Long.parseLong(request.getParameter("idPk"));
		   String newPwd=request.getParameter("newPwd");
		   System.out.println(IdPk+"::::"+newPwd);
		   
		   UserMaster user = new UserMaster();
		   user=userRepo.findOne(IdPk);
		   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		   user.setPassword(encoder.encode(newPwd));
		  userRepo.save(user);
	       modelMap.addAttribute("successMsg", "You have Successfully Change Password");
	        		
			  return new ModelAndView("changePasswordLoad");
	
		
       
	}
	
	
	@RequestMapping(value="/resetPwd")
	public ModelAndView resetPwd(Principal principal,HttpServletRequest request,Model modelMap)
	{
		
		     List<UserMaster>userMasterList=(List<UserMaster>) userRepo.findAll();
		     System.out.println("userSize:"+userMasterList.size());
		     modelMap.addAttribute("userMasterList", userMasterList);
			 return new ModelAndView("resetPasswordLoad");
	
		
       
	}
	@RequestMapping(value="/resetPassword")
	public ModelAndView resetPassword(Principal principal,HttpServletRequest request,Model modelMap)
	{
		 long IdPk=Long.parseLong(request.getParameter("userIdPk"));
		   UserMaster user = new UserMaster();
		   user=userRepo.findOne(IdPk);
		   BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		   user.setPassword(encoder.encode("password"));
		   userRepo.save(user);
	       modelMap.addAttribute("successMsg", "password Reset Successfully");
	

		     List<UserMaster>userMasterList=(List<UserMaster>) userRepo.findAll();
		     System.out.println("userSize:"+userMasterList.size());
		     modelMap.addAttribute("userMasterList", userMasterList);
			
		
	       return new ModelAndView("resetPasswordLoad");
	}
	
	
}