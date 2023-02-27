package dev.edcan.springboot.form.services;

import dev.edcan.springboot.form.models.domain.Pais;

import java.util.List;

public interface PaisService {
    public List<Pais> listar();
    public Pais obtenerPais(Integer id);
}
