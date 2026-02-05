package com.spring.marin.Marin_guiada_Spring.repository;

import com.spring.marin.Marin_guiada_Spring.model.Peliculas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.repository.CrudRepository;

/**
 * Interfaz que accede a la base de datos.
 * Se comunica directamente con la base de datos usando JPA
 *
 * Parámetros de la interfaz JpaRepository:
 * - Peliculas: Entidad que representa la tabla de películas en la base de datos
 * - Long: Tipo de dato de la clave primaria (ID) de la entidad Peliculas
 *
 * Spring Data JPA generará automáticamente la consulta SQL correspondiente a cada función definida en esta interfaz, lo que facilita la interacción con la base de datos sin necesidad de escribir código SQL manualmente
 *
 * @author Alberto Marín Fernández
 */
public interface IPeliculaRepository extends JpaRepository<Peliculas, Long> {
    /*
    CrudRepository es una interfaz provista por Spring Data que ofrece métodos básicos para realizar operaciones CRUD en la base de datos.
    Para funciones más avanzadas, existe JpaRepository, que extiende CrudRepository
     */

    // Encontrar películas por género
    List<Peliculas> findByGenero(String genero);

    // Encontrar películas por director
    List<Peliculas> findByDirector(String director);

    // Encontrar películas por año
    List<Peliculas> findByAño(Integer año);

    // Encontrar películas cuyo título contenga una palabra clave (búsqueda parcial)
    List<Peliculas> findByTituloContaining(String keyword);
}
