package pe.edu.pe.mspracticas.controller;

import jakarta.validation.Valid;
import pe.edu.pe.mspracticas.domain.Pasos;
import pe.edu.pe.mspracticas.service.PasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/pasos")
public class PasosController {

    @Autowired
    private PasosService pasosService;

    @GetMapping
    public ResponseEntity<List<Pasos>> readAll() {
        try {
            List<Pasos> pasoss = pasosService.readAll();

            if (pasoss.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pasoss, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Pasos> create(@Valid @RequestBody Pasos pasos) {
        try {
            Pasos pasosCreated = pasosService.create(pasos);
            return new ResponseEntity<>(pasosCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pasos> getById(@PathVariable("id") Long id) {
        try {
            Pasos pasos = pasosService.read(id).get();
            return new ResponseEntity<>(pasos, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pasos> delete(@PathVariable("id") Long id) {
        try {
            pasosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Pasos pasos) {

        Optional<Pasos> pasosOptional = pasosService.read(id);
        if (pasosOptional.isPresent()) {
            return new ResponseEntity<>(pasosService.update(pasos), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}