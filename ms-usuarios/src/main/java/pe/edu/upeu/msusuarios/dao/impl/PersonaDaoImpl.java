package pe.edu.upeu.msusuarios.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.upeu.msusuarios.dao.PersonaDao;
import pe.edu.upeu.msusuarios.domain.Persona;
import pe.edu.upeu.msusuarios.repository.PersonaRepository;

import java.util.List;
import java.util.Optional;

@Component
public class PersonaDaoImpl implements PersonaDao {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public Persona create(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public Persona update(Persona persona) {
        return personaRepository.save(persona);
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);
    }

    @Override
    public Optional<Persona> read(Long id) {
        return personaRepository.findById(id);
    }

    @Override
    public List<Persona> readAll() {
        return personaRepository.findAll();
    }
}