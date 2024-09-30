package com.transactional.entity.repository;

import com.transactional.common.GenericRepository;
import com.transactional.entity.Cuenta;

public interface ICuentaRepository extends GenericRepository<Cuenta, Long>{

	Cuenta findByNumeroCuenta(String numeroCuenta);
	
}
