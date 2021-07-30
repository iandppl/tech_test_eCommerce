package com.task.eCommerce.model;

import java.util.List;

public class TransactionDTO {
	String success;
	List<Transactions> transationsList;
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public List<Transactions> getTransationsList() {
		return transationsList;
	}
	public void setTransationsList(List<Transactions> transationsList) {
		this.transationsList = transationsList;
	}
	
	public TransactionDTO(String success, List<Transactions> transationsList) {
		super();
		this.success = success;
		this.transationsList = transationsList;
	}
	
	public TransactionDTO() {
		super();
	}
}
