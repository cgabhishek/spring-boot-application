package com.abhishek.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.sample.model.Account;
import com.abhishek.sample.model.Invoice;
import com.abhishek.sample.service.AccountService;

/**
 * 
 * @author Abhishek Bhardwaj
 * @date Apr 13, 2018
 */
@RestController
@RequestMapping("/accounts")
public class CustomerController {

	@Autowired
	public AccountService accountService;

	@RequestMapping(method = RequestMethod.GET, value = "/{accountId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity getAccounts(@PathVariable("accountId") String accountIdOrZero) {
		List<Account> accounts = null;
		accounts = accountService.getAccounts(accountIdOrZero);
		return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity createAccount(@RequestBody Account newAccount) {
		System.out.println("In POST method for account creation");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity updateAccount(@RequestBody Account updateAccount) {
		System.out.println("In PUT method for account creation");
		return new ResponseEntity<Account>(updateAccount, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity deleteAccount(@RequestBody Account deleteAccount) {
		System.out.println("In DELETE method for account creation");
		return new ResponseEntity<Account>(deleteAccount, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{accountId}/invoices/{invoiceId}")
	public ResponseEntity getAccountInvoices(@PathVariable("accountId") String accountId,
			@PathVariable("invoiceId") String invoiceNumber) {
		Invoice invoice = new Invoice("10", "30-01-2017");
		return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
	}

}
