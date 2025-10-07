package pe.edu.upeu.msusuarios.service;

import pe.edu.upeu.msusuarios.domain.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService {

    Persona create(Persona persona);

    Persona update(Persona persona);

    void delete(Long id);

    Optional<Persona> read(Long id);

    List<Persona> readAll();
}