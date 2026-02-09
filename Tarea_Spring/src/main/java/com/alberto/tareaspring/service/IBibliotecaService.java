package com.alberto.tareaspring.service;

import com.alberto.tareaspring.model.Prestamos;

import java.util.List;

/**
 * Interfaz de la capa de servicio para la gestión de préstamos de biblioteca.
 * Define los métodos de negocio que gestionan las operaciones CRUD y consultas específicas
 * sobre los préstamos registrados en el sistema.
 *
 * Esta interfaz actúa como contrato entre la capa de controlador (REST API) y
 * la capa de persistencia (repositorio), encapsulando la lógica de negocio.
 *
 * @author Alberto Marín Fernández
 */
public interface IBibliotecaService {

    /**
     * Busca todos los préstamos registrados en el sistema.
     *
     * @return lista de todos los préstamos
     */
    List<Prestamos> findAll();

    /**
     * Busca todos los préstamos asociados a un usuario específico mediante su DNI.
     *
     * @param dni el DNI del usuario
     * @return lista de préstamos correspondientes a todos los
     *         préstamos realizados por el usuario
     */
    List<Prestamos> buscarPorDNI(String dni);

    /**
     * Busca todos los préstamos realizados de un libro específico mediante su ISBN.
     *
     * @param isbn el ISBN del libro
     * @return lista de préstamos correspondientes a todos los
     *         préstamos del libro solicitado
     */
    List<Prestamos> buscarPorISBN(String isbn);

    /**
     * Registra un nuevo préstamo en el sistema.
     *
     * @param prestamo préstamo con los datos del nuevo préstamo
     *                 (DNI, ISBN, fecha de préstamo obligatorias)
     * @return el préstamo guardado con su ID autogenerado
     */
    Prestamos registrarPrestamo(Prestamos prestamo);

    /**
     * Elimina un préstamo específico del sistema por su identificador único.
     *
     * @param id el ID del préstamo a eliminar
     */
    void eliminarPrestamo(Integer id);
}
