package pe.edu.pe.msempresa.service.impl;

import pe.edu.pe.msempresa.dao.EmpresaDao;
import pe.edu.pe.msempresa.domain.Empresa;
import pe.edu.pe.msempresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    @Autowired
    private EmpresaDao empresaDao;

    @Override
    public Empresa create(Empresa empresa) {
        return empresaDao.create(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) {
        return empresaDao.update(empresa);
    }

    @Override
    public void delete(Long id) {
        empresaDao.delete(id);
    }

    @Override
    public Optional<Empresa> read(Long id) {
        return empresaDao.read(id);
    }

    @Override
    public List<Empresa> readAll() {
        return empresaDao.readAll();
    }
}