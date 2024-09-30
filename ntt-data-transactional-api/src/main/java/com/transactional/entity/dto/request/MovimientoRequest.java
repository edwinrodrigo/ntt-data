package com.transactional.entity.dto.request;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MovimientoRequest {
	
	private UUID movimientoId;
    private LocalDateTime fecha;
    private String tipoMovimiento;
    
    @NotNull(message = "Ingrese un valor")
	private Double valor;
	private Double saldo;
	
	@NotNull
	private CuentaRequest cuenta;
	

}
