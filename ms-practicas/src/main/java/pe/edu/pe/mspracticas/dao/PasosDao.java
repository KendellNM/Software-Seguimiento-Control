package pe.edu.pe.mspracticas.dao;
import pe.edu.pe.mspracticas.domain.Pasos;

import java.util.List;
import java.util.Optional;

public interface PasosDao{
    Pasos create(Pasos pasos);
    Pasos update(Pasos pasos);
    void delete(Long id);
    Optional<Pasos> read(Long id);
    List<Pasos> readAll();
}