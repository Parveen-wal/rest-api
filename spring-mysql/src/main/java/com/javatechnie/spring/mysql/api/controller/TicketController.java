package com.javatechnie.spring.mysql.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechnie.spring.mysql.api.dao.TicketDao;
import com.javatechnie.spring.mysql.api.model.Ticket;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;

	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets)
	{
		dao.saveAll(tickets);
		return "ticket booked : "+ tickets.size();
	}

	@GetMapping("/getTickets")
	public List<Ticket> getTickets()
	{
		return (List<Ticket>)dao.findAll();
	}

	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public Optional<Ticket> getTicketsBasedOnId(@PathVariable(value = "id") Integer id)
	{
		return dao.findById(id);
	}
	@PutMapping("/updateTickets")
	public Ticket updateTicket(@RequestBody Ticket newTickets)
	{
		return dao.save(newTickets);	
	}
	
	@PutMapping("/updateTickets/{id}")
	public Ticket updateTicket(@RequestBody Ticket newTickets,
			@PathVariable(value = "id") int ticketId)
	{
		Ticket ticket = dao.findById(ticketId).orElseThrow(()->new RuntimeException());
		ticket.setAmount(newTickets.getAmount());
		ticket.setCategory(newTickets.getCategory());
	
		Ticket updateTicket = dao.save(ticket);
		return updateTicket;
											
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateBazz(
	  @PathVariable int id,
	  @RequestParam("name") String name) {
	    return new ResponseEntity<>(new Ticket(id), HttpStatus.OK);
	}
	
		@DeleteMapping("/deleteTicketDetails/{id}")
		public ResponseEntity<?> deleteBazz(@PathVariable Integer id){
			dao.deleteById(id);
		    return new ResponseEntity<>(new Ticket(id), HttpStatus.OK);
		}
}


