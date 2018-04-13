package com.abhishek.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Abhishek Bhardwaj
 * @date Apr 13, 2018
 */
public class Invoice {

	public Invoice() {
	}

	public Invoice(String invId, String invDate) {
		this.invId = invId;
		this.invDate = invDate;
	}

	public String getInvId() {
		return invId;
	}

	public void setInvId(String invId) {
		this.invId = invId;
	}

	public String getInvDate() {
		return invDate;
	}

	public void setInvDate(String invDate) {
		this.invDate = invDate;
	}

	@JsonProperty("invoiceId")
	String invId;

	@JsonProperty("invoiceDate")
	String invDate;
}
