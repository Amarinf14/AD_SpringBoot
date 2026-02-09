package com.alberto.tareaspring.controller;

import com.alberto.tareaspring.model.Prestamos;
import com.alberto.tareaspring.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la API de gestión de préstamos de biblioteca.
 * Expone endpoints RESTful para realizar operaciones CRUD sobre los préstamos.
 *
 * @author Alberto Marín Fernández
 */
@RestController
@RequestMapping("/biblioteca")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    /**
     * Busca préstamos por DNI del usuario.
     *
     * @param dni DNI del usuario
     * @return lista de préstamos del usuario
     */
    @GetMapping("/dni/{dni}")
    private ResponseEntity<List<Prestamos>> buscarPorDNI(String dni) {
        return new ResponseEntity<>(bibliotecaService.buscarPorDNI(dni), HttpStatus.OK);
    }

    /**
     * Busca préstamos por ISBN del libro.
     *
     * @param isbn ISBN del libro
     * @return lista de préstamos del libro
     */
    @GetMapping("/isbn/{isbn}")
    private ResponseEntity<List<Prestamos>> buscarPorISBN(String isbn) {
        return new ResponseEntity<>(bibliotecaService.buscarPorISBN(isbn), HttpStatus.OK);
    }

    /**
     * Registra un nuevo préstamo en el sistema.
     *
     * @param prestamo datos del nuevo préstamo
     * @return préstamo guardado con ID autogenerado
     */
    @PostMapping
    public ResponseEntity<Prestamos> registrarPrestamo(Prestamos prestamo) {
        return new ResponseEntity<>(bibliotecaService.registrarPrestamo(prestamo), HttpStatus.CREATED);
    }

    /**
     * Elimina un préstamo por su ID.
     *
     * @param id ID del préstamo a eliminar
     * @return ResponseEntity vacío (HTTP 200)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(Integer id) {
        bibliotecaService.eliminarPrestamo(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
