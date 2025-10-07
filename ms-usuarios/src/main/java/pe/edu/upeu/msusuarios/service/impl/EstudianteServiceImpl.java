package pe.edu.upeu.msusuarios.service.impl;

import pe.edu.upeu.msusuarios.dao.EstudianteDao;
import pe.edu.upeu.msusuarios.domain.Estudiante;
import pe.edu.upeu.msusuarios.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImpl implements EstudianteService {

    @Autowired
    private EstudianteDao estudianteDao;

    @Override
    public Estudiante create(Estudiante estudiante) {
        return estudianteDao.create(estudiante);
    }

    @Override
    public Estudiante update(Estudiante estudiante) {
        return estudianteDao.update(estudiante);
    }

    @Override
    public void delete(Long id) {
        estudianteDao.delete(id);
    }

    @Override
    public Optional<Estudiante> read(Long id) {
        return estudianteDao.read(id);
    }

    @Override
    public List<Estudiante> readAll() {
        return estudianteDao.readAll();
    }
}