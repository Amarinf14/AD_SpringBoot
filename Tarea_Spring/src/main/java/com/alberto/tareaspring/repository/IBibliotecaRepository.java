package com.alberto.tareaspring.repository;

import com.alberto.tareaspring.model.Prestamos;

import java.util.List;

/**
 * Interfaz que accede a la base de datos.
 * Se comunica directamente con la base de datos usando JPA
 *
 * Spring Data JPA generará automáticamente la consulta SQL correspondiente a cada función definida en esta interfaz, lo que facilita la interacción con la base de datos sin necesidad de escribir código SQL manualmente
 *
 * @author Alberto Marín Fernández
 */
public interface IBibliotecaRepository {

    /**
     * Busca todos los préstamos asociados a un usuario específico mediante su DNI.
     *
     * @param dni el DNI del usuario
     * @return lista de préstamos correspondientes al usuario
     */
    List<Prestamos> buscarPorDNI(String dni);

    /**
     * Busca todos los préstamos de un libro específico mediante su ISBN.
     *
     * @param isbn el ISBN del libro
     * @return lista de préstamos del libro solicitado
     */
    List<Prestamos> buscarPorISBN(String isbn);
}
