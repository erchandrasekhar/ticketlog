package com.ticketlog.models;

import static javax.persistence.GenerationType.SEQUENCE;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {
	private Long id;
	private UserMaster userMaster;
	private Role role;
	
	@Id
	@Column(name="id", unique=true, nullable=false)
	@SequenceGenerator(name="generator_user_roleid", sequenceName="ticket.generator_user_role_id")
	@GeneratedValue(strategy=SEQUENCE, generator="generator_user_roleid")
/*	@GeneratedValue(strategy=GenerationType.AUTO)*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	@ManyToOne
	 @JoinColumn(name="user_id", nullable=false)
	public UserMaster getUserMaster() {
		return userMaster;
	}
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}
	
	
	 @ManyToOne
	 @JoinColumn(name="role_id", nullable=false)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}

}
