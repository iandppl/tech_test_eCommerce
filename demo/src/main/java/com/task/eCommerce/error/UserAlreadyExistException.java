package com.task.eCommerce.error;

import java.lang.RuntimeException;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class UserAlreadyExistException extends RuntimeException {
	public UserAlreadyExistException(String email) {
		super("User for the given email :"+email+" already exist");
	}

    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
