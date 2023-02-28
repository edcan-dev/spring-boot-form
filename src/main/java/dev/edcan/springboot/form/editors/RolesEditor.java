package dev.edcan.springboot.form.editors;

import dev.edcan.springboot.form.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditor extends PropertyEditorSupport {

    @Autowired
    RoleService service;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Integer id = Integer.parseInt(text);
            setValue(service.obtenerPorId(id));
        } catch (NumberFormatException e){

        }
    }
}
