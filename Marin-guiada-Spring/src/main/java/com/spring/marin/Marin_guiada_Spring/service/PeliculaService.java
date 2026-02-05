package com.spring.marin.Marin_guiada_Spring.service;


import com.spring.marin.Marin_guiada_Spring.model.Peliculas;
import com.spring.marin.Marin_guiada_Spring.repository.IPeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

/**
 * Clase de servicio para gestionar la lógica de negocio relacionada con las películas.
 * Esta clase decide lo que hacer con los datos antes de guardarlos, actualizarlos o eliminarlos en la base de datos.
 *
 * Recibe llamadas desde el Controller y se comunica con el Repository para realizar las operaciones necesarias en la base de datos.
 *
 * @author Alberto Marín Fernández
 */
public class PeliculaService implements IPeliculaService {

    // Inyección de dependencia del repositorio para acceder a la base de datos
    @Autowired
    private IPeliculaRepository peliculaRepository;

    /**
     * Obtiene todas las películas disponibles en la base de datos.
     *
     * @return iterable con todas las películas
     */
    @Override
    public Iterable<Peliculas> obtenerTodas() {
        System.out.println("---PELICULASERVICE----");
        System.out.println("" + peliculaRepository.findAll());

        return peliculaRepository.findAll();
    }

    /**
     * Guarda o actualiza una película en la base de datos.
     *
     * @param pelicula película a persistir
     * @return película guardada con ID asignado
     */
    @Override
    public Peliculas guardarPelicula(Peliculas pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public Optional<Peliculas> obtenerPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public void eliminarPelicula(Long id) {

    }

    @Override
    public List<Peliculas> buscarPorGenero(String genero) {
        return List.of();
    }

    @Override
    public List<Peliculas> buscarPorDirector(String director) {
        return List.of();
    }

    @Override
    public List<Peliculas> buscarPorTitulo(String keyword) {
        return List.of();
    }
}
