package pe.edu.upeu.msusuarios.dao;


import pe.edu.upeu.msusuarios.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteDao{
    Estudiante create(Estudiante estudiante);
    Estudiante update(Estudiante estudiante);
    void delete(Long id);
    Optional<Estudiante> read(Long id);
    List<Estudiante> readAll();
}