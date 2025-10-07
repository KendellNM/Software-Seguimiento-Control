package pe.edu.upeu.msusuarios.service;


import pe.edu.upeu.msusuarios.domain.Estudiante;

import java.util.List;
import java.util.Optional;

public interface EstudianteService {

    Estudiante create(Estudiante estudiante);

    Estudiante update(Estudiante estudiante);

    void delete(Long id);

    Optional<Estudiante> read(Long id);

    List<Estudiante> readAll();
}