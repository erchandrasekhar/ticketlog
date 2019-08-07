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
@Table(name="allremark")
public class Remark {
	

	@Id
	@Column(name="id", unique=true, nullable=false)
	@SequenceGenerator(name="generator_remarkId", sequenceName="ticket.generator_remarkId")
	@GeneratedValue(strategy=SEQUENCE, generator="generator_remarkId")
	
	private Integer remarkId;
	
	@Column(name="userRemarks")
	private String userRemarks;
	
	@Column(name="ticketId")
	private Integer ticketId;
	
	@Column(name="userRemarksTimeAndDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date userRemarksTimeAndDate;

	public Integer getRemarkId() {
		return remarkId;
	}

	public void setRemarkId(Integer remarkId) {
		this.remarkId = remarkId;
	}

	public String getUserRemarks() {
		return userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		this.userRemarks = userRemarks;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Date getUserRemarksTimeAndDate() {
		return userRemarksTimeAndDate;
	}

	public void setUserRemarksTimeAndDate(Date userRemarksTimeAndDate) {
		this.userRemarksTimeAndDate = userRemarksTimeAndDate;
	}

	@Override
	public String toString() {
		return "Remark [remarkId=" + remarkId + ", userRemarks=" + userRemarks + ", ticketId=" + ticketId
				+ ", userRemarksTimeAndDate=" + userRemarksTimeAndDate + "]";
	}
	
	
	/*@Column(name="developerRemarks")
	private String developerRemarks;
	
	
	@Column(name="developerRemarksTimeAndDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date developerRemarksTimeAndDate;
*/

	
	
	
}
