package com.manager.entity.dto.request;

import org.hibernate.annotations.Check;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClienteRequest extends PersonaRequest{

	@NotNull(message = "Ingrese el campo")
	@Schema(description = "User password", example = "Password123", requiredMode = Schema.RequiredMode.REQUIRED, type = "string", format = "password")
	@JsonFormat(pattern = "${custom.password.pattern}")
    @Check(constraints = "${custom.password.pattern}")
	private String contrasena;
	
	@Schema(description = "Estado", example = "true", type = "string", format = "string")
	private boolean estado;
	
}