package pe.edu.upeu.msusuarios.controller;

import jakarta.validation.Valid;
import pe.edu.upeu.msusuarios.domain.Persona;
import pe.edu.upeu.msusuarios.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<Persona>> readAll() {
        try {
            List<Persona> personas = personaService.readAll();

            if (personas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(personas, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Persona> create(@Valid @RequestBody Persona persona) {
        try {
            Persona personaCreated = personaService.create(persona);
            return new ResponseEntity<>(personaCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> getById(@PathVariable("id") Long id) {
        try {
            Persona persona = personaService.read(id).get();
            return new ResponseEntity<>(persona, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Persona> delete(@PathVariable("id") Long id) {
        try {
            personaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Persona persona) {

        Optional<Persona> personaOptional = personaService.read(id);
        if (personaOptional.isPresent()) {
            return new ResponseEntity<>(personaService.update(persona), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}