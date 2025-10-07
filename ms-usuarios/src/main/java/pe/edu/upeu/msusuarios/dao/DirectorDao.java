package pe.edu.upeu.msusuarios.dao;

import pe.edu.upeu.msusuarios.domain.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorDao{
    Director create(Director director);
    Director update(Director director);
    void delete(Long id);
    Optional<Director> read(Long id);
    List<Director> readAll();
}