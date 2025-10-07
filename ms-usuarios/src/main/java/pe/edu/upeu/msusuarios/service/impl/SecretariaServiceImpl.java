package pe.edu.upeu.msusuarios.service.impl;

import pe.edu.upeu.msusuarios.dao.SecretariaDao;
import pe.edu.upeu.msusuarios.domain.Secretaria;
import pe.edu.upeu.msusuarios.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecretariaServiceImpl implements SecretariaService {

    @Autowired
    private SecretariaDao secretariaDao;

    @Override
    public Secretaria create(Secretaria secretaria) {
        return secretariaDao.create(secretaria);
    }

    @Override
    public Secretaria update(Secretaria secretaria) {
        return secretariaDao.update(secretaria);
    }

    @Override
    public void delete(Long id) {
        secretariaDao.delete(id);
    }

    @Override
    public Optional<Secretaria> read(Long id) {
        return secretariaDao.read(id);
    }

    @Override
    public List<Secretaria> readAll() {
        return secretariaDao.readAll();
    }
}