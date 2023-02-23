package dev.edcan.springboot.form.models.domain;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Usuario {


    // @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    private String identificador;

    // @NotEmpty(message="El nombre no puede ser vacío")
    private String nombre;

    @NotEmpty
    private String apellido;

    @NotBlank
    @Size(min=3, max=8)
    private String username;

    @NotEmpty
    private String password;
    
    @NotEmpty
    @Email
    private String email;

    
    public Usuario() {
    }
    
    public Usuario(String _username, String _password, String _email) {
        this.username = _username;
        this.password = _password;
        this.email = _email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

}
