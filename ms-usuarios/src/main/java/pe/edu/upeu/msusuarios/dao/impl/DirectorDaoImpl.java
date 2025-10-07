package pe.edu.upeu.msusuarios.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.msusuarios.dao.DirectorDao;
import pe.edu.upeu.msusuarios.domain.Director;
import pe.edu.upeu.msusuarios.repository.DirectorRepository;

import java.util.List;
import java.util.Optional;

@Component
public class DirectorDaoImpl implements DirectorDao {

    @Autowired
    private DirectorRepository directorRepository;

    @Override
    public Director create(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Director update(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public void delete(Long id) {
        directorRepository.deleteById(id);
    }

    @Override
    public Optional<Director> read(Long id) {
        return directorRepository.findById(id);
    }

    @Override
    public List<Director> readAll() {
        return directorRepository.findAll();
    }
}