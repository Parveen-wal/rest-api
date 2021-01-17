package com.javatechnie.spring.mysql.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.ToString;

@Entity
@Table(name = "Ticket")
@ToString
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private double amount;
	private String category;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @param id
	 * @param amount
	 * @param category
	 */
	public Ticket(Integer id, double amount, String category) {
		super();
		this.id = id;
		this.amount = amount;
		this.category = category;
	}
	
	
	/**
	 * @param id
	 */
	public Ticket(Integer id)
	{
		super();
		this.id = id;
	}
	/**
	 * 
	 */
	public Ticket() {
		super();
	}
	



}
