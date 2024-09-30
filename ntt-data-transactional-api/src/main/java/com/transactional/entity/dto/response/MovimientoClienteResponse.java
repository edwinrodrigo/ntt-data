package com.transactional.entity.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class MovimientoClienteResponse {

	private Long rownum;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDateTime fecha;
	private String cliente;
	private String numeroCuenta;
	private String tipo;
	private String saldoInicial;
	private Boolean estado;
	private BigDecimal movimiento;
	private BigDecimal saldoDisponible;
	
}