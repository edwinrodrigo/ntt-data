package com.manager.entity.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PersonaRequest {

	 private Long id;
	 
	 @NotNull(message = "El nombre no puede ser nulo")
	 @Schema(description = "Nombre", example = "Eduardo Perez", type = "string", format = "string", requiredMode = Schema.RequiredMode.REQUIRED)
	 private String nombre;
	 
	 @Schema(description = "Genero", example = "M", type = "string", format = "string", requiredMode = Schema.RequiredMode.REQUIRED)
	 private String genero;
	 
	 @Schema(description = "Edad", example = "25", type = "integer", format = "integer", requiredMode = Schema.RequiredMode.REQUIRED)
	 private Integer edad;
	 
	 @NotNull(message = "La identificacion no puede ser nula")
	 @Schema(description = "Identificacion", example = "0912345678", type = "string", format = "string", requiredMode = Schema.RequiredMode.REQUIRED)
	 private String identificacion;
	 
	 @NotNull(message = "La direccion no puede ser nula")
	 @Schema(description = "Direccion", example = "Guayaquil  9 de Octubre y 310 Malecon ", type = "string", format = "string", requiredMode = Schema.RequiredMode.REQUIRED)
	 private String direccion;
	 
	 @Schema(description = "Telefono", example = "+593992087507", type = "string", format = "string", requiredMode = Schema.RequiredMode.REQUIRED)
	 private String telefono;
	
}
