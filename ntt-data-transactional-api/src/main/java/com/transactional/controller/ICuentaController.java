package com.transactional.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.transactional.entity.dto.request.CuentaRequest;
import com.transactional.entity.dto.response.CuentaResponse;
import com.transactional.exception.CustomErrorResponse;
import com.transactional.util.SwaggerConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = SwaggerConstants.CUENTA_CONTROLLER_TAG, description = SwaggerConstants.CUENTA_CONTROLLER__DESCRIPTION)
@RequestMapping("/cuentas")
public interface ICuentaController {
	
	@PostMapping
    @Operation(summary = "Create a new Amount")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Amount created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> create(@Valid @RequestBody CuentaRequest CuentaRequest) throws CustomErrorResponse;
	
    @Operation(summary = "Get all Amounts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Amount found"),
            @ApiResponse(responseCode = "204", description = "Amount not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<CuentaResponse>> getAll()  throws CustomErrorResponse;

    @Operation(summary = "Get for ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Amount found"),
            @ApiResponse(responseCode = "404", description = "Amount not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> getForId(@PathVariable Long id) throws Exception;

    @Operation(summary = "Update for Id")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Amount found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<CuentaResponse> updateForId(@PathVariable Long id,@RequestBody CuentaRequest cuentaRequest) throws CustomErrorResponse ;

    @Operation(summary = "Delete for Id")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Amount deleted"),
            @ApiResponse(responseCode = "404", description = "Amount not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> deleteForId(@PathVariable Long id) throws CustomErrorResponse;

}
