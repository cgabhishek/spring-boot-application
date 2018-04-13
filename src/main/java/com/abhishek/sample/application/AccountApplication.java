package com.abhishek.sample.application;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * 
 * @author Abhishek Bhardwaj
   @date Apr 13, 2018
 */
@Configuration
@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);

	}
	//to run it from mvn, use the command as "mvn clean install spring-boot:run"
}
