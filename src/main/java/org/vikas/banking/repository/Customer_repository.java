package org.vikas.banking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vikas.banking.dto.Customer;

public interface Customer_repository extends JpaRepository<Customer, Integer> {
	Customer findByEmail(String b);

	Customer findByMobile(long mobile);
}
