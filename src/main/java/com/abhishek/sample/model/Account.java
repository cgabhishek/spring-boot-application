package com.abhishek.sample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Abhishek Bhardwaj
 * @date Apr 13, 2018
 */
public class Account {

	// The default constructor is mandatory for jackson api to convert model to
	// JSON and vise-versa
	public Account() {

	}

	public Account(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("id")
	String id = null;

	@JsonProperty("name")
	String name = null;
}
