package com.example.ms_cliente.controller;

import com.example.ms_cliente.dto.ClienteDto;
import com.example.ms_cliente.dto.DniResponse;
import com.example.ms_cliente.dto.RucResponse;
import com.example.ms_cliente.dto.ResponseDto;
import com.example.ms_cliente.service.ClienteService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "clienteService", fallbackMethod = "fallbackGetById")
    public ResponseEntity<ResponseDto<ClienteDto>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    public ResponseEntity<ResponseDto<ClienteDto>> fallbackGetById(Long id, Throwable ex) {
        return ResponseEntity.ok(new ResponseDto<>(null, "Servicio no disponible, intenta más tarde"));
    }

    @PostMapping
    public ResponseEntity<ResponseDto<ClienteDto>> create(@RequestBody ClienteDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @PostMapping("/dni")
    public ResponseEntity<ResponseDto<DniResponse>> submitByDni(@RequestBody DniResponse dni) {
        // Recibe datos ingresados por teclado (JSON)
        return ResponseEntity.ok(new ResponseDto<>(dni, "Datos recibidos por DNI"));
    }

    @PostMapping("/ruc")
    public ResponseEntity<ResponseDto<RucResponse>> submitByRuc(@RequestBody RucResponse ruc) {
        // Recibe datos ingresados por teclado (JSON)
        return ResponseEntity.ok(new ResponseDto<>(ruc, "Datos recibidos por RUC"));
    }
}