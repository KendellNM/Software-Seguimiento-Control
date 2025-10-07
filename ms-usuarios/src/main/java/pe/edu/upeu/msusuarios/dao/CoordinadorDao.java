package pe.edu.upeu.msusuarios.dao;
import pe.edu.upeu.msusuarios.domain.Coordinador;

import java.util.List;
import java.util.Optional;

public interface CoordinadorDao{
    Coordinador create(Coordinador coordinador);
    Coordinador update(Coordinador coordinador);
    void delete(Long id);
    Optional<Coordinador> read(Long id);
    List<Coordinador> readAll();
}