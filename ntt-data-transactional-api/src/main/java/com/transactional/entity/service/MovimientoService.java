package com.transactional.entity.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.transactional.common.GenericCRUDImpl;
import com.transactional.common.GenericRepository;
import com.transactional.entity.Cuenta;
import com.transactional.entity.Movimiento;
import com.transactional.entity.dto.response.CuentaResponse;
import com.transactional.entity.dto.response.MovimientoResponse;
import com.transactional.entity.repository.ICuentaRepository;
import com.transactional.entity.repository.IMovimientoRepository;
import com.transactional.exception.CustomErrorResponse;
import com.transactional.util.GenericMapperConverterUtils;
import com.transactional.util.TipoMovimiento;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovimientoService extends GenericCRUDImpl<Movimiento, UUID> implements IMovimientoService{

	private final IMovimientoRepository movimientoRepository;
	private final ICuentaRepository cuentaRepository;
	private final GenericMapperConverterUtils genericConverterUtils;
	
	@Value("${messages.insufficientbalance}")
	private String insufficientBalance;
	
	@Override
	protected GenericRepository<Movimiento, UUID> getRepository() {
		return movimientoRepository;
	}

	@Transactional
	@Override
	public MovimientoResponse saveMovement(Movimiento movimiento) throws CustomErrorResponse {

		Cuenta cuenta = cuentaRepository.findByNumeroCuenta(movimiento.getCuenta().getNumeroCuenta());
		Movimiento lastMovement = movimientoRepository.getLastTransactionWithNumAmount(movimiento.getCuenta().getNumeroCuenta());
		
		Double nuevoSaldo = lastMovement.getSaldo() + movimiento.getValor();
		TipoMovimiento TIPO_MOVIMIENTO;
		
		if(movimiento.getValor() < 0) {
			
			TIPO_MOVIMIENTO = TipoMovimiento.RETIRO;
			if(nuevoSaldo<0) {
				throw new CustomErrorResponse(insufficientBalance);
			}
		}else{
			
			TIPO_MOVIMIENTO = TipoMovimiento.DEPOSITO;
			
		}
		
		movimiento.setCuenta(cuenta);
		movimiento.setSaldo(nuevoSaldo);
		movimiento.setTipoMovimiento(TIPO_MOVIMIENTO.getValue());
		
		movimiento.setFecha(LocalDateTime.now());
		movimientoRepository.save(movimiento);
		
		MovimientoResponse response = genericConverterUtils.convertToDto(movimiento, MovimientoResponse.class);
		response.setCuenta(new CuentaResponse(cuenta.getNumeroCuenta()));
		
		return response;
		
	}

	
}