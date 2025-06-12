package com.example.ms_cliente.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "clientes")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private String ruc;
    private String direccion;
    private String correo;
    private String telefono;
}