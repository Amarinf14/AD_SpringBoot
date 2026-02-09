package com.alberto.tareaspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "prestamos")
@Getter @Setter @ToString
public class Prestamos {
    @Id
    @Column(name = "IDPrestamo")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor ID se genera automáticamente
    private Integer idPrestamo;

    @Column(name = "DNIUsuario")
    private String dniUsuario;

    @Column(name = "ISBNLibro")
    private String isbnLibro;

    @Column(name = "FechaPrestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "FechaDevolucion")
    private LocalDate fechaDevolucion;
}
