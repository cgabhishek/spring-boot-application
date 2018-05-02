package com.abhishek.sample.controller.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.springframework.http.ResponseEntity;

import com.abhishek.sample.controller.CustomerController;
import com.abhishek.sample.controller.StaticBuilder;
import com.abhishek.sample.dao.AccountDAO;
import com.abhishek.sample.model.Account;
import com.abhishek.sample.service.AccountService;

/**
 * 
 * @author Abhishek Bhardwaj
 * @date Apr 13, 2018
 */
public class CustomerControllerTest {

	@Test
	public void getAccountWithMock() {
		List<Account> accounts = Arrays.asList(new Account("10", "test10"), new Account("11", "test11"),
				new Account("12", "test12"));

		String actNo = "10";

		AccountDAO accountDAO = mock(AccountDAO.class);
		//when(accountDAO.getAccounts(actNo)).thenReturn(accounts);
		when(accountDAO.getAccounts(null)).thenReturn(accounts);
		AccountService customerService = new AccountService();
		customerService.setAccountDAO(accountDAO);
		List<Account> mockAccounts = customerService.getAccounts(actNo);
		// assertThat(mockAccounts.size(), is(3));
		assertThat(mockAccounts.get(0).getId(), is(actNo));
	}
	
	@Test @Ignore
	public void getAccountWithMock1()  {
		List<Account> accounts = Arrays.asList(new Account("10", "test10"), new Account("11", "test11"),
				new Account("12", "test12"));

		String actNo = "10";
		PowerMockito.mockStatic(StaticBuilder.class);
		AccountDAO accountDAO = mock(AccountDAO.class);
		StaticBuilder staticBuilder = mock(StaticBuilder.class);
		when(accountDAO.getAccounts(actNo)).thenReturn(accounts);
		//PowerMockito.doReturn("abhishek").when(StaticBuilder.class, "myMethod");
		//when(staticBuilder.myMethod()).thenReturn("abhishek");
		AccountService customerService = new AccountService();
		CustomerController customerController = new CustomerController();
		ResponseEntity accountsRes = customerController.getAccounts(actNo);
		customerService.setAccountDAO(accountDAO);
		List<Account> mockAccounts = customerService.getAccounts(actNo);
		// assertThat(mockAccounts.size(), is(3));
		assertThat(mockAccounts.get(0).getId(), is(actNo));
	}
}
