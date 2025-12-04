package com.example.shifts.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class TurnoRequests {
    public record Create(@NotBlank String fecha,
                         @NotBlank String horaInicio,
                         @NotBlank String horaFin,
                         Integer empleadoId) {}
    public record Update(@NotBlank String fecha,
                         @NotBlank String horaInicio,
                         @NotBlank String horaFin,
                         Integer empleadoId) {}
}

