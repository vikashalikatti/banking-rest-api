package org.vikas.banking.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class BankAccount {
	@Id
	@GeneratedValue(generator = "acno")
	@SequenceGenerator(initialValue = 456789211, allocationSize = 1, sequenceName = "acno", name = "acno")
	long account_No;
	String type;
	double amount;
	boolean status;
	double account_limit;

	@ManyToOne
	Customer customer;

	@OneToMany(cascade = CascadeType.ALL)
	List<Bank_Transaction> bank_Transactions;
}
