package com.manager.entity.service;

import org.springframework.stereotype.Service;

import com.manager.common.GenericCRUDImpl;
import com.manager.common.GenericRepository;
import com.manager.entity.Cliente;
import com.manager.entity.repository.IClienteRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService extends GenericCRUDImpl<Cliente, Long> implements IClienteService {
	
	private final IClienteRepository clienteRepository;
	
	@Override
	protected GenericRepository<Cliente, Long> getRepository() {

		return clienteRepository;
	}

}
