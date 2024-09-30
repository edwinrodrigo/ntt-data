package com.transactional.entity.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.transactional.entity.dto.MovimientoClienteDTO;

@Repository
public interface IReporteRepository extends JpaRepository<MovimientoClienteDTO, Long> {

	@Query(name = MovimientoClienteDTO.MOVEMENTS_FOR_CLIENT, nativeQuery = true)
	List<MovimientoClienteDTO> getMovementsForClient(@Param("idCliente") Long idCliente, @Param("fechaDesde") LocalDate fechaDesde, @Param("fechaHasta") LocalDate fechaHasta);
	
}