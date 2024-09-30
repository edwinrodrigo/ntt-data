package com.manager.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonaResponse {
	 private Long id;
	 private String nombre;
	 private String genero;
	 private Integer edad;
	 private String identificacion;
	 private String direccion;
	 private String telefono;
	
}
