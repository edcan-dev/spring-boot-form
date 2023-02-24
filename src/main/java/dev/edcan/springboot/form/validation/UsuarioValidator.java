package dev.edcan.springboot.form.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.*;

import dev.edcan.springboot.form.models.domain.Usuario;

@Component
public class UsuarioValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return Usuario.class.isAssignableFrom(clazz);
        
    }

    @Override
    public void validate(Object target, Errors errors) {
        Usuario usuario = (Usuario)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "NotEmpty.usuario.nombre");
        /* if(!usuario.getIdentificador().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
            errors.rejectValue("identificador", "pattern.usuario.identificador");
        } */
    }

}
