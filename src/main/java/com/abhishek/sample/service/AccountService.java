package com.abhishek.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhishek.sample.dao.AccountDAO;
import com.abhishek.sample.model.Account;

/**
 * 
 * @author Abhishek Bhardwaj
 * @date Apr 13, 2018
 */
@Service
public class AccountService {

	@Autowired
	public AccountDAO accountDAO;

	public List<Account> getAccounts(String accountIdOrZero) {
		List<Account> accounts = null;
		accounts = accountDAO.getAccounts(accountIdOrZero);
		return accounts;
	}

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

}
