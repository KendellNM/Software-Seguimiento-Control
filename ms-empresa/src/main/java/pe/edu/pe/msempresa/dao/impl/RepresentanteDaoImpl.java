package pe.edu.pe.msempresa.dao.impl;

import pe.edu.pe.msempresa.dao.RepresentanteDao;
import pe.edu.pe.msempresa.domain.Representante;
import pe.edu.pe.msempresa.repository.RepresentanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class RepresentanteDaoImpl implements RepresentanteDao {

    @Autowired
    private RepresentanteRepository representanteRepository;

    @Override
    public Representante create(Representante representante) {
        return representanteRepository.save(representante);
    }

    @Override
    public Representante update(Representante representante) {
        return representanteRepository.save(representante);
    }

    @Override
    public void delete(Long id) {
        representanteRepository.deleteById(id);
    }

    @Override
    public Optional<Representante> read(Long id) {
        return representanteRepository.findById(id);
    }

    @Override
    public List<Representante> readAll() {
        return representanteRepository.findAll();
    }
}