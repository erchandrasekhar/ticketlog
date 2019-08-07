package com.ticketlog.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="user_master")
public class UserMaster {

	private Long id;
	private String userName;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String mobile;
	private String email;
	
	private String password;
	
	@Column(name="userInstance")
	private String userInstance;

	private boolean active;

	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
   

	public UserMaster(UserMaster user) {
		this.active = user.getActive();
        this.userName = user.getUserName();
        this.firstName =user.getFirstName();
        this.lastName =user.getLastName();
        this.id = user.getId();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.address = user.getAddress();
     
        this.userRole = user.getUserRole();
      
	}

	public UserMaster() {
	}

	@Id
	@Column(name="id", unique=true, nullable=false)
	@SequenceGenerator(name="generator_userid", sequenceName="ticket.generator_user_id")
	@GeneratedValue(strategy=SEQUENCE, generator="generator_userid")
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	@Column(name="username",nullable=false,length=255,unique=true)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Column(name="firstName",nullable=false,length=255)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	@Column(name="lastName",nullable=true,length=255)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	@Column(name="address",nullable=true,length=255)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	@Column(name="phone",nullable=true,length=255,unique=true)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	@Column(name="mobile",nullable=false,length=255,unique=true)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
	@Column(name="email",nullable=false,length=255,unique=true)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="password",nullable=false,length=255)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
    
	public String getUserInstance() {
		return userInstance;
	}

	public void setUserInstance(String userInstance) {
		this.userInstance = userInstance;
	}

	public boolean getActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER, mappedBy="userMaster")
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	
	
	
	
	

	
}
