package com.transactional.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.transactional.entity.dto.response.MovimientoClienteResponse;
import com.transactional.exception.CustomErrorResponse;
import com.transactional.util.SwaggerConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = SwaggerConstants.REPORTE_CONTROLLER_TAG, description = SwaggerConstants.REPORTE_CONTROLLER__DESCRIPTION)
@RequestMapping("/reportes")
public interface IReporteController {

    @Operation(summary = "Report movements for client between range dates")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Report Generated"),
            @ApiResponse(responseCode = "404", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping
    public ResponseEntity<List<MovimientoClienteResponse>> getMovementsByClient(@RequestParam Long clienteId, @RequestParam String fechaDesde, @RequestParam String fechaHasta) throws CustomErrorResponse;
}