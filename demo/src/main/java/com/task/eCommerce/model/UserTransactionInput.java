package com.task.eCommerce.model;

public class UserTransactionInput {
	String email;
	String transferee;
	float amount;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTransferee() {
		return transferee;
	}
	public void setTransferee(String transferee) {
		this.transferee = transferee;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public UserTransactionInput(String email, String transferee, float amount) {
		super();
		this.email = email;
		this.transferee = transferee;
		this.amount = amount;
	}
	public UserTransactionInput() {
		super();
	}
	
}
