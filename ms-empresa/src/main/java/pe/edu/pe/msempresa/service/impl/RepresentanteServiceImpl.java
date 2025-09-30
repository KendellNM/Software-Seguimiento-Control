package pe.edu.pe.msempresa.service.impl;

import pe.edu.pe.msempresa.dao.RepresentanteDao;
import pe.edu.pe.msempresa.domain.Representante;
import pe.edu.pe.msempresa.service.RepresentanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepresentanteServiceImpl implements RepresentanteService {

    @Autowired
    private RepresentanteDao representanteDao;

    @Override
    public Representante create(Representante representante) {
        return representanteDao.create(representante);
    }

    @Override
    public Representante update(Representante representante) {
        return representanteDao.update(representante);
    }

    @Override
    public void delete(Long id) {
        representanteDao.delete(id);
    }

    @Override
    public Optional<Representante> read(Long id) {
        return representanteDao.read(id);
    }

    @Override
    public List<Representante> readAll() {
        return representanteDao.readAll();
    }
}