package pe.edu.upeu.msusuarios.service;


import pe.edu.upeu.msusuarios.domain.Coordinador;

import java.util.List;
import java.util.Optional;

public interface CoordinadorService {

    Coordinador create(Coordinador coordinador);

    Coordinador update(Coordinador coordinador);

    void delete(Long id);

    Optional<Coordinador> read(Long id);

    List<Coordinador> readAll();
}