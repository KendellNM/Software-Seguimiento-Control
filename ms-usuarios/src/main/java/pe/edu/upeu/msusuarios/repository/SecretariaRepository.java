package pe.edu.upeu.msusuarios.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.msusuarios.domain.Secretaria;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Long> {
}