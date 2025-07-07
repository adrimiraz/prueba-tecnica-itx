package com.prueba.prices.controller;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prices.application.service.PriceService;
import com.prueba.prices.domain.model.Price;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

	private final PriceService priceService;

    public PriceController(PriceService priceService) {
        this.priceService = priceService;
    }

    @GetMapping
    @Operation(summary = "Consulta de precio", description = "Devuelve el precio aplicable dado un producto, marca y fecha")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Precio encontrado"),
            @ApiResponse(responseCode = "404", description = "Precio no encontrado")
    })
    public Optional<Price> getPrice(
            @Parameter(description = "Fecha de aplicación", example = "2020-06-14T10:00:00")
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date,
            @Parameter(description = "ID del producto", example = "35455")
            @RequestParam Long productId,
            @Parameter(description = "ID de la marca", example = "1")
            @RequestParam Long brandId) {

        return priceService.getPrice(date, productId, brandId);
    }
	
}
