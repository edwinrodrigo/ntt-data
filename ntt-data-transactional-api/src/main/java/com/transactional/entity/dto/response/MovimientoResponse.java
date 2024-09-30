package com.transactional.entity.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovimientoResponse {
	
	private UUID movimientoId;
    private LocalDateTime fecha;
    private String tipoMovimiento;
	private Double valor;
	private Double saldo;

	@JsonManagedReference
	private CuentaResponse cuenta;
}
