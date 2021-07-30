package com.task.eCommerce.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.eCommerce.error.TransactionsNotFoundException;
import com.task.eCommerce.model.ApiResponseDTO;
import com.task.eCommerce.model.TransactionDTO;
import com.task.eCommerce.model.UserTransactionInput;
import com.task.eCommerce.model.Transactions;
import com.task.eCommerce.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public ApiResponseDTO createNewTransaction(UserTransactionInput input) {
		ApiResponseDTO result = new ApiResponseDTO();	
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");  
	    Date date = new Date();
		Transactions userTransaction = new Transactions(input.getEmail(),input.getTransferee(),"transfer",input.getAmount(),formatter.format(date));
		try{
			transactionRepository.save(userTransaction);
			result.setSuccess("true");
		}catch(Error e) {
			result.setSuccess("false");
		}
		return result;
	}
	
	public TransactionDTO getPastTransacions(String email) {
		TransactionDTO transactionDto = new TransactionDTO();
		List<Transactions> transactionList = new ArrayList<>();
		transactionList = transactionRepository.findByFrom(email);
		transactionList.addAll(transactionRepository.findByTo(email));
		if(transactionList.isEmpty()) {
			throw new TransactionsNotFoundException(email);
		}else {
			transactionDto.setSuccess("true");
			transactionDto.setTransationsList(transactionList);
		}
		return transactionDto;
	}
}
