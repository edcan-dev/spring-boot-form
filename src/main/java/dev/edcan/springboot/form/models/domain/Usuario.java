package dev.edcan.springboot.form.models.domain;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import dev.edcan.springboot.form.validation.IdentificadorRegex;
import dev.edcan.springboot.form.validation.Requerido;

public class Usuario {


    @IdentificadorRegex // Validación por anotaciones
    private String identificador;

    private String nombre; // Validación por clase que implementa Validator

    // @NotEmpty
    @Requerido // Validación por anotaciones
    private String apellido;

    @NotBlank
    @Size(min=3, max=8)
    private String username;

    @NotEmpty
    private String password;
    
    @Requerido
    @Email
    private String email;

    @NotNull      
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past
    private Date fechaNacimiento;
    @NotNull
    public Pais pais;

    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }



    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }




    public Integer getCuenta() {
        return this.cuenta;
    }

    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    
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
