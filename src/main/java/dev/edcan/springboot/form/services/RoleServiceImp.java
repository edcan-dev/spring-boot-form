package dev.edcan.springboot.form.services;


import dev.edcan.springboot.form.models.domain.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private List<Role> roles;

    public RoleServiceImp() {
        this.roles = new ArrayList<>();
        this.roles.add(new Role(1,"Administrador","ROLE_ADMIN"));
        this.roles.add(new Role(1,"Usuario","ROLE_USER"));
        this.roles.add(new Role(1,"Moderaror","ROLE_MODERATOR"));
    }

    @Override
    public List<Role> listar() {
        return this.roles;
    }

    @Override
    public Role obtenerPorId(Integer id) {
        Role resultado = null;
        for (Role role: roles) {
            if (id == role.getId()) {
                resultado = role;
                break;
            }
        }
        return resultado;
    }
}
