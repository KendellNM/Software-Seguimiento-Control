package pe.edu.upeu.msusuarios.controller;

import jakarta.validation.Valid;
import pe.edu.upeu.msusuarios.domain.Secretaria;
import pe.edu.upeu.msusuarios.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/secretaria")
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;

    @GetMapping
    public ResponseEntity<List<Secretaria>> readAll() {
        try {
            List<Secretaria> secretarias = secretariaService.readAll();

            if (secretarias.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(secretarias, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Secretaria> create(@Valid @RequestBody Secretaria secretaria) {
        try {
            Secretaria secretariaCreated = secretariaService.create(secretaria);
            return new ResponseEntity<>(secretariaCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secretaria> getById(@PathVariable("id") Long id) {
        try {
            Secretaria secretaria = secretariaService.read(id).get();
            return new ResponseEntity<>(secretaria, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Secretaria> delete(@PathVariable("id") Long id) {
        try {
            secretariaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Secretaria secretaria) {

        Optional<Secretaria> secretariaOptional = secretariaService.read(id);
        if (secretariaOptional.isPresent()) {
            return new ResponseEntity<>(secretariaService.update(secretaria), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}