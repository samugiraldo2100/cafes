package com.example.shifts.service;

import com.example.shifts.model.Turno;
import com.example.shifts.repository.TurnoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TurnoService {
    private final TurnoRepository repo;

    public TurnoService(TurnoRepository repo) { this.repo = repo; }

    public Flux<Turno> all() { return repo.findAll(); }
    public Mono<Turno> byId(Integer id) { return repo.findById(id); }
    public Flux<Turno> byEmpleadoId(Integer empleadoId) { return repo.findByEmpleadoId(empleadoId); }
    public Mono<Turno> create(Turno t) { return repo.save(t); }
    public Mono<Turno> update(Integer id, Turno t) {
        return repo.findById(id).flatMap(old -> repo.save(new Turno(id, t.fecha(), t.horaInicio(), t.horaFin(), t.empleadoId())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}

