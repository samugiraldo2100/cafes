package com.example.shifts.controller;

import com.example.shifts.controller.dto.TurnoRequests;
import com.example.shifts.model.Turno;
import com.example.shifts.service.TurnoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/turnos")
public class TurnoController {
    private final TurnoService service;

    public TurnoController(TurnoService service) { this.service = service; }

    @GetMapping
    public Flux<Turno> all(@RequestParam(required = false) Integer empleadoId) {
        if (empleadoId != null) {
            return service.byEmpleadoId(empleadoId);
        }
        return service.all();
    }

    @GetMapping("/{id}")
    public Mono<Turno> byId(@PathVariable Integer id) { return service.byId(id); }

    @PostMapping
    public Mono<Turno> create(@RequestBody @Valid TurnoRequests.Create req) {
        return service.create(new Turno(null, req.fecha(), req.horaInicio(), req.horaFin(), req.empleadoId()));
    }

    @PutMapping("/{id}")
    public Mono<Turno> update(@PathVariable Integer id, @RequestBody @Valid TurnoRequests.Update req) {
        return service.update(id, new Turno(null, req.fecha(), req.horaInicio(), req.horaFin(), req.empleadoId()));
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable Integer id) { return service.delete(id); }
}

