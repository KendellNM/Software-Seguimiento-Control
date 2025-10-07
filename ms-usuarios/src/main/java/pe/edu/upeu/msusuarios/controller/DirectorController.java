package pe.edu.upeu.msusuarios.controller;

import jakarta.validation.Valid;
import pe.edu.upeu.msusuarios.domain.Director;
import pe.edu.upeu.msusuarios.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/director")
public class DirectorController {

    @Autowired
    private DirectorService directorService;

    @GetMapping
    public ResponseEntity<List<Director>> readAll() {
        try {
            List<Director> directors = directorService.readAll();

            if (directors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(directors, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Director> create(@Valid @RequestBody Director director) {
        try {
            Director directorCreated = directorService.create(director);
            return new ResponseEntity<>(directorCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getById(@PathVariable("id") Long id) {
        try {
            Director director = directorService.read(id).get();
            return new ResponseEntity<>(director, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Director> delete(@PathVariable("id") Long id) {
        try {
            directorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Director director) {

        Optional<Director> directorOptional = directorService.read(id);
        if (directorOptional.isPresent()) {
            return new ResponseEntity<>(directorService.update(director), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}