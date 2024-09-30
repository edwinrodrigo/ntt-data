package com.transactional.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "cuentas")
public class Cuenta {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long cuentaId;
	 
	 @Column(unique = true)
	 private String numeroCuenta;
	 private String tipoCuenta;
	 private Double saldoInicial;
	 private Long idCliente;
	 private boolean estado;
	 
	 @OneToMany(mappedBy = "cuenta", fetch = FetchType.LAZY)
	 private List<Movimiento> movimientos;
	 
	 
	 public Cuenta(String numeroCuenta) {
		 this.numeroCuenta = numeroCuenta;
	 }
	 
}