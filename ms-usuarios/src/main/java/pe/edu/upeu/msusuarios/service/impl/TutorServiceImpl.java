package pe.edu.upeu.msusuarios.service.impl;

import pe.edu.upeu.msusuarios.dao.TutorDao;
import pe.edu.upeu.msusuarios.domain.Tutor;
import pe.edu.upeu.msusuarios.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorDao tutorDao;

    @Override
    public Tutor create(Tutor tutor) {
        return tutorDao.create(tutor);
    }

    @Override
    public Tutor update(Tutor tutor) {
        return tutorDao.update(tutor);
    }

    @Override
    public void delete(Long id) {
        tutorDao.delete(id);
    }

    @Override
    public Optional<Tutor> read(Long id) {
        return tutorDao.read(id);
    }

    @Override
    public List<Tutor> readAll() {
        return tutorDao.readAll();
    }
}