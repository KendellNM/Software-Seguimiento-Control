package pe.edu.upeu.msusuarios.dao.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.msusuarios.dao.EstudianteDao;
import pe.edu.upeu.msusuarios.domain.Estudiante;
import pe.edu.upeu.msusuarios.repository.EstudianteRepository;

import java.util.List;
import java.util.Optional;

@Component
public class EstudianteDaoImpl implements EstudianteDao {

    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Estudiante create(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante update(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public void delete(Long id) {
        estudianteRepository.deleteById(id);
    }

    @Override
    public Optional<Estudiante> read(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public List<Estudiante> readAll() {
        return estudianteRepository.findAll();
    }
}