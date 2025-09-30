package pe.edu.pe.msempresa.dao.impl;

import pe.edu.pe.msempresa.dao.EmpresaDao;
import pe.edu.pe.msempresa.domain.Empresa;
import pe.edu.pe.msempresa.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmpresaDaoImpl implements EmpresaDao {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Override
    public Empresa create(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    @Override
    public void delete(Long id) {
        empresaRepository.deleteById(id);
    }

    @Override
    public Optional<Empresa> read(Long id) {
        return empresaRepository.findById(id);
    }

    @Override
    public List<Empresa> readAll() {
        return empresaRepository.findAll();
    }
}