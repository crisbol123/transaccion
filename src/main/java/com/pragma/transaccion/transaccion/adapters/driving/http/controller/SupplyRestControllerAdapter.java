package com.pragma.transaccion.transaccion.adapters.driving.http.controller;

import com.pragma.transaccion.transaccion.adapters.driving.http.dto.supply.request.AddSupplyRequest;
import com.pragma.transaccion.transaccion.adapters.driving.http.handlers.SupplyHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supply")
@RequiredArgsConstructor
public class SupplyRestControllerAdapter {
    private final SupplyHandler supplyHandler;

    @Operation(summary = "Create a new supply")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Supply created",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid input",
                    content = @Content)
    })
    @PostMapping("/create")
    public ResponseEntity<Void> saveArticle(@RequestBody @Valid AddSupplyRequest addSupplyRequest) {
        supplyHandler.saveSupply(addSupplyRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}