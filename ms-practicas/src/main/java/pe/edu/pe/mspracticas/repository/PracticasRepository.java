package pe.edu.pe.mspracticas.repository;

import pe.edu.pe.mspracticas.domain.Practicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracticasRepository extends JpaRepository<Practicas, Long> {
}