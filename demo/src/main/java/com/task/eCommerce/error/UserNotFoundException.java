package com.task.eCommerce.error;

import java.lang.RuntimeException;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class UserNotFoundException extends RuntimeException {
	public UserNotFoundException(String email) {
		super("User for the given email :"+email+" does not exist");
	}

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
