package pe.edu.pe.mscartapresentacion.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.pe.mscartapresentacion.dao.CartaPresentacionDao;
import pe.edu.pe.mscartapresentacion.domain.CartaPresentacion;
import pe.edu.pe.mscartapresentacion.service.CartaPresentacionService;

import java.util.List;
import java.util.Optional;

@Service
public class CartaPresentacionServiceImpl implements CartaPresentacionService {

    @Autowired
    private CartaPresentacionDao dao;

    @Override
    public CartaPresentacion create(CartaPresentacion carta) {
        return dao.create(carta);
    }

    @Override
    public CartaPresentacion update(CartaPresentacion carta) {
        return dao.update(carta);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    public Optional<CartaPresentacion> read(Long id) {
        return dao.read(id);
    }

    @Override
    public List<CartaPresentacion> readAll() {
        return dao.readAll();
    }
}
