package com.transactional.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "movimientos")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID movimientoId;
    private LocalDateTime fecha;
	private String tipoMovimiento; 
	private Double valor;
	private Double saldo;
	private boolean movimientoInicial;
	
	@ManyToOne
	@JoinColumn(name= "cuentaId", nullable = false)
	private Cuenta cuenta;
	
}