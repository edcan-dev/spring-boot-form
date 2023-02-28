package dev.edcan.springboot.form.services;

import dev.edcan.springboot.form.models.domain.Role;

import java.util.List;

public interface RoleService {
    public List<Role> listar();
    public Role obtenerPorId(Integer id);
}
