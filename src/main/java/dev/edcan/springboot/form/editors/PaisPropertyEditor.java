package dev.edcan.springboot.form.editors;

import dev.edcan.springboot.form.services.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private PaisService paisService;

    @Override
    public void setAsText(String idString) throws IllegalArgumentException {
        Integer id = Integer.parseInt(idString);
        this.setValue(paisService.obtenerPais(id));
    }
}
