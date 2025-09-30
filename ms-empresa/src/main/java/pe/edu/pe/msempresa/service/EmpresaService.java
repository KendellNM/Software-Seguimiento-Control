package pe.edu.pe.msempresa.service;

import pe.edu.pe.msempresa.domain.Empresa;

import java.util.List;
import java.util.Optional;

public interface EmpresaService {

    Empresa create(Empresa empresa);

    Empresa update(Empresa empresa);

    void delete(Long id);

    Optional<Empresa> read(Long id);

    List<Empresa> readAll();
}