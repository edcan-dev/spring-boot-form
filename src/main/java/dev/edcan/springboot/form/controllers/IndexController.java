package dev.edcan.springboot.form.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import dev.edcan.springboot.form.models.domain.Usuario;
import dev.edcan.springboot.form.validation.UsuarioValidator;

@Controller
@SessionAttributes("usuario")
public class IndexController {

    @Autowired
    private UsuarioValidator usuarioValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(usuarioValidator);
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        Usuario usuarioVacio = new Usuario();

        usuarioVacio.setNombre("Edgar");
        usuarioVacio.setApellido("Cano");
        
        // usuarioVacio.setIdentificador("CARE201920732");
        model.addAttribute("titulo", "Formulario con Spring");
        model.addAttribute("usuario", usuarioVacio);
        return "form";
    }

    @PostMapping("/form")
    public String postForm(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        //Usuario usuario = new Usuario(username, password, email);

        model.addAttribute("titulo", "Resultado");
 
        // usuarioValidator.validate(usuario, result);

        if(result.hasErrors()) {

            return "form";
        }
        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }

    
}
