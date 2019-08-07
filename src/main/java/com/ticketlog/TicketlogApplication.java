package com.ticketlog;

import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;



@SpringBootApplication
public class TicketlogApplication  extends SpringBootServletInitializer{

	 private static final Logger LOGGER = LogManager.getLogger(TicketlogApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(TicketlogApplication.class, args);
		
		
		LOGGER.info("Welcome to TicketLog: : current Time::"+new Date());
	}
}
