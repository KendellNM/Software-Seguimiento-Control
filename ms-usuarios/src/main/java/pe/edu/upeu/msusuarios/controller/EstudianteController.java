package pe.edu.upeu.msusuarios.controller;

import jakarta.validation.Valid;
import pe.edu.upeu.msusuarios.domain.Estudiante;
import pe.edu.upeu.msusuarios.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/estudiante")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @GetMapping
    public ResponseEntity<List<Estudiante>> readAll() {
        try {
            List<Estudiante> estudiantes = estudianteService.readAll();

            if (estudiantes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(estudiantes, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Estudiante> create(@Valid @RequestBody Estudiante estudiante) {
        try {
            Estudiante estudianteCreated = estudianteService.create(estudiante);
            return new ResponseEntity<>(estudianteCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> getById(@PathVariable("id") Long id) {
        try {
            Estudiante estudiante = estudianteService.read(id).get();
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Estudiante> delete(@PathVariable("id") Long id) {
        try {
            estudianteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Estudiante estudiante) {

        Optional<Estudiante> estudianteOptional = estudianteService.read(id);
        if (estudianteOptional.isPresent()) {
            return new ResponseEntity<>(estudianteService.update(estudiante), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}