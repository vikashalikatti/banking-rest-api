package org.vikas.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import org.vikas.banking.dto.Customer;
import org.vikas.banking.helper.ResponseStructure;
import org.vikas.banking.service.Customer_service;

@RestController("/customer")


public class Customer_Controller {
	@Autowired
	Customer_service customer_service;
	public ResponseEntity<ResponseStructure<Customer>> signup(@ModelAttribute Customer customer,String date)throws Exception{
		return customer_service.signup(customer,date);
	}
}
