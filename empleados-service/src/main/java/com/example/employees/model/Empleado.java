package com.example.employees.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("empleados")
public record Empleado(
        @Id Integer id,
        String nombre,
        String apellido,
        String puesto,
        String telefono
) {}

