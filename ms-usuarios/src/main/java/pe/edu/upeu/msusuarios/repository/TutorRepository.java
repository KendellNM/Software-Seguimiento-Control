package pe.edu.upeu.msusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.msusuarios.domain.Tutor;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
}