package org.vikas.banking.service;

import org.springframework.http.ResponseEntity;
import org.vikas.banking.dto.Customer;
import org.vikas.banking.helper.ResponseStructure;

public interface Customer_service {

	ResponseEntity<ResponseStructure<Customer>> signup(Customer customer, String date)throws Exception;

}
