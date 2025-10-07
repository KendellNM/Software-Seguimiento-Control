package pe.edu.upeu.msusuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.msusuarios.domain.Director;
import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {
    Optional<Director> findByDirector_IdPersona(Long personaId);
}