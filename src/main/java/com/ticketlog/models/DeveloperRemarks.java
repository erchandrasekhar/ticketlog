package com.ticketlog.models;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="developerRemark")
public class DeveloperRemarks {
	

	@Id
	@Column(name="id", unique=true, nullable=false)
	@SequenceGenerator(name="generator_devRemarkId", sequenceName="ticket.generator_devRemarkId")
	@GeneratedValue(strategy=SEQUENCE, generator="generator_devRemarkId")
	
	private Integer devreRmarkId;
	
	@Column(name="ticketId")
	private Integer ticketId;
	
	@Column(name="developerRemarks")
	private String developerRemarks;
	
	
	@Column(name="developerRemarksTimeAndDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date developerRemarksTimeAndDate;


	public Integer getDevreRmarkId() {
		return devreRmarkId;
	}


	public void setDevreRmarkId(Integer devreRmarkId) {
		this.devreRmarkId = devreRmarkId;
	}


	public Integer getTicketId() {
		return ticketId;
	}


	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}


	public String getDeveloperRemarks() {
		return developerRemarks;
	}


	public void setDeveloperRemarks(String developerRemarks) {
		this.developerRemarks = developerRemarks;
	}


	public Date getDeveloperRemarksTimeAndDate() {
		return developerRemarksTimeAndDate;
	}


	public void setDeveloperRemarksTimeAndDate(Date developerRemarksTimeAndDate) {
		this.developerRemarksTimeAndDate = developerRemarksTimeAndDate;
	}


	
	
	
}
