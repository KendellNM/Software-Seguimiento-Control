package pe.edu.upeu.msusuarios.controller;

import jakarta.validation.Valid;
import pe.edu.upeu.msusuarios.domain.Coordinador;
import pe.edu.upeu.msusuarios.service.CoordinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/coordinador")
public class CoordinadorController {

    @Autowired
    private CoordinadorService coordinadorService;

    @GetMapping
    public ResponseEntity<List<Coordinador>> readAll() {
        try {
            List<Coordinador> coordinadors = coordinadorService.readAll();

            if (coordinadors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(coordinadors, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Coordinador> create(@Valid @RequestBody Coordinador coordinador) {
        try {
            Coordinador coordinadorCreated = coordinadorService.create(coordinador);
            return new ResponseEntity<>(coordinadorCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coordinador> getById(@PathVariable("id") Long id) {
        try {
            Coordinador coordinador = coordinadorService.read(id).get();
            return new ResponseEntity<>(coordinador, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Coordinador> delete(@PathVariable("id") Long id) {
        try {
            coordinadorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Coordinador coordinador) {

        Optional<Coordinador> coordinadorOptional = coordinadorService.read(id);
        if (coordinadorOptional.isPresent()) {
            return new ResponseEntity<>(coordinadorService.update(coordinador), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}