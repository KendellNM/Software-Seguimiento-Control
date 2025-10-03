package pe.edu.pe.msempresa.repository;

import pe.edu.pe.msempresa.domain.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    boolean existsByRuc(String ruc);
    Optional<Empresa> findByRuc(String ruc);
}