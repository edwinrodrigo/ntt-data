package com.manager.test.integration;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.manager.entity.dto.request.ClienteRequest;
import com.manager.util.GeneroTypeEnum;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClienteIntegrationTest {

	Logger logger = LoggerFactory.getLogger(ClienteIntegrationTest.class);
	
	@Value("${nttdata-manager-test.cliente.crear}")
	private String urlTest;
	
	@Autowired
    private WebTestClient webTestClient;
	
	
	@Test
    public void testCrearCliente() {
	   
	   try {
		ClienteRequest cliente = new ClienteRequest();
		   cliente.setNombre("Gabriela Caiza");
		   cliente.setGenero(GeneroTypeEnum.FEMENINO.getValue());
		   cliente.setEdad(35);
		   cliente.setIdentificacion("0924833056");
		   cliente.setDireccion("Via a Daule");
		   cliente.setTelefono("0992087507");
		   cliente.setContrasena("123456789");
		   cliente.setEstado(true);

		    webTestClient.post()
		        .uri(urlTest)
		        .bodyValue(cliente)
		        .exchange()
		        .expectStatus().isCreated()
		        .expectBody()
		        .jsonPath("$.id").isNotEmpty()
		        .jsonPath("$.nombre").isEqualTo("Gabriela Caiza");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
    }
	
}