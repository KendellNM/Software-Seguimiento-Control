package pe.edu.upeu.msusuarios.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.msusuarios.dao.CoordinadorDao;
import pe.edu.upeu.msusuarios.domain.Coordinador;
import pe.edu.upeu.msusuarios.repository.CoordinadorRepository;

import java.util.List;
import java.util.Optional;

@Component
public class CoordinadorDaoImpl implements CoordinadorDao {

    @Autowired
    private CoordinadorRepository coordinadorRepository;

    @Override
    public Coordinador create(Coordinador coordinador) {
        return coordinadorRepository.save(coordinador);
    }

    @Override
    public Coordinador update(Coordinador coordinador) {
        return coordinadorRepository.save(coordinador);
    }

    @Override
    public void delete(Long id) {
        coordinadorRepository.deleteById(id);
    }

    @Override
    public Optional<Coordinador> read(Long id) {
        return coordinadorRepository.findById(id);
    }

    @Override
    public List<Coordinador> readAll() {
        return coordinadorRepository.findAll();
    }
}