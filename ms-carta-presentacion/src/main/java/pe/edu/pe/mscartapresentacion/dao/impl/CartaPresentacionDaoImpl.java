package pe.edu.pe.mscartapresentacion.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.pe.mscartapresentacion.dao.CartaPresentacionDao;
import pe.edu.pe.mscartapresentacion.domain.CartaPresentacion;
import pe.edu.pe.mscartapresentacion.repository.CartaPresentacionRepository;

import java.util.List;
import java.util.Optional;

@Component
public class CartaPresentacionDaoImpl implements CartaPresentacionDao {

    @Autowired
    private CartaPresentacionRepository repository;

    @Override
    public CartaPresentacion create(CartaPresentacion carta) {
        return repository.save(carta);
    }

    @Override
    public CartaPresentacion update(CartaPresentacion carta) {
        return repository.save(carta);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<CartaPresentacion> read(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<CartaPresentacion> readAll() {
        return repository.findAll();
    }
}
