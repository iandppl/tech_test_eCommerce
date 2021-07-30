package com.task.eCommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.eCommerce.model.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Integer> {
	public List<Transactions> findByFrom(String sender);
	public List<Transactions> findByTo(String reciever);
}
