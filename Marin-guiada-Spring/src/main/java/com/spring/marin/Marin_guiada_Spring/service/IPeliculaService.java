package com.spring.marin.Marin_guiada_Spring.service;

import com.spring.marin.Marin_guiada_Spring.model.Peliculas;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz que define la lógica de negocio de la aplicación.
 * Actúa como capa intermedia entre el controlador y el repositorio, gestionando
 * las operaciones necesarias antes de persistir o recuperar datos
 *
 * @author Alberto Marín Fernández
 */
public interface IPeliculaService {

    Iterable<Peliculas> obtenerTodas();

    Peliculas guardarPelicula(Peliculas pelicula);

    Optional<Peliculas> obtenerPorId(Long id);

    void eliminarPelicula(Long id);

    List<Peliculas> buscarPorGenero(String genero);

    List<Peliculas> buscarPorDirector(String director);

    List<Peliculas> buscarPorTitulo(String keyword);
}
