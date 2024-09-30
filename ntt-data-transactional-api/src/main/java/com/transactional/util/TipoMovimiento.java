package com.transactional.util;

public enum TipoMovimiento {

	DEPOSITO("D"), 
	RETIRO("R");
	
	private TipoMovimiento(String value) {
		this.value = value;
	}
	
	private String value;
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
}