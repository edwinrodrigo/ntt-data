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

import com.transactional.entity.dto.request.MovimientoRequest;
import com.transactional.entity.dto.response.MovimientoResponse;
import com.transactional.exception.CustomErrorResponse;
import com.transactional.util.SwaggerConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name = SwaggerConstants.MOVIMIENTO_CONTROLLER_TAG, description = SwaggerConstants.MOVIMIENTO_CONTROLLER__DESCRIPTION)
@RequestMapping("/movimientos")
public interface IMovimientoController {

	@PostMapping
    @Operation(summary = "Create a new Movement")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movement created"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<?> create(@Valid @RequestBody MovimientoRequest MovimientoRequest) throws CustomErrorResponse;
	
    @Operation(summary = "Get all Movements")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movement found"),
            @ApiResponse(responseCode = "204", description = "Movement not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    ResponseEntity<List<MovimientoResponse>> getAll()  throws CustomErrorResponse;

    @Operation(summary = "Get for ID")
    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movement found"),
            @ApiResponse(responseCode = "404", description = "Movement not found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<MovimientoResponse> getForId(@PathVariable String id) throws CustomErrorResponse;

    @Operation(summary = "Update for Id")
    @PutMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movement found"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<MovimientoResponse> updateForId(@PathVariable String id,@RequestBody MovimientoRequest movimientoRequest) throws CustomErrorResponse ;

    @Operation(summary = "Delete for Id")
    @DeleteMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movement deleted"),
            @ApiResponse(responseCode = "404", description = "Movement not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    ResponseEntity<Void> deleteForId(@PathVariable String id) throws CustomErrorResponse;
	
}