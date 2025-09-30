package pe.edu.pe.mspracticas.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import pe.edu.pe.mspracticas.dao.PracticasDao;
import pe.edu.pe.mspracticas.domain.Practicas;
import pe.edu.pe.mspracticas.enums.EstadoPracticas;
import pe.edu.pe.mspracticas.repository.PracticasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PracticasDaoImpl implements PracticasDao {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private PracticasRepository practicasRepository;

    @Override
    public Practicas create(Practicas practicas) {
        return practicasRepository.save(practicas);
    }

    @Override
    public Practicas update(Practicas practicas) {
        return practicasRepository.save(practicas);
    }

    @Override
    public void delete(Long id) {
        practicasRepository.deleteById(id);
    }

    @Override
    public Optional<Practicas> read(Long id) {
        return practicasRepository.findById(id);
    }

    @Override
    public List<Practicas> readAll() {
        return practicasRepository.findAll();
    }

    @Override
    public Optional<Practicas> findByUsuarioandEstado(Long idEstudiante, EstadoPracticas estado) {
        String jpql = "SELECT p FROM Practicas p WHERE p.idEstudiante = :estudianteid AND p.estado = :estado " +
                "ORDER BY p.fechaInicio DESC";

        List<Practicas> resultados = em.createQuery(jpql, Practicas.class)
                .setParameter("estudianteid", idEstudiante)
                .setParameter("estado", estado)
                .getResultList();

        return resultados.stream().findFirst();
    }
}