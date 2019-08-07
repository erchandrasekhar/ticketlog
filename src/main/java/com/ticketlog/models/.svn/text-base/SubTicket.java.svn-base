package com.ticketlog.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="sub_ticket")
public class SubTicket {
	
	@Id
	@Column(name="subTicketId", unique=true, nullable=false)
	@SequenceGenerator(name="generator_subTicketId", sequenceName="ticket.generator_subTicketId")
	@GeneratedValue(strategy=SEQUENCE, generator="generator_subTicketId")
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	private Integer subTicketId;
	
	

	@Column(name="description")
	private String description;
	
	@Column(name="ticketId")
	private String ticketId;
	
	@Column(name="ticketText")
	private String ticketText;
	
	@Column(name="ticketRiseDateAndTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ticketRiseDateAndTime;
	
	@Column(name="ticketRaisedDate")
	@Temporal(TemporalType.DATE)
	private Date ticketRaisedDate;
	
	@Column(name="assinedDateAndTimeByTl")
	@Temporal(TemporalType.TIMESTAMP)
	private Date assinedDateAndTimeByTl;
	
	@Column(name="assinedDate")
	@Temporal(TemporalType.DATE)
	private Date assinedDate;
	
	@Column(name="completedDateAndTime")
	@Temporal(TemporalType.DATE)
	private Date completedDateAndTime;
	
	@Column(name="sorce")
	private String sorce;
	
	@Column(name="senderName")
	private String senderName;
	
	@Column(name="senderMobile")
	private String mobileMobile;
	
	@Column(name="senderEmail")
	private String senderEmail;
	
	/*status o for open and c for close*/
	@Column(name="status")
	private String status;
	
	@Column(name="closeRemark")
	private String closeRemark;
	
	@Column(name="ticketType")
	private String ticketType;
	
	@Column(name="pririty")
	private String pririty;
	
	/*if assigned to developer than assinedFlage=A and after fixed problem assineedFlag=AC */
	@Column(name="assineedFlag")
	private String assineedFlag;
	
	@Column(name="tlRemark")
	private String tlRemark;
	
	@Column(name="developerUserName")
	private String developerUserName;
	
	@Column(name="developerName")
	private String developerName;
	
	@Column(name="reopenTicketFlage")
	private String reopenTicket;
	
	@Column(name="reopenTicketText")
	private String reopenTicketText;
	
	@Column(name="reopenTicketDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reopenTicketDate;
	
	/*if deploymentFlage is Y for deployed on server else deploymentFlage is N for not deployed yet  */
	@Column(name="deploymentFlage")
	private String deploymentFlage;
	
	@Column(name="deployedDate")
	@Temporal(TemporalType.DATE)
	private Date deployedDate;
	
	
	@Column(name="planStartDate")
	@Temporal(TemporalType.DATE)
	private Date planStartDate;
	
	@Column(name="planCompleteDate")
	@Temporal(TemporalType.DATE)
	private Date planCompleteDate;
	
	
	@Column(name="actualStartdate")
	@Temporal(TemporalType.DATE)
	private Date actualStartdate;
	
	@Column(name="actualEnddate")
	@Temporal(TemporalType.DATE)
	private Date actualEnddate;
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSubTicketId() {
		return subTicketId;
	}

	public void setSubTicketId(Integer subTicketId) {
		this.subTicketId = subTicketId;
	}

	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getTicketText() {
		return ticketText;
	}

	public void setTicketText(String ticketText) {
		this.ticketText = ticketText;
	}

	public Date getTicketRiseDateAndTime() {
		return ticketRiseDateAndTime;
	}

	public void setTicketRiseDateAndTime(Date ticketRiseDateAndTime) {
		this.ticketRiseDateAndTime = ticketRiseDateAndTime;
	}

	public Date getTicketRaisedDate() {
		return ticketRaisedDate;
	}

	public void setTicketRaisedDate(Date ticketRaisedDate) {
		this.ticketRaisedDate = ticketRaisedDate;
	}

	public Date getAssinedDateAndTimeByTl() {
		return assinedDateAndTimeByTl;
	}

	public void setAssinedDateAndTimeByTl(Date assinedDateAndTimeByTl) {
		this.assinedDateAndTimeByTl = assinedDateAndTimeByTl;
	}

	public Date getAssinedDate() {
		return assinedDate;
	}

	public void setAssinedDate(Date assinedDate) {
		this.assinedDate = assinedDate;
	}

	public Date getCompletedDateAndTime() {
		return completedDateAndTime;
	}

	public void setCompletedDateAndTime(Date completedDateAndTime) {
		this.completedDateAndTime = completedDateAndTime;
	}

	public String getSorce() {
		return sorce;
	}

	public void setSorce(String sorce) {
		this.sorce = sorce;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getMobileMobile() {
		return mobileMobile;
	}

	public void setMobileMobile(String mobileMobile) {
		this.mobileMobile = mobileMobile;
	}

	public String getSenderEmail() {
		return senderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCloseRemark() {
		return closeRemark;
	}

	public void setCloseRemark(String closeRemark) {
		this.closeRemark = closeRemark;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public String getPririty() {
		return pririty;
	}

	public void setPririty(String pririty) {
		this.pririty = pririty;
	}

	public String getAssineedFlag() {
		return assineedFlag;
	}

	public void setAssineedFlag(String assineedFlag) {
		this.assineedFlag = assineedFlag;
	}

	public String getTlRemark() {
		return tlRemark;
	}

	public void setTlRemark(String tlRemark) {
		this.tlRemark = tlRemark;
	}

	public String getDeveloperUserName() {
		return developerUserName;
	}

	public void setDeveloperUserName(String developerUserName) {
		this.developerUserName = developerUserName;
	}

	public String getDeveloperName() {
		return developerName;
	}

	public void setDeveloperName(String developerName) {
		this.developerName = developerName;
	}

	public String getReopenTicket() {
		return reopenTicket;
	}

	public void setReopenTicket(String reopenTicket) {
		this.reopenTicket = reopenTicket;
	}

	public String getReopenTicketText() {
		return reopenTicketText;
	}

	public void setReopenTicketText(String reopenTicketText) {
		this.reopenTicketText = reopenTicketText;
	}

	public Date getReopenTicketDate() {
		return reopenTicketDate;
	}

	public void setReopenTicketDate(Date reopenTicketDate) {
		this.reopenTicketDate = reopenTicketDate;
	}

	public String getDeploymentFlage() {
		return deploymentFlage;
	}

	public void setDeploymentFlage(String deploymentFlage) {
		this.deploymentFlage = deploymentFlage;
	}

	public Date getDeployedDate() {
		return deployedDate;
	}

	public void setDeployedDate(Date deployedDate) {
		this.deployedDate = deployedDate;
	}

	public Date getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(Date planStartDate) {
		this.planStartDate = planStartDate;
	}

	public Date getPlanCompleteDate() {
		return planCompleteDate;
	}

	public void setPlanCompleteDate(Date planCompleteDate) {
		this.planCompleteDate = planCompleteDate;
	}

	public Date getActualStartdate() {
		return actualStartdate;
	}

	public void setActualStartdate(Date actualStartdate) {
		this.actualStartdate = actualStartdate;
	}

	public Date getActualEnddate() {
		return actualEnddate;
	}

	public void setActualEnddate(Date actualEnddate) {
		this.actualEnddate = actualEnddate;
	}
	
	
	
	
	
	

}
