package com.task.eCommerce.error;

import java.lang.RuntimeException;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class TransactionsNotFoundException extends RuntimeException {
	public TransactionsNotFoundException(String email) {
		super("Transactions for the given email :"+email+" does not exist");
	}

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
