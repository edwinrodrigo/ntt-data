package com.transactional.entity.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CuentaResponse {

	 private Long cuentaId;
	 private String numeroCuenta;
	 private String tipoCuenta;
	 private Double saldoInicial;
	 private Long idCliente;
	 private Boolean estado;
	 
	 @JsonBackReference
	 private List<MovimientoResponse> movimientos;

	public CuentaResponse(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}	 
	
}
