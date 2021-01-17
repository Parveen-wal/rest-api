package com.javatechnie.spring.mysql.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatechnie.spring.mysql.api.model.Ticket;

@Repository
public interface TicketDao extends JpaRepository<Ticket, Integer>{

}
