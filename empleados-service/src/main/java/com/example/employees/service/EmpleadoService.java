package com.example.employees.service;

import com.example.employees.model.Empleado;
import com.example.employees.repository.EmpleadoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class EmpleadoService {
    private final EmpleadoRepository repo;

    public EmpleadoService(EmpleadoRepository repo) {
        this.repo = repo;
    }

    public Flux<Empleado> findAll() { return repo.findAll(); }
    public Mono<Empleado> findById(Integer id) { return repo.findById(id); }
    public Mono<Empleado> create(Empleado e) { return repo.save(e); }
    public Mono<Empleado> update(Integer id, Empleado e) {
        return repo.findById(id)
            .flatMap(old -> repo.save(new Empleado(id, e.nombre(), e.apellido(), e.puesto(), e.telefono())));
    }
    public Mono<Void> delete(Integer id) { return repo.deleteById(id); }
}

