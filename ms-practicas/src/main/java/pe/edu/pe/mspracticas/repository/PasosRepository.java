package pe.edu.pe.mspracticas.repository;

import pe.edu.pe.mspracticas.domain.Pasos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasosRepository extends JpaRepository<Pasos, Long> {
}