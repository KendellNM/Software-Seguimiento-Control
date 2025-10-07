package pe.edu.upeu.msusuarios.dao.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.msusuarios.dao.SecretariaDao;
import pe.edu.upeu.msusuarios.domain.Secretaria;
import pe.edu.upeu.msusuarios.repository.SecretariaRepository;

import java.util.List;
import java.util.Optional;

@Component
public class SecretariaDaoImpl implements SecretariaDao {

    @Autowired

    private SecretariaRepository secretariaRepository;

    @Override
    public Secretaria create(Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }

    @Override
    public Secretaria update(Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }

    @Override
    public void delete(Long id) {
        secretariaRepository.deleteById(id);
    }

    @Override
    public Optional<Secretaria> read(Long id) {
        return secretariaRepository.findById(id);
    }

    @Override
    public List<Secretaria> readAll() {
        return secretariaRepository.findAll();
    }
}