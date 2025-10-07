package pe.edu.pe.mspracticas.service.impl;

import pe.edu.pe.mspracticas.dao.PasosDao;
import pe.edu.pe.mspracticas.domain.Pasos;
import pe.edu.pe.mspracticas.service.PasosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasosServiceImpl implements PasosService {

    @Autowired
    private PasosDao pasosDao;

    @Override
    public Pasos create(Pasos pasos) {
        return pasosDao.create(pasos);
    }

    @Override
    public Pasos update(Pasos pasos) {
        return pasosDao.update(pasos);
    }

    @Override
    public void delete(Long id) {
        pasosDao.delete(id);
    }

    @Override
    public Optional<Pasos> read(Long id) {
        return pasosDao.read(id);
    }

    @Override
    public List<Pasos> readAll() {
        return pasosDao.readAll();
    }
}