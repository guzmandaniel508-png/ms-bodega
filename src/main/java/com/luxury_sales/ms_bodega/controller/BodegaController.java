package com.luxury_sales.ms_bodega.controller;

import com.luxury_sales.ms_bodega.dto.BodegaRequestDTO;
import com.luxury_sales.ms_bodega.dto.BodegaResponseDTO;
import com.luxury_sales.ms_bodega.service.BodegaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodegas")
@RequiredArgsConstructor
@Tag (name = "bodegas", description = "operaciones relacionadas con bodegas")


public class BodegaController {

    private final BodegaService bodegaService;

    @GetMapping
    @Operation (summary = "obtener todo lo que esta en bodegas", description = "obtiene una lista de todo lo que esta guardado en bodegas")
    public ResponseEntity<List<BodegaResponseDTO>> obtenerTodas() {
        return ResponseEntity.ok(bodegaService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<BodegaResponseDTO> guardar(@RequestBody BodegaRequestDTO requestDTO) {
        BodegaResponseDTO nuevaBodega = bodegaService.guardar(requestDTO);
        return new ResponseEntity<>(nuevaBodega, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BodegaResponseDTO> actualizar(
            @PathVariable Long id,
            @RequestBody BodegaRequestDTO requestDTO) {
        return ResponseEntity.ok(bodegaService.actualizar(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        bodegaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}