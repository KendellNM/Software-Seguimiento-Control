package pe.edu.upeu.msusuarios.service.impl;

import pe.edu.upeu.msusuarios.dao.PersonaDao;
import pe.edu.upeu.msusuarios.domain.Persona;
import pe.edu.upeu.msusuarios.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl implements PersonaService {

    @Autowired
    private PersonaDao personaDao;

    @Override
    public Persona create(Persona persona) {
        return personaDao.create(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaDao.update(persona);
    }

    @Override
    public void delete(Long id) {
        personaDao.delete(id);
    }

    @Override
    public Optional<Persona> read(Long id) {
        return personaDao.read(id);
    }

    @Override
    public List<Persona> readAll() {
        return personaDao.readAll();
    }
}