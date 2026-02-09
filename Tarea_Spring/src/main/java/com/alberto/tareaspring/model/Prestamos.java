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
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor ID se genera automáticamente
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

    public String getDniUsuario() {
        return this.dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public String getTituloLibro() {
        return this.tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public LocalDate getFechaPrestamo() {
        return this.fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaDevolucion() {
        return this.fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
