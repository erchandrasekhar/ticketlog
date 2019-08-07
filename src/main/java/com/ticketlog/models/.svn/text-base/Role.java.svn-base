package com.ticketlog.models;

import static javax.persistence.GenerationType.SEQUENCE;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	private Long id;
	private String roleName;
	private String roleDesc;
	private Set<UserRole> userRole = new HashSet<UserRole>(0);
	
	@Id
	@Column(name="id", unique=true, nullable=false)
	@SequenceGenerator(name="generator_roleid", sequenceName="ticket.generator_role_id")
	@GeneratedValue(strategy=SEQUENCE, generator="generator_roleid")
	/*@GeneratedValue(strategy=GenerationType.AUTO)*/
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	@Column(name="role_name", unique=true, nullable=false,length=255)
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	@Column(name="role_desc", unique=false, nullable=true,length=255)
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="role")
	public Set<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}
	

}
