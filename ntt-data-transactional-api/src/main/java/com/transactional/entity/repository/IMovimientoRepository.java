package com.transactional.entity.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.transactional.common.GenericRepository;
import com.transactional.entity.Movimiento;

public interface IMovimientoRepository extends GenericRepository<Movimiento, UUID>{

	@Query(value = "select * from movimientos where cuenta_id = :cuentaId order by fecha desc limit 1", nativeQuery = true)
	public Movimiento getLastTransaction(@Param("cuentaId") Long cuentaId);
	
	
	@Query(value = "select * from movimientos where cuenta_id = (select cuenta_id from cuentas where numero_cuenta = :numCuenta) order by fecha desc limit 1", nativeQuery = true)
	public Movimiento getLastTransactionWithNumAmount(@Param("numCuenta") String numCuenta);
	
}
