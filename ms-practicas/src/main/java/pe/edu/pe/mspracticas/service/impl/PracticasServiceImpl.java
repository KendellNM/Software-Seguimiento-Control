package pe.edu.pe.mspracticas.service.impl;

import pe.edu.pe.mspracticas.dao.PracticasDao;
import pe.edu.pe.mspracticas.domain.Practicas;
import pe.edu.pe.mspracticas.enums.EstadoPracticas;
import pe.edu.pe.mspracticas.exception.PracticaActivaException;
import pe.edu.pe.mspracticas.service.PracticasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PracticasServiceImpl implements PracticasService {

    @Autowired
    private PracticasDao practicasDao;

    @Override
    public Practicas create(Practicas practicas) {
        return practicasDao.create(practicas);
    }

    @Override
    public Practicas update(Practicas practicas) {
        return practicasDao.update(practicas);
    }

    @Override
    public void delete(Long id) {
        practicasDao.delete(id);
    }

    @Override
    public Optional<Practicas> read(Long id) {
        return practicasDao.read(id);
    }

    @Override
    public List<Practicas> readAll() {
        return practicasDao.readAll();
    }

    @Override
    public void practicaActiva(Long id) {
        Optional<Practicas> practicaActiva = practicasDao.findByUsuarioandEstado(id, EstadoPracticas.ACTIVO);

        if (practicaActiva.isPresent()) {
            throw new PracticaActivaException("El usuario ya tiene una práctica activa");
        }
    }
}