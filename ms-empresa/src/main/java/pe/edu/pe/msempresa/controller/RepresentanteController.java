package pe.edu.pe.msempresa.controller;

import jakarta.validation.Valid;
import pe.edu.pe.msempresa.domain.Representante;
import pe.edu.pe.msempresa.service.RepresentanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/representante")
public class RepresentanteController {

    @Autowired
    private RepresentanteService representanteService;

    @GetMapping
    public ResponseEntity<List<Representante>> readAll() {
        try {
            List<Representante> representantes = representanteService.readAll();

            if (representantes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(representantes, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Representante> create(@Valid @RequestBody Representante representante) {
        try {
            Representante representanteCreated = representanteService.create(representante);
            return new ResponseEntity<>(representanteCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Representante> getById(@PathVariable("id") Long id) {
        try {
            Representante representante = representanteService.read(id).get();
            return new ResponseEntity<>(representante, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Representante> delete(@PathVariable("id") Long id) {
        try {
            representanteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Representante representante) {

        Optional<Representante> representanteOptional = representanteService.read(id);
        if (representanteOptional.isPresent()) {
            return new ResponseEntity<>(representanteService.update(representante), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}