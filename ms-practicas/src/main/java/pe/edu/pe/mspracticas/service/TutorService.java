package pe.edu.pe.mspracticas.service;

import pe.edu.pe.mspracticas.domain.Tutor;

import java.util.List;
import java.util.Optional;

public interface TutorService {

    Tutor create(Tutor tutor);

    Tutor update(Tutor tutor);

    void delete(Long id);

    Optional<Tutor> read(Long id);

    List<Tutor> readAll();
}