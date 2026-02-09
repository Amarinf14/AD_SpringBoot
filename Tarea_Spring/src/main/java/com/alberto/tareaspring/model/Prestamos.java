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
    @Column(name = "DNI_Usuario")
    private String dniUsuario;

    @Id
    @Column(name = "TituloLibro")
    private String tituloLibro;

    @Id
    @Column(name = "FechaPrestamo")
    private LocalDate fechaPrestamo;

    @Column(name = "FechaDevolucion")
    private LocalDate fechaDevolucion;

    @Column(name = "ISBN")
    private String isbn;
}
