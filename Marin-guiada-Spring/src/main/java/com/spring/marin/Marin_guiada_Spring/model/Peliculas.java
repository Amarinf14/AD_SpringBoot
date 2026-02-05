package com.spring.marin.Marin_guiada_Spring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "peliculas")
@Getter @Setter @ToString
public class Peliculas {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Valor ID se genera automáticamente
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "director")
    private String director;

    @Column(name = "genero")
    private String genero;

    @Column(name = "año")
    private Integer año;
}
