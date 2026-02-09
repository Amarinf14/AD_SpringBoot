package com.alberto.tareaspring.service;

import com.alberto.tareaspring.model.Prestamos;
import com.alberto.tareaspring.repository.IBibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase de servicio para gestionar la lógica de negocio relacionada con las películas.
 * Esta clase decide lo que hacer con los datos antes de guardarlos, actualizarlos o eliminarlos en la base de datos.
 *
 * Recibe llamadas desde el Controller y se comunica con el Repository para realizar las operaciones necesarias en la base de datos.
 *
 * @author Alberto Marín Fernández
 */
@Service
public class BibliotecaService implements IBibliotecaService {

    @Autowired
    private IBibliotecaRepository bibliotecaRepository;

    /**
     * Busca todos los préstamos asociados a un usuario específico mediante su DNI.
     *
     * @param dni el DNI del usuario
     * @return lista de préstamos correspondientes a todos los
     * préstamos realizados por el usuario
     */
    @Override
    public List<Prestamos> buscarPorDNI(String dni) {
        return bibliotecaRepository.findByDNI(dni);
    }

    /**
     * Busca todos los préstamos realizados de un libro específico mediante su ISBN.
     *
     * @param isbn el ISBN del libro
     * @return lista de préstamos correspondientes a todos los
     * préstamos del libro solicitado
     */
    @Override
    public List<Prestamos> buscarPorISBN(String isbn) {
        return bibliotecaRepository.findByISBN(isbn);
    }

    /**
     * Elimina un préstamo específico del sistema por su identificador único.
     *
     * @param id el ID del préstamo a eliminar
     */
    @Override
    public void eliminarPrestamo(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("El ID del préstamo debe ser un número válido");
        }

        if (!bibliotecaRepository.existsById(id)) {
            throw new IllegalArgumentException("El préstamo con ID " + id + " no existe");
        }

        bibliotecaRepository.deleteById(id);
    }

    /**
     * Registra un nuevo préstamo en el sistema.
     *
     * @param prestamo préstamo con los datos del nuevo préstamo
     *                 (DNI, ISBN, fecha de préstamo obligatorias)
     * @return el préstamo guardado con su ID autogenerado
     */
    @Override
    public Prestamos registrarPrestamo(Prestamos prestamo) {
        return bibliotecaRepository.save(prestamo);
    }
}
