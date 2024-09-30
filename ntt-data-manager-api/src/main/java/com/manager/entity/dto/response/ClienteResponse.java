package com.manager.entity.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteResponse extends PersonaResponse{

	@Schema(description = "User password", example = "Password123", requiredMode = Schema.RequiredMode.REQUIRED, type = "string", format = "password")
	private String contrasena;
	
	@Schema(description = "Estado", example = "true", type = "string", format = "string")
	private boolean estado;
	
}