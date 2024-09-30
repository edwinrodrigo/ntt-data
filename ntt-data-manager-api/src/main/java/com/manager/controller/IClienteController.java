package com.manager.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.manager.entity.dto.request.ClienteRequest;
import com.manager.entity.dto.response.ClienteResponse;
import com.manager.exception.CustomErrorResponse;
import com.manager.util.SwaggerConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = SwaggerConstants.CLIENT_CONTROLLER_TAG, description = SwaggerConstants.CLIENT_CONTROLLER__DESCRIPTION)
@RequestMapping("/clientes")
public interface IClienteController {
	
	@PostMapping
    @Operation(summary = "Create a new Client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> create(@Valid @RequestBody ClienteRequest clienteRequest) throws CustomErrorResponse;
	
    @Operation(summary = "Get all clients")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found"),
            @ApiResponse(responseCode = "204", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<ClienteResponse>> getAll()  throws CustomErrorResponse;

    @Operation(summary = "Get for ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<ClienteResponse> getForId(@PathVariable Long id) throws ResponseStatusException;

    @Operation(summary = "Update for Id")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<ClienteResponse> updateForId(@PathVariable Long id,@RequestBody ClienteRequest clienteRequest) throws CustomErrorResponse ;

    @Operation(summary = "Delete for Id")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cliente deleted"),
            @ApiResponse(responseCode = "404", description = "Cliente not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> deleteForId(@PathVariable Long id) throws CustomErrorResponse;

}
