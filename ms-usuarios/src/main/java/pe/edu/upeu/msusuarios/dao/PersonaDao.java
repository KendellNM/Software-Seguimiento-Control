package pe.edu.upeu.msusuarios.dao;


import pe.edu.upeu.msusuarios.domain.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaDao{
    Persona create(Persona persona);
    Persona update(Persona persona);
    void delete(Long id);
    Optional<Persona> read(Long id);
    List<Persona> readAll();
}