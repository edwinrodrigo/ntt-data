package com.transactional.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public class CustomErrorResponse extends Exception {

	public CustomErrorResponse(String message) {
		super(message);
	}


}
