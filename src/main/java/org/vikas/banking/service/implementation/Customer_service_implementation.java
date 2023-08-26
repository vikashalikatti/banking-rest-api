package org.vikas.banking.service.implementation;

import java.time.Duration;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.vikas.banking.dto.Customer;
import org.vikas.banking.helper.JwtUtil;
import org.vikas.banking.helper.ResponseStructure;
import org.vikas.banking.helper.SendMail;
import org.vikas.banking.repository.Customer_repository;
import org.vikas.banking.service.Customer_service;

@Service
public class Customer_service_implementation implements Customer_service {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private Customer_repository customer_repository;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private SendMail mail;

	@Override
	public ResponseEntity<ResponseStructure<Customer>> signup(Customer customer, String date) throws Exception {
		ResponseStructure<Customer> structure = new ResponseStructure<>();
		if (customer_repository.findByEmail(customer.getEmail()) != null
				|| customer_repository.findByMobile(customer.getMobile()) != null) {
			structure.setData(null);
			structure.setMessage("You have a Bank Account");
			structure.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			return new ResponseEntity<>(structure, HttpStatus.ALREADY_REPORTED);
		}
		String token = jwtUtil.generateJwtTokenForCustomer(customer, Duration.ofMinutes(5));
		customer.setDate(LocalDate.parse(date));
		customer.setPassword(encoder.encode(customer.getPassword()));

		if (mail.sendLink(customer,token)) {
			customer_repository.save(customer);
			structure.setData(customer);
			structure.setMessage("Verification Link send to Email Succesfull");
			structure.setStatus(HttpStatus.CREATED.value());
			return new ResponseEntity<>(structure, HttpStatus.CREATED);
		} else {
			structure.setData(null);
			structure.setMessage("Something Went Worng");
			structure.setStatus(HttpStatus.BAD_GATEWAY.value());
			return new ResponseEntity<>(structure, HttpStatus.BAD_GATEWAY);
		}

	}
}
