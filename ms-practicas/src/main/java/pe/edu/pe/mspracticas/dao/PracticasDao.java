package pe.edu.pe.mspracticas.dao;
import pe.edu.pe.mspracticas.domain.Practicas;

import java.util.List;
import java.util.Optional;

public interface PracticasDao{
    Practicas create(Practicas practicas);
    Practicas update(Practicas practicas);
    void delete(Long id);
    Optional<Practicas> read(Long id);
    List<Practicas> readAll();
}