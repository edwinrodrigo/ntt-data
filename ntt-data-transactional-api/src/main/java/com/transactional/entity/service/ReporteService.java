package com.transactional.entity.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;

import com.transactional.entity.dto.MovimientoClienteDTO;
import com.transactional.entity.repository.IReporteRepository;
import com.transactional.util.TypeAmountEnum;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReporteService implements IReporteService{

	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	private final IReporteRepository reporteRepository;	
	
	public List<MovimientoClienteDTO> listMovimientoUsuarioResponse(Long clienteId, String fechaDesde, String fechaHasta){
		
		List<MovimientoClienteDTO> lresult = reporteRepository.getMovementsForClient(clienteId, LocalDate.parse(fechaDesde,DATE_FORMAT), LocalDate.parse(fechaHasta,DATE_FORMAT)); 
		lresult.forEach(item -> item.setTipo(TypeAmountEnum.valueOf(item.getTipo()).getValue()));
		return lresult;
	}
	
}