package pe.edu.pe.mscartapresentacion.service;

import pe.edu.pe.mscartapresentacion.domain.CartaPresentacion;

import java.util.List;
import java.util.Optional;

public interface CartaPresentacionService {
    CartaPresentacion create(CartaPresentacion carta);
    CartaPresentacion update(CartaPresentacion carta);
    void delete(Long id);
    Optional<CartaPresentacion> read(Long id);
    List<CartaPresentacion> readAll();
}
