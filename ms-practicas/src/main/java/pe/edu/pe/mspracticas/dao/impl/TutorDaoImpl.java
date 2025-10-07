package pe.edu.pe.mspracticas.dao.impl;

import pe.edu.pe.mspracticas.dao.TutorDao;
import pe.edu.pe.mspracticas.domain.Tutor;
import pe.edu.pe.mspracticas.repository.TutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TutorDaoImpl implements TutorDao {

    @Autowired
    private TutorRepository tutorRepository;

    @Override
    public Tutor create(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public Tutor update(Tutor tutor) {
        return tutorRepository.save(tutor);
    }

    @Override
    public void delete(Long id) {
        tutorRepository.deleteById(id);
    }

    @Override
    public Optional<Tutor> read(Long id) {
        return tutorRepository.findById(id);
    }

    @Override
    public List<Tutor> readAll() {
        return tutorRepository.findAll();
    }
}