package pe.edu.pe.mspracticas.dao.impl;

import pe.edu.pe.mspracticas.dao.PasosDao;
import pe.edu.pe.mspracticas.domain.Pasos;
import pe.edu.pe.mspracticas.repository.PasosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PasosDaoImpl implements PasosDao {

    @Autowired
    private PasosRepository pasosRepository;

    @Override
    public Pasos create(Pasos pasos) {
        return pasosRepository.save(pasos);
    }

    @Override
    public Pasos update(Pasos pasos) {
        return pasosRepository.save(pasos);
    }

    @Override
    public void delete(Long id) {
        pasosRepository.deleteById(id);
    }

    @Override
    public Optional<Pasos> read(Long id) {
        return pasosRepository.findById(id);
    }

    @Override
    public List<Pasos> readAll() {
        return pasosRepository.findAll();
    }
}