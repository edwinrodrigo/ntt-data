package com.manager.test.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ClienteLocaControllerlTest {
	
    @Autowired
    private MockMvc mockMvc;
    

	
	 @Test
	 void when_call_save_client_then_return_201() throws Exception {
		 
	        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
	                        .content("""
	                                {
									    "nombre": "Gabriela Caiza",
									    "genero": "F",
									    "edad": 35,
									    "identificacion": "0924833056",
									    "direccion": "Via a Daule",
									    "telefono": "0992087507",
									    "contrasena": "1",
									    "estado": true
									}
	                                """)
	                        .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isCreated());
	        
	  }
	
	 
	 @Test
	 void when_call_save_client_without_identification_then_return_400() throws Exception {
		 
	        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
	                        .content("""
	                                {
									    "nombre": "Gabriela Caiza",
									    "genero": "F",
									    "edad": 35,
									    "direccion": "Via a Daule",
									    "telefono": "0992087507",
									    "contrasena": "1",
									    "estado": true
									}
	                                """)
	                        .contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isBadRequest());
	        
	  }
	 
	 @Test
     void get_all_users_then_return_200() throws Exception {
		 
        mockMvc.perform(MockMvcRequestBuilders.get("/clientes"))
                .andExpect(MockMvcResultMatchers.status().isOk());
        
     }
}
