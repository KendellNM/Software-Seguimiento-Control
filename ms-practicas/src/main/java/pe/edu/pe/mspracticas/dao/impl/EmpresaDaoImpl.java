package pe.edu.pe.mspracticas.dao.impl;

import pe.edu.pe.mspracticas.dao.EmpresaDao;
import pe.edu.pe.mspracticas.domain.Empresa;
import pe.edu.pe.mspracticas.repository.EmpresaRepository;
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