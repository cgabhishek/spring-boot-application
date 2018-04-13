package com.abhishek.sample.dao;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.abhishek.sample.model.Account;
/**
 * 
 * @author Abhishek Bhardwaj
   @date Apr 13, 2018
 */
@Service
public class AccountDAO {

	public List<Account> getAccounts(String accountIdOrZero) {
		List<Account> accounts = Arrays.asList(new Account("0", "test0"), new Account("1", "test1"),
				new Account("2", "test2"), new Account("3", "test3"));

		if (accountIdOrZero.equals("0")) {
			return accounts;
		} else
			return Arrays
					.asList(accounts.stream().filter(x -> accountIdOrZero.equals(x.getId())).findAny().orElse(null));
	}

}
