package org.vikas.banking.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@SequenceGenerator(initialValue = 12110111, allocationSize = 1, sequenceName = "Cust_id", name = "Cust_id")
	@GeneratedValue(generator = "Cust_id")
	int customer_id;
	String name;
	String password;
	String email;
	long mobile;
	String gender;
	LocalDate date;

	@OneToMany
	List<BankAccount> accounts;
}
