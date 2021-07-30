package com.task.eCommerce;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.task.eCommerce.controller.UserController;
import com.task.eCommerce.error.UserAlreadyExistException;
import com.task.eCommerce.model.UserAccount;
import com.task.eCommerce.service.UserService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserAccountTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserController userController;
	
	UserAccount createNewAccount = new UserAccount("hello@world.com",(float)1000.0);
	UserAccount existingAccount = new UserAccount("testing@testing.com",(float)1000.0);
	
	@Test
	public void FindUserAccountSuccessTest() {
		assertNotNull(userService.findUserByEmail("testing@testing.com"));
	}
	
	@Test
	public void FindUserAccountFailTest() {
		UserAccount userAccount = userService.findUserByEmail("testing2@testing.com");
		assertNull(userAccount);
	}
	
	@Test
	public void CreateUserAccountSuccessTest() {
		UserAccount userAccount = userService.createNewUser(createNewAccount);
		assertNotNull(userAccount);
	}
	
	@Test
	public void CreateUserAccountFailTest() {
		userController.createUser("testing@tesing.com");
		Assertions.assertThrows(UserAlreadyExistException.class, ()->{
			userController.createUser("testing@tesing.com");
		});
	}
}