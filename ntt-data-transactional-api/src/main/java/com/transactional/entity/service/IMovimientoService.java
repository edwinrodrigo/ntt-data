package com.transactional.entity.service;

import java.util.UUID;

import com.transactional.common.GenericCRUD;
import com.transactional.entity.Movimiento;
import com.transactional.entity.dto.response.MovimientoResponse;
import com.transactional.exception.CustomErrorResponse;

public interface IMovimientoService extends GenericCRUD<Movimiento, UUID> {
	
	MovimientoResponse saveMovement(Movimiento movimiento) throws CustomErrorResponse;

}
