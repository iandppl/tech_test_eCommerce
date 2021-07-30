package com.task.eCommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transactions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TRANS_SEQ")
	@Column(name = "ID")
	int id;
	
	@Column(name = "SENDER")
	String from;
	
	@Column(name = "RECIEVER")
	String to;
	
	@Column(name = "TYPE")
	String type;
	
	@Column(name = "AMOUNT")
	float amount;
	
	@Column(name = "DATE")
	String datetime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}	
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	
	public Transactions(String from, String to, String type, float amount, String datetime) {
		super();
		this.from = from;
		this.to = to;
		this.type = type;
		this.amount = amount;
		this.datetime = datetime;
	}
	
	public Transactions() {
		super();
	}
	
}
