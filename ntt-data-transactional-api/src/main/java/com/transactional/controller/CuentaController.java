package com.transactional.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.transactional.entity.Cuenta;
import com.transactional.entity.dto.request.CuentaRequest;
import com.transactional.entity.dto.response.CuentaResponse;
import com.transactional.entity.service.ICuentaService;
import com.transactional.exception.CustomErrorResponse;
import com.transactional.util.GenericMapperConverterUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CuentaController implements ICuentaController{

	private final GenericMapperConverterUtils genericConverterUtils;
	private final ICuentaService cuentaService;
	
	@Override
	public ResponseEntity<?> create(@Valid CuentaRequest cuentaRequest) throws CustomErrorResponse {
		Cuenta cuenta = this.genericConverterUtils.convertToEntity(cuentaRequest, Cuenta.class);
		cuenta = cuentaService.saveAmount(cuenta);
		CuentaResponse response = this.genericConverterUtils.convertToDto(cuenta, CuentaResponse.class); 
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<List<CuentaResponse>> getAll() throws CustomErrorResponse {
		List<Cuenta> cuentas = this.cuentaService.findAll();
		return ResponseEntity.ok().body(this.genericConverterUtils.convertListToListDto(cuentas, CuentaResponse.class));
	}

	@Override
	public ResponseEntity<?> getForId(Long id) throws Exception {
		return ResponseEntity.ok().body(this.genericConverterUtils.convertToDto(this.cuentaService.findById(id), CuentaResponse.class));
	}

	@Override
	public ResponseEntity<CuentaResponse> updateForId(Long id, CuentaRequest cuentaRequest) throws CustomErrorResponse {
		Cuenta cuenta = this.genericConverterUtils.convertToEntity(cuentaRequest, Cuenta.class);
		cuenta = cuentaService.update(id, cuenta);
		CuentaResponse response = this.genericConverterUtils.convertToDto(cuenta, CuentaResponse.class); 
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Void> deleteForId(Long id) throws CustomErrorResponse {
		this.cuentaService.delete(id);
		return ResponseEntity.ok().body(null);
	}

}
