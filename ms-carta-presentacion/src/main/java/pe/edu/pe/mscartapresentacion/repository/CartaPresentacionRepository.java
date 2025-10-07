package pe.edu.pe.mscartapresentacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.pe.mscartapresentacion.domain.CartaPresentacion;

@Repository
public interface CartaPresentacionRepository extends JpaRepository<CartaPresentacion, Long> {
}
