package com.transactional.entity.service;

import java.util.List;

import com.transactional.entity.dto.MovimientoClienteDTO;

public interface IReporteService {

	public List<MovimientoClienteDTO> listMovimientoUsuarioResponse(Long clienteId, String fechaDesde, String fechaHasta);
	
}