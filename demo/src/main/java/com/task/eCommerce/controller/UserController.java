package com.task.eCommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.eCommerce.error.TransactionsCannotBeCompletedException;
import com.task.eCommerce.error.UserAlreadyExistException;
import com.task.eCommerce.error.UserNotFoundException;
import com.task.eCommerce.model.ApiResponseDTO;
import com.task.eCommerce.model.TransactionDTO;
import com.task.eCommerce.model.UserAccount;
import com.task.eCommerce.model.UserTransactionInput;
import com.task.eCommerce.model.UserViewDTO;
import com.task.eCommerce.service.TransactionService;
import com.task.eCommerce.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	TransactionService transactionService;
	
	public void newAccountWithBalance(UserAccount account,float amount,String email, String action) {
		float newAmount = 0;
		if(action.equals("deduct")) {
			newAmount = account.getAmount() - amount;
		}else {
			newAmount = account.getAmount() + amount;
		}
		UserAccount accountWithNewBalanceDeducted = new UserAccount(email,newAmount);
		userService.createNewUser(accountWithNewBalanceDeducted);
	}

	@GetMapping("/user/{email}")
	public UserViewDTO getUserByEmail(@PathVariable String email) {
		UserAccount user = new UserAccount();
		UserViewDTO userViewDto = new UserViewDTO();
		user =  userService.findUserByEmail(email);
		if(user != null) {
			userViewDto.setSuccess("true");
			userViewDto.setAmount(user.getAmount());
		}else {
			throw new UserNotFoundException(email);
		}
		return userViewDto;
	}
	
	@PostMapping("/user")
	public UserViewDTO createUser(@RequestBody String email) {
		UserViewDTO userViewDto = new UserViewDTO();
		UserAccount user = new UserAccount(email,(float)1000.0);
		UserAccount isNewUser = userService.findUserByEmail(email);
		if(isNewUser == null) {
			userViewDto.setSuccess("true");
			userViewDto.setAmount(user.getAmount());
			userService.createNewUser(user);
		}else {
			throw new UserAlreadyExistException(email);
		}
		return userViewDto;
	}
	
	@GetMapping("/transaction/{email}")
	public TransactionDTO getTransactionsWithEmail(@PathVariable String email) {
		return transactionService.getPastTransacions(email);
	}
	
	@PostMapping("/transaction")
	public ApiResponseDTO createTransaction(@RequestBody UserTransactionInput input) {
		UserAccount userSender = userService.findUserByEmail(input.getEmail());
		UserAccount userReciever = userService.findUserByEmail(input.getTransferee());
		ApiResponseDTO result = new ApiResponseDTO(); 
		if(userSender == null || userReciever == null || userSender.getAmount()<input.getAmount()) {
			throw new TransactionsCannotBeCompletedException(input.getEmail());
		}else {
			newAccountWithBalance(userSender, input.getAmount(),input.getEmail(),"deduct");
			newAccountWithBalance(userReciever, input.getAmount(),input.getTransferee(),"add");
			result = transactionService.createNewTransaction(input);
		}
		return result;
	}
}
