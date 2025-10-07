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
        // Validar RUC duplicado antes de crear
        if (empresa.getRuc() != null && empresaDao.existsByRuc(empresa.getRuc())) {
            throw new IllegalArgumentException("El RUC ya existe");
        }
        return empresaDao.create(empresa);
    }

    @Override
    public Empresa update(Empresa empresa) {
        // Validar RUC duplicado al actualizar (permitir mismo registro)
        if (empresa.getRuc() != null) {
            Optional<Empresa> existente = empresaDao.findByRuc(empresa.getRuc());
            if (existente.isPresent() && !existente.get().getIdEmpresa().equals(empresa.getIdEmpresa())) {
                throw new IllegalArgumentException("El RUC ya existe");
            }
        }
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

    @Override
    public List<Empresa> readAllActivas() {
        return empresaDao.readAllByEstado("1");
    }

    @Override
    public List<Empresa> searchByNombre(String nombre) {
        return empresaDao.searchByNombre(nombre);
    }

    @Override
    public List<Empresa> searchByNombreAndEstado(String nombre, String estado) {
        return empresaDao.searchByNombreAndEstado(nombre, estado);
    }
}