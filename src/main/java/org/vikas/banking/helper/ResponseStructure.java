package org.vikas.banking.helper;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	int status;
	String message;
	T data;
}
