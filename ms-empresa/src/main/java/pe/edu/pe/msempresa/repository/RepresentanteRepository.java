package pe.edu.pe.msempresa.repository;

import pe.edu.pe.msempresa.domain.Representante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentanteRepository extends JpaRepository<Representante, Long> {
}