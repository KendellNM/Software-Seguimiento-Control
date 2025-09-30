package pe.edu.pe.mspracticas.service;

import pe.edu.pe.mspracticas.domain.Practicas;
import pe.edu.pe.mspracticas.exception.PracticaActivaException;

import java.util.List;
import java.util.Optional;

public interface PracticasService {

    Practicas create(Practicas practicas);

    Practicas update(Practicas practicas);

    void delete(Long id);

    Optional<Practicas> read(Long id);

    List<Practicas> readAll();

    void practicaActiva(Long id) throws PracticaActivaException;
}