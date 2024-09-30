package com.transactional.test.integration;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.transactional.entity.dto.request.CuentaRequest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CuentaIntegrationTest {

	Logger logger = LoggerFactory.getLogger(CuentaIntegrationTest.class);
	
	@Value("${nttdata-transactional-test.cuenta.crear}")
	private String urlTest;
	
	@Autowired
    private WebTestClient webTestClient;
	
	 @Test
	 public void testCrearCuenta() {
		 
        try {
			Long idCliente = 1L;
			String numeroCuenta = "456335";
			
			CuentaRequest cuenta = new CuentaRequest();
			cuenta.setTipoCuenta("A");
			cuenta.setNumeroCuenta(numeroCuenta);
			cuenta.setSaldoInicial(25000D);
			cuenta.setIdCliente(idCliente);
			cuenta.setEstado(true);
			
			webTestClient.post()
			    .uri(urlTest)
			    .bodyValue(cuenta)
			    .exchange()
			    .expectStatus().isCreated()
			    .expectBody()
			    .jsonPath("$.cuentaId").isNotEmpty()
			    .jsonPath("$.numeroCuenta").isEqualTo(numeroCuenta)
			    .jsonPath("$.tipoCuenta").isEqualTo("A")
			    .jsonPath("$.saldoInicial").isEqualTo(25000D);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	  
	 }
	
}
