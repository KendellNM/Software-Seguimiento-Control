package pe.edu.upeu.msusuarios.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.msusuarios.dao.CoordinadorDao;
import pe.edu.upeu.msusuarios.domain.Coordinador;
import pe.edu.upeu.msusuarios.service.CoordinadorService;

import java.util.List;
import java.util.Optional;

@Service
public class CoordinadorServiceImpl implements CoordinadorService {

    @Autowired
    private CoordinadorDao coordinadorDao;

    @Override
    public Coordinador create(Coordinador coordinador) {
        return coordinadorDao.create(coordinador);
    }

    @Override
    public Coordinador update(Coordinador coordinador) {
        return coordinadorDao.update(coordinador);
    }

    @Override
    public void delete(Long id) {
        coordinadorDao.delete(id);
    }

    @Override
    public Optional<Coordinador> read(Long id) {
        return coordinadorDao.read(id);
    }

    @Override
    public List<Coordinador> readAll() {
        return coordinadorDao.readAll();
    }
}