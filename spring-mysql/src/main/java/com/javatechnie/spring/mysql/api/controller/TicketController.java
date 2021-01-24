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

/**
 * @author Dell PC
 *
 */
@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketDao dao;

	/**
	 * @param tickets
	 * @return
	 */
	@PostMapping("/bookTickets")
	public String bookTicket(@RequestBody List<Ticket> tickets)
	{
		dao.saveAll(tickets);
		return "ticket booked : "+ tickets.size();
	}

	/**
	 * @return
	 */
	@GetMapping("/getTickets")
	public List<Ticket> getTickets()
	{
		return (List<Ticket>)dao.findAll();
	}

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public Optional<Ticket> getTicketsBasedOnId(@PathVariable(value = "id") Integer id)
	{
		return dao.findById(id);
	}

	/**
	 * @param newTickets
	 * @return
	 */
	@PutMapping("/updateTickets")
	public List<Ticket> updateTicket(@RequestBody List<Ticket> newTickets)
	{
		return dao.saveAll(newTickets);	
	}

	/**
	 * @param newTickets
	 * @param ticketId
	 * @return
	 */
	@PutMapping("/updateTickets/{id}")
	public Ticket updateTicket(@RequestBody List<Ticket> newTickets,
			@PathVariable(value = "id") int ticketId)
	{
		Ticket ticket = dao.findById(ticketId).orElseThrow(()->new RuntimeException("Ticket ID is not valid"));
		for(Ticket t1: newTickets)
		{
			ticket.setAmount((t1.getAmount()!=0)?t1.getAmount():ticket.getAmount());
			ticket.setCategory((t1.getCategory()!=null)?t1.getCategory():ticket.getCategory());
			return dao.save(ticket);
		}
		return null;

	}

	/**
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteTicketDetails/{id}")
	public ResponseEntity<?> deleteBazz(@PathVariable Integer id){
		dao.deleteById(id);
		return new ResponseEntity<>(new Ticket(id), HttpStatus.OK);
	}
	
	@GetMapping("/getTicketDetailsById")
	public Optional<Ticket> getTicketBasedOnId(@RequestParam Integer id)
	{
		return dao.findById(id);
	}
}


