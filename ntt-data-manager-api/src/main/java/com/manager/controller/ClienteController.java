package com.manager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.manager.entity.Cliente;
import com.manager.entity.dto.request.ClienteRequest;
import com.manager.entity.dto.response.ClienteResponse;
import com.manager.entity.service.IClienteService;
import com.manager.exception.CustomErrorResponse;
import com.manager.util.GenericMapperConverterUtils;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ClienteController implements IClienteController{
	
	private final GenericMapperConverterUtils genericConverterUtils;
	private final IClienteService clienteService;
	
	@Override
	public ResponseEntity<?> create(@Valid ClienteRequest clienteRequest) throws CustomErrorResponse {
		Cliente cliente = this.genericConverterUtils.convertToEntity(clienteRequest, Cliente.class);
		cliente = clienteService.save(cliente);
		ClienteResponse response = this.genericConverterUtils.convertToDto(cliente, ClienteResponse.class); 
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@Override
	public ResponseEntity<List<ClienteResponse>> getAll() throws CustomErrorResponse {
		List<Cliente> clientes = this.clienteService.findAll();
		return ResponseEntity.ok().body(this.genericConverterUtils.convertListToListDto(clientes, ClienteResponse.class));
	}

	@Override
	public ResponseEntity<ClienteResponse> getForId(Long id) throws ResponseStatusException {
		return ResponseEntity.ok().body(this.genericConverterUtils.convertToDto(this.clienteService.findById(id), ClienteResponse.class));
	}

	@Override
	public ResponseEntity<ClienteResponse> updateForId(Long id, ClienteRequest clienteRequest) throws CustomErrorResponse {
		Cliente cliente = this.genericConverterUtils.convertToEntity(clienteRequest, Cliente.class);
		cliente = clienteService.update(id, cliente);
		ClienteResponse response = this.genericConverterUtils.convertToDto(cliente, ClienteResponse.class); 
		return ResponseEntity.ok().body(response);
	}

	@Override
	public ResponseEntity<Void> deleteForId(Long id) throws CustomErrorResponse {
		this.clienteService.delete(id);
		return ResponseEntity.ok().body(null);
	}
	
	
}