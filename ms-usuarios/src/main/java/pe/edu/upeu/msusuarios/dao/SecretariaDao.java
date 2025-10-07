package pe.edu.upeu.msusuarios.dao;


import pe.edu.upeu.msusuarios.domain.Secretaria;

import java.util.List;
import java.util.Optional;

public interface SecretariaDao{
    Secretaria create(Secretaria secretaria);
    Secretaria update(Secretaria secretaria);
    void delete(Long id);
    Optional<Secretaria> read(Long id);
    List<Secretaria> readAll();
}