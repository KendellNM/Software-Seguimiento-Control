package pe.edu.pe.mspracticas.controller;

import jakarta.validation.Valid;
import pe.edu.pe.mspracticas.domain.Practicas;
import pe.edu.pe.mspracticas.service.PracticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/practicas")
public class PracticasController {

    @Autowired
    private PracticasService practicasService;

    @GetMapping
    public ResponseEntity<List<Practicas>> readAll() {
        try {
            List<Practicas> practicass = practicasService.readAll();

            if (practicass.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(practicass, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Practicas> create(@Valid @RequestBody Practicas practicas) {
        try {
            Practicas practicasCreated = practicasService.create(practicas);
            return new ResponseEntity<>(practicasCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Practicas> getById(@PathVariable("id") Long id) {
        try {
            Practicas practicas = practicasService.read(id).get();
            return new ResponseEntity<>(practicas, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Practicas> delete(@PathVariable("id") Long id) {
        try {
            practicasService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Practicas practicas) {

        Optional<Practicas> practicasOptional = practicasService.read(id);
        if (practicasOptional.isPresent()) {
            return new ResponseEntity<>(practicasService.update(practicas), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}