package com.transactional.entity.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@SqlResultSetMapping(name = "movimientoClienteMapping", classes = {
		@ConstructorResult(targetClass = MovimientoClienteDTO.class, columns = {
				@ColumnResult(name = "rownum", type = Long.class),
				@ColumnResult(name = "fecha", type = LocalDateTime.class),
				@ColumnResult(name = "cliente", type = String.class),
				@ColumnResult(name = "numero_cuenta", type = String.class),
				@ColumnResult(name = "tipo", type = String.class),
				@ColumnResult(name = "saldo_inicial", type = String.class),
				@ColumnResult(name = "estado", type = Boolean.class),
				@ColumnResult(name = "movimiento", type = BigDecimal.class),
				@ColumnResult(name = "saldo_disponible", type = BigDecimal.class),

		}) })
@NamedNativeQuery(name = MovimientoClienteDTO.MOVEMENTS_FOR_CLIENT, query = "select row_number() over() as rownum, "
																		+ "	m.fecha, "
																		+ "	cl.nombre cliente, "
																		+ "	c.numero_cuenta, "
																		+ "	c.tipo_cuenta tipo, "
																		+ "	c.saldo_inicial, "
																		+ "	c.estado, "
																		+ "	m.valor movimiento, "
																		+ "	m.saldo saldo_disponible"
																		+ "  from movimientos m "
																		+ "  join cuentas c on m.cuenta_id = c.cuenta_id "
																		+ "  join clientes cl on cl.id = c.id_cliente "
																		+ " where cl.id = :idCliente "
																		+ "   and m.movimiento_inicial is false "
																		+ "   and cast(m.fecha AS date) between :fechaDesde and :fechaHasta "
																		+ " order by m.fecha desc", 
																		resultClass = MovimientoClienteDTO.class)
public class MovimientoClienteDTO {

	public static final String MOVEMENTS_FOR_CLIENT = "movimientosByClientes";
	

	
	@Id
	private Long rownum;
	private LocalDateTime fecha;
	private String cliente;
	private String numeroCuenta;
	private String tipo;
	private String saldoInicial;
	private Boolean estado;
	private BigDecimal movimiento;
	private BigDecimal saldoDisponible;
	
}