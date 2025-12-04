package com.example.employees.repository;

import com.example.employees.model.Empleado;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmpleadoRepository extends ReactiveCrudRepository<Empleado, Integer> {
}

