package com.task.eCommerce;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.task.eCommerce.controller.UserController;
import com.task.eCommerce.error.TransactionsCannotBeCompletedException;
import com.task.eCommerce.error.TransactionsNotFoundException;
import com.task.eCommerce.model.ApiResponseDTO;
import com.task.eCommerce.model.UserTransactionInput;
import com.task.eCommerce.service.TransactionService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TransactionTest {
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	UserController userController;
	
	UserTransactionInput input = new UserTransactionInput("testing@testing.com","testing1@testing.com",(float)10.0);
	
	UserTransactionInput excess = new UserTransactionInput("testing@testing.com","testing1@testing.com",(float)10000000.0);
	
	@Test
	public void transactionNotFoundTest() {
		Assertions.assertThrows(TransactionsNotFoundException.class, ()->{
			transactionService.getPastTransacions("testing3@testing.com");
		});
	}
	
	@Test
	public void transactionFoundTest() {
		ApiResponseDTO response = transactionService.createNewTransaction(input);
		assertTrue(response.getSuccess().equals("true"));
		assertNotNull(transactionService.getPastTransacions(input.getEmail()));
		assertNotNull(transactionService.getPastTransacions(input.getTransferee()));
	}
	
	@Test
	public void createTransactionSuccessTest() {
		ApiResponseDTO response = transactionService.createNewTransaction(input);
		assertTrue(response.getSuccess().equals("true"));
	}
	
	@Test
	public void createTransactionErrorTest() {
		Assertions.assertThrows(TransactionsCannotBeCompletedException.class, ()->{
			userController.createTransaction(excess);
		});
	}
}
