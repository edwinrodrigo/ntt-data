package com.manager.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class NotFoundException extends RuntimeException{

	public NotFoundException(String message) {
		super(message);
	}
	
}
