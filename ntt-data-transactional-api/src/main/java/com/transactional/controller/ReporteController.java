package com.transactional.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.transactional.entity.dto.MovimientoClienteDTO;
import com.transactional.entity.dto.response.MovimientoClienteResponse;
import com.transactional.entity.service.IReporteService;
import com.transactional.exception.CustomErrorResponse;
import com.transactional.util.GenericMapperConverterUtils;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ReporteController implements IReporteController{
	
	private final GenericMapperConverterUtils genericConverterUtils;
	private final IReporteService reporteService;
	
	@Override
	public ResponseEntity<List<MovimientoClienteResponse>> getMovementsByClient(Long clienteId, String fechaDesde,
			String fechaHasta) throws CustomErrorResponse {
		
		List<MovimientoClienteDTO> result = reporteService.listMovimientoUsuarioResponse(clienteId, fechaDesde, fechaHasta);
		result.forEach(item -> item.setRownum(null));
		return ResponseEntity.ok().body(this.genericConverterUtils.convertListToListDto(result, MovimientoClienteResponse.class));
	}
}