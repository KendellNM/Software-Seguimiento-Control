package pe.edu.pe.msempresa.service;

import pe.edu.pe.msempresa.domain.Representante;

import java.util.List;
import java.util.Optional;

public interface RepresentanteService {

    Representante create(Representante representante);

    Representante update(Representante representante);

    void delete(Long id);

    Optional<Representante> read(Long id);

    List<Representante> readAll();
}