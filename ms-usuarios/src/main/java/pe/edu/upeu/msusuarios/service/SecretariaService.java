package pe.edu.upeu.msusuarios.service;


import pe.edu.upeu.msusuarios.domain.Secretaria;

import java.util.List;
import java.util.Optional;

public interface SecretariaService {

    Secretaria create(Secretaria secretaria);

    Secretaria update(Secretaria secretaria);

    void delete(Long id);

    Optional<Secretaria> read(Long id);

    List<Secretaria> readAll();
}