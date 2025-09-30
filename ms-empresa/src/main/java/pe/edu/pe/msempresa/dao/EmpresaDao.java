package pe.edu.pe.msempresa.dao;
import pe.edu.pe.msempresa.domain.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaDao{
    Empresa create(Empresa empresa);
    Empresa update(Empresa empresa);
    void delete(Long id);
    Optional<Empresa> read(Long id);
    List<Empresa> readAll();
}