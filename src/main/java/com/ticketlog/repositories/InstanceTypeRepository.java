package com.ticketlog.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ticketlog.models.InstanceType;
import com.ticketlog.models.Ticket;

public interface InstanceTypeRepository  extends CrudRepository<InstanceType , Integer>{

}
