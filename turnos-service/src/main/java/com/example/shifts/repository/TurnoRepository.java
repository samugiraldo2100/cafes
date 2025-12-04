package com.example.shifts.repository;

import com.example.shifts.model.Turno;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TurnoRepository extends ReactiveCrudRepository<Turno, Integer> {
    Flux<Turno> findByEmpleadoId(Integer empleadoId);
}

