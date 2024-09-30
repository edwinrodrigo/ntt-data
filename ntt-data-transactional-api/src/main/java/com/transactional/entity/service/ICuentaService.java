package com.transactional.entity.service;

import com.transactional.common.GenericCRUD;
import com.transactional.entity.Cuenta;
import com.transactional.exception.CustomErrorResponse;

public interface ICuentaService extends GenericCRUD<Cuenta, Long>  {

	Cuenta saveAmount(Cuenta cuenta) throws CustomErrorResponse;
	
}
