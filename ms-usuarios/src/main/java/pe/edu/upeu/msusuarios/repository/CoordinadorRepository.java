package pe.edu.upeu.msusuarios.repository;

import pe.edu.upeu.msusuarios.domain.Coordinador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinadorRepository extends JpaRepository<Coordinador, Long> {
}