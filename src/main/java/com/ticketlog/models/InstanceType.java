package com.ticketlog.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name="instance")
public class InstanceType {
	
    
	@Id
	@Column(name="id", unique=true, nullable=false)
	@SequenceGenerator(name="generator_instanceId", sequenceName="ticket.generator_instanceId")
	@GeneratedValue(strategy=SEQUENCE, generator="generator_instanceId")
	
	private Integer instanceId;
	
	@Column(name="instanceName")
	private String instanceName;

	public Integer getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	
	
	
	
	
}
