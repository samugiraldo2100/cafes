package com.example.shifts.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("turnos")
public record Turno(
        @Id Integer id,
        String fecha,
        @Column("hora_inicio") String horaInicio,
        @Column("hora_fin") String horaFin,
        @Column("empleado_id") Integer empleadoId
) {}

