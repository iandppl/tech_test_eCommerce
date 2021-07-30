package com.task.eCommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.task.eCommerce.model.UserAccount;

public interface UserRepository extends JpaRepository<UserAccount, String>{}