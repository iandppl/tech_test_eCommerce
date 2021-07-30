package com.task.eCommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class UserAccount {
	
	@Id
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "AMOUNT")
	private float amount;
	
	public UserAccount(String email, float amount) {
		super();
		this.email = email;
		this.amount = amount;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public UserAccount() {
		super();
	}
	
	@Override
	public String toString() {
		return "User [email=" + email + ", amount=" + amount + "]";
	}
	
}
