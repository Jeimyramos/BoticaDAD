package com.example.ms_cliente.dto;

import lombok.Data;

@Data
public class ClienteDto {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String ruc;
    private String direccion;
    private String correo;
    private String telefono;
}