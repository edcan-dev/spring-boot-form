package dev.edcan.springboot.form.controllers;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import dev.edcan.springboot.form.editors.NombreMayusculaEditor;
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, "nombre",new NombreMayusculaEditor());
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        Usuario usuarioVacio = new Usuario();

        usuarioVacio.setNombre("Edgar");
        usuarioVacio.setApellido("Cano");
        
        // usuarioVacio.setIdentificador("CARE201920732");
        model.addAttribute("titulo", "Formulario con Spring y Thymeleaf");
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

    @ModelAttribute("paises")
    public List<String> paises() {
        return Arrays.asList("México", "Argentina", "Chile", "España");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        Map<String, String> paises = new HashMap<String, String>();
        paises.put("ES","España");
        paises.put("AR","Argentina");
        paises.put("MX","México");
        paises.put("CL","Chile");
        paises.put("EU","Estados Unidos");
        paises.put("UK","Reino Unido");
        paises.put("RS","Rusia");
        return paises;
    }

    
}
