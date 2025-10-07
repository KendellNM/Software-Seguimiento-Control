package pe.edu.pe.mspracticas.repository;

import pe.edu.pe.mspracticas.domain.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, Long> {
}