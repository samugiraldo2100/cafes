package com.example.employees.controller;

import com.example.employees.controller.dto.EmpleadoRequests;
import com.example.employees.model.Empleado;
import com.example.employees.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) { this.service = service; }

    @GetMapping
    public Flux<Empleado> all() { return service.findAll(); }

    @GetMapping("/{id}")
    public Mono<Empleado> byId(@PathVariable Integer id) { return service.findById(id); }

    @PostMapping
    public Mono<Empleado> create(@RequestBody @Valid EmpleadoRequests.Create req) {
        return service.create(new Empleado(null, req.nombre(), req.apellido(), req.puesto(), req.telefono()));
    }

    @PutMapping("/{id}")
    public Mono<Empleado> update(@PathVariable Integer id, @RequestBody @Valid EmpleadoRequests.Update req) {
        return service.update(id, new Empleado(null, req.nombre(), req.apellido(), req.puesto(), req.telefono()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}


