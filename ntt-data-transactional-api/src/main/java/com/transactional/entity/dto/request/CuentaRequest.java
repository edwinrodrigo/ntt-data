package com.transactional.entity.dto.request;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CuentaRequest {

	private Long cuentaId;

	@Length(min = 6, max = 6, message = "La cuenta debe tener 6 caracteres")
	@NotNull(message = "Numero de cuenta no puede ser nulo")
	private String numeroCuenta;

	@NotNull(message = "Ingrese un tipo de cuenta")
	private String tipoCuenta;

	@NotNull(message = "Debe ingresar el saldo inicial")
	private Double saldoInicial;

	@NotNull(message = "Debe ingresar un idCliente")
	private Long idCliente;

	private boolean estado;

	private List<MovimientoRequest> movimientos;

}
