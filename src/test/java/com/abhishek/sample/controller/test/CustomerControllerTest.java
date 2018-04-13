package com.abhishek.sample.controller.test;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.abhishek.sample.dao.AccountDAO;
import com.abhishek.sample.model.Account;
import com.abhishek.sample.service.AccountService;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.hamcrest.CoreMatchers.is;

/**
 * 
 * @author Abhishek Bhardwaj
   @date Apr 13, 2018
 */
public class CustomerControllerTest {

	@Test
	public void getAccountWithMock() {
		List<Account> accounts = Arrays.asList(new Account("10", "test10"), new Account("11", "test11"),
				new Account("12", "test12"));

		String actNo = "10";

		AccountDAO accountDAO = mock(AccountDAO.class);
		when(accountDAO.getAccounts(actNo)).thenReturn(accounts);
		AccountService customerService = new AccountService();
		customerService.setAccountDAO(accountDAO);
		List<Account> mockAccounts = customerService.getAccounts(actNo);
		// assertThat(mockAccounts.size(), is(3));
		assertThat(mockAccounts.get(0).getId(), is(actNo));
	}
}
