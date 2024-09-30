package com.transactional.entity.service;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import com.transactional.common.GenericCRUDImpl;
import com.transactional.common.GenericRepository;
import com.transactional.entity.Cuenta;
import com.transactional.entity.Movimiento;
import com.transactional.entity.repository.ICuentaRepository;
import com.transactional.exception.CustomErrorResponse;
import com.transactional.util.TipoMovimiento;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CuentaService extends GenericCRUDImpl<Cuenta, Long> implements ICuentaService{

	Logger logger = LoggerFactory.getLogger(CuentaService.class);
	
	private final ICuentaRepository cuentaRepository;
	private final IMovimientoService movimientoService;
	
	@Value("${nttdatamanagerapi.baseurl}")
	private String baseUrlManagerApi;
	
	@Value("${nttdatamanagerapi.clientcontroller.findbyid}")
	private String pathClientFindById;
	
	@Value("${nttdatamanagerapi.clientcontroller.findbyIdMsgError}")
	private String msgErrorFindCliendById;
	
	@Override
	protected GenericRepository<Cuenta, Long> getRepository() {

		return cuentaRepository;
	}
	
	@Override
	public Cuenta saveAmount(Cuenta cuenta) throws CustomErrorResponse {
		
		try {
			verifyClient(cuenta.getIdCliente());	
		} catch (ResponseStatusException e) {
			throw new CustomErrorResponse(e.getReason());
		}
		
		if(existAmount(cuenta.getNumeroCuenta())) {
			throw new CustomErrorResponse("El numero de cuenta "+cuenta.getNumeroCuenta()+" ya esta utilizado");
		}
		
		try {
			cuentaRepository.save(cuenta);
			Movimiento initMovement = new Movimiento();
			initMovement.setCuenta(cuenta);
			initMovement.setFecha(LocalDateTime.now());
			initMovement.setSaldo(cuenta.getSaldoInicial());
			initMovement.setValor(cuenta.getSaldoInicial());
			initMovement.setTipoMovimiento(TipoMovimiento.DEPOSITO.getValue());
			initMovement.setMovimientoInicial(Boolean.TRUE);
			movimientoService.save(initMovement);
		} catch (DataIntegrityViolationException e) {
			throw new CustomErrorResponse("Error de integridad - "+ e.getMessage());
		}
		
		return cuenta;
	}
	
	private void verifyClient(Long clientId) throws ResponseStatusException {
		
		WebClient client = WebClient.builder()
				.baseUrl(baseUrlManagerApi).build();
		
		String response = client.get()
					.uri(pathClientFindById,clientId)
					.retrieve()
					.onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(
							new ResponseStatusException(
						      		  HttpStatus.NO_CONTENT, msgErrorFindCliendById
						      		)))
					.bodyToMono(String.class).block();
		
		logger.info(response);
		
	}
	
	private boolean existAmount(String numeroCuenta) {
		Cuenta cuenta = this.cuentaRepository.findByNumeroCuenta(numeroCuenta);
		return cuenta != null;
	}

}