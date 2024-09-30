package com.transactional.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.transactional.entity.Movimiento;
import com.transactional.entity.dto.request.MovimientoRequest;
import com.transactional.entity.dto.response.MovimientoResponse;
import com.transactional.entity.service.IMovimientoService;
import com.transactional.exception.CustomErrorResponse;
import com.transactional.util.GenericMapperConverterUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MovimientoController implements IMovimientoController{

	private final GenericMapperConverterUtils genericConverterUtils;
	private final IMovimientoService movimientoService;
	
	@Override
	public ResponseEntity<?> create(@Valid MovimientoRequest movimientoRequest) throws CustomErrorResponse {
		Movimiento movimiento = this.genericConverterUtils.convertToEntity(movimientoRequest, Movimiento.class);
//		movimiento = movimientoService.saveMovement(movimiento);
		MovimientoResponse response = movimientoService.saveMovement(movimiento); 
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<List<MovimientoResponse>> getAll() throws CustomErrorResponse {
		List<Movimiento> movimientos = this.movimientoService.findAll();
		return ResponseEntity.ok().body(this.genericConverterUtils.convertListToListDto(movimientos, MovimientoResponse.class));
	}

	@Override
	public ResponseEntity<MovimientoResponse> getForId(String id) throws CustomErrorResponse {
		return ResponseEntity.ok().body(this.genericConverterUtils.convertToDto(this.movimientoService.findById(UUID.fromString(id)), MovimientoResponse.class));
	}

	@Override
	public ResponseEntity<MovimientoResponse> updateForId(String id, MovimientoRequest MovimientoRequest) throws CustomErrorResponse {
		Movimiento movimiento = this.genericConverterUtils.convertToEntity(MovimientoRequest, Movimiento.class);
		movimiento = movimientoService.update(UUID.fromString(id), movimiento);
		MovimientoResponse response = this.genericConverterUtils.convertToDto(movimiento, MovimientoResponse.class); 
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Void> deleteForId(String id) throws CustomErrorResponse {
		this.movimientoService.delete(UUID.fromString(id));
		return ResponseEntity.ok().body(null);
	}
	
}
