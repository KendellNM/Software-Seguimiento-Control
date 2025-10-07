package pe.edu.pe.mspracticas.service;

import pe.edu.pe.mspracticas.domain.Pasos;

import java.util.List;
import java.util.Optional;

public interface PasosService {

    Pasos create(Pasos pasos);

    Pasos update(Pasos pasos);

    void delete(Long id);

    Optional<Pasos> read(Long id);

    List<Pasos> readAll();
}