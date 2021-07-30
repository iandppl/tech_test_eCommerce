package com.task.eCommerce.model;

public class ApiResponseDTO {
	private String success;

	public String getSuccess() {
		return success;
	}

	public void setSuccess(String success) {
		this.success = success;
	}

	public ApiResponseDTO(String success) {
		super();
		this.success = success;
	}

	public ApiResponseDTO() {
		super();
	}
}
