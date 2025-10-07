package pe.edu.upeu.msusuarios.dao;

import pe.edu.upeu.msusuarios.domain.Tutor;

import java.util.List;
import java.util.Optional;

public interface TutorDao{
    Tutor create(Tutor tutor);
    Tutor update(Tutor tutor);
    void delete(Long id);
    Optional<Tutor> read(Long id);
    List<Tutor> readAll();
}