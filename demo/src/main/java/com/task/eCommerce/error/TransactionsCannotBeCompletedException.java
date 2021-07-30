package com.task.eCommerce.error;

import java.lang.RuntimeException;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class TransactionsCannotBeCompletedException extends RuntimeException {
	public TransactionsCannotBeCompletedException(String email) {
		super("Transactions for the given sender email :"+email+" cannot be completed");
	}

    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}
