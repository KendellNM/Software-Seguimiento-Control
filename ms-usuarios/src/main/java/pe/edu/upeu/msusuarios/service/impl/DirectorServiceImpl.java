package pe.edu.upeu.msusuarios.service.impl;

import pe.edu.upeu.msusuarios.dao.DirectorDao;
import pe.edu.upeu.msusuarios.domain.Director;
import pe.edu.upeu.msusuarios.service.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    private DirectorDao directorDao;

    @Override
    public Director create(Director director) {
        return directorDao.create(director);
    }

    @Override
    public Director update(Director director) {
        return directorDao.update(director);
    }

    @Override
    public void delete(Long id) {
        directorDao.delete(id);
    }

    @Override
    public Optional<Director> read(Long id) {
        return directorDao.read(id);
    }

    @Override
    public List<Director> readAll() {
        return directorDao.readAll();
    }
}