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
@RequestMapping("/api/prestamos")
public class BibliotecaController {

    @Autowired
    private BibliotecaService bibliotecaService;

    /**
     * Obtiene todos los préstamos registrados en el sistema.
     *
     * @return lista de todos los préstamos
     */
    @GetMapping
    private ResponseEntity<List<Prestamos>> findAll() {
        List<Prestamos> lista = bibliotecaService.findAll();
        // Si la lista está vacía, devolvmos un HTTP 204 No Content
        if (lista.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(lista); // 200 Ok
    }

    /**
     * Busca préstamos por DNI del usuario.
     *
     * @param dni DNI del usuario
     * @return lista de préstamos del usuario
     */
    @GetMapping("/dni/{dni}")
    private ResponseEntity<List<Prestamos>> buscarPorDNI(@PathVariable String dni) {
        List<Prestamos> resultados = bibliotecaService.buscarPorDNI(dni);
        if (resultados.isEmpty()) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        return ResponseEntity.ok(resultados);
    }

    /**
     * Busca préstamos por ISBN del libro.
     *
     * @param isbn ISBN del libro
     * @return lista de préstamos del libro
     */
    @GetMapping("/isbn/{isbn}")
    private ResponseEntity<List<Prestamos>> buscarPorISBN(@PathVariable String isbn) {
        List<Prestamos> resultados = bibliotecaService.buscarPorISBN(isbn);
        if (resultados.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(resultados);
    }

    /**
     * Registra un nuevo préstamo en el sistema.
     *
     * @param prestamo datos del nuevo préstamo
     * @return préstamo guardado con ID autogenerado
     */
    @PostMapping
    public ResponseEntity<Prestamos> registrarPrestamo(@RequestBody Prestamos prestamo) {
        try {
            Prestamos nuevo = bibliotecaService.registrarPrestamo(prestamo);
            // 201 Created es el estándar tras un POST exitoso
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (Exception e) {
            // 400 Bad Request si los datos enviados no son válidos
            return ResponseEntity.badRequest().build();
        }
    }

    /**
     * Elimina un préstamo por su ID.
     *
     * @param id ID del préstamo a eliminar
     * @return ResponseEntity vacío (HTTP 200)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPrestamo(@PathVariable Integer id) {
        try {
            bibliotecaService.eliminarPrestamo(id);
            // 204 No Content es el estándar para DELETE cuando no devuelves cuerpo
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
