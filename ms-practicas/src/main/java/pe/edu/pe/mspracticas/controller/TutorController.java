package pe.edu.pe.mspracticas.controller;

import jakarta.validation.Valid;
import pe.edu.pe.mspracticas.domain.Tutor;
import pe.edu.pe.mspracticas.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("api/tutor")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping
    public ResponseEntity<List<Tutor>> readAll() {
        try {
            List<Tutor> tutors = tutorService.readAll();

            if (tutors.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(tutors, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping
    public ResponseEntity<Tutor> create(@Valid @RequestBody Tutor tutor) {
        try {
            Tutor tutorCreated = tutorService.create(tutor);
            return new ResponseEntity<>(tutorCreated, HttpStatus.CREATED);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutor> getById(@PathVariable("id") Long id) {
        try {
            Tutor tutor = tutorService.read(id).get();
            return new ResponseEntity<>(tutor, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Tutor> delete(@PathVariable("id") Long id) {
        try {
            tutorService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @Valid @RequestBody Tutor tutor) {

        Optional<Tutor> tutorOptional = tutorService.read(id);
        if (tutorOptional.isPresent()) {
            return new ResponseEntity<>(tutorService.update(tutor), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}