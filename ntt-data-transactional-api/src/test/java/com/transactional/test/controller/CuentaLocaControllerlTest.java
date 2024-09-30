package com.transactional.test.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.testcontainers.containers.PostgreSQLContainer;

import com.transactional.test.integration.CuentaIntegrationTest;

@SpringBootTest
@AutoConfigureMockMvc
public class CuentaLocaControllerlTest {
	
	Logger logger = LoggerFactory.getLogger(CuentaIntegrationTest.class);
	
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:14-alpine")
            .withDatabaseName("ntt-data")
            .withUsername("postgres")
            .withPassword("postgres");
    
    @BeforeAll
    static void setup() {
        postgres.start();
    }
    
    
    @DynamicPropertySource
    static void postgresqlProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
	
    @Autowired
    private MockMvc mockMvc;
	
	 @Test
	 void when_call_save_amount_then_return_201() {
		 
	        try {
				mockMvc.perform(MockMvcRequestBuilders.post("/cuentas")
				                .content("""
				                        {
										    "tipoCuenta": "A",
										    "numeroCuenta": "111134",
										    "saldoInicial": 2000,
										    "idCliente": 2,
										    "estado": true
										}
				                        """)
				                .contentType(MediaType.APPLICATION_JSON))
				        .andExpect(MockMvcResultMatchers.status().isCreated());
				
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
	        
	  }
	
	 
	 @Test
	 void when_call_save_amount_without_identification_then_return_400() throws Exception {
		 
	        mockMvc.perform(MockMvcRequestBuilders.post("/cuentas")
	                        .content("""
	                                 {
									    "tipoCuenta": "A",
									    "saldoInicial": 2000,
									    "idCliente": 2,
									    "estado": true
									}
	                                """)
	                        .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isBadRequest());
	        
	  }
	 
	 @Test
     void get_all_amounts_then_return_200() throws Exception {
		 
        mockMvc.perform(MockMvcRequestBuilders.get("/cuentas"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        
     }
}
