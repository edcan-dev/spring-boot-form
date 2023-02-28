package dev.edcan.springboot.form.controllers;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.validation.Valid;

import dev.edcan.springboot.form.editors.PaisPropertyEditor;
import dev.edcan.springboot.form.editors.RolesEditor;
import dev.edcan.springboot.form.models.domain.Pais;
import dev.edcan.springboot.form.models.domain.Role;
import dev.edcan.springboot.form.services.PaisService;
import dev.edcan.springboot.form.services.RoleService;
import jdk.jfr.MetadataDefinition;
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

    @Autowired
    private PaisService paisService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RolesEditor rolesEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(usuarioValidator);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.registerCustomEditor(String.class, "nombre",new NombreMayusculaEditor());
        binder.registerCustomEditor(Pais.class, "pais", paisEditor);
        binder.registerCustomEditor(Role.class, "roles", rolesEditor);
    }

    @GetMapping("/form")
    public String getForm(Model model) {
        Usuario usuarioVacio = new Usuario();

        usuarioVacio.setNombre("Edgar");
        usuarioVacio.setApellido("Cano");
        usuarioVacio.setHabilitar(true);
        usuarioVacio.setValorSecreto("Este es un valor secreto...");
        
        // usuarioVacio.setIdentificador("CARE201920732");
        model.addAttribute("titulo", "Formulario con Spring y Thymeleaf");
        model.addAttribute("usuario", usuarioVacio);
        return "form";
    }

    @PostMapping("/form")
    public String postForm(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {

        model.addAttribute("titulo", "Resultado");

        if(result.hasErrors()) {
            return "form";
        }
        model.addAttribute("usuario", usuario);
        status.setComplete();
        return "resultado";
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return Arrays.asList(
                new Pais(1,"MX","México"),
                new Pais(2,"AR","Argentina"),
                new Pais(3,"CL","Chile"),
                new Pais(4,"ES","España"),
                new Pais(5,"RS","Rusia"));
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

    @ModelAttribute("listaRolesString")
    public List <String> listaRolesString () {
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }
    @ModelAttribute("listaRolesMap")
    public Map <String, String> listaRolesMap () {
        Map<String, String> roles = new HashMap<>();
        roles.put("ROLE_ADMIN","Adinistrador");
        roles.put("ROLE_USER","Usuario");
        roles.put("ROLE_MODERATOR","Moderaror");
        return roles;
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles() {
        return this.roleService.listar();
    }

    @ModelAttribute("generos")
    public List<String> generos() {
    return Arrays.asList("Hombre","Mujer");
    }





    
}
