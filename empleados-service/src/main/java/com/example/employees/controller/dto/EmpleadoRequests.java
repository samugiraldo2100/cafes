package com.example.employees.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class EmpleadoRequests {
    public record Create(@NotBlank String nombre,
                        @NotBlank String apellido,
                        @NotBlank String puesto,
                        String telefono) {}
    public record Update(@NotBlank String nombre,
                        @NotBlank String apellido,
                        @NotBlank String puesto,
                        String telefono) {}
}



