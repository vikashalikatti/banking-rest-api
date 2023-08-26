package org.vikas.banking.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bank_Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	double deposit;
	double withdraw;
	double balance;
	LocalDateTime dateTime;
}