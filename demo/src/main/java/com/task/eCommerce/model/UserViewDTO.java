package com.task.eCommerce.model;

public class UserViewDTO {
	private String success;
	private float amount;
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public UserViewDTO(String success, float amount) {
		super();
		this.success = success;
		this.amount = amount;
	}
	public UserViewDTO() {
		super();
	}
	@Override
	public String toString() {
		return "UserViewDTO [success=" + success + ", amount=" + amount + "]";
	}
}
