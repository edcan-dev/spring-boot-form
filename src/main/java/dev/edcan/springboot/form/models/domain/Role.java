package dev.edcan.springboot.form.models.domain;

public class Role {

    private Integer id;
    private String nombre;
    private String role;

    @Override
    public boolean equals(Object obj) {
        Role role = (Role)obj;
        return this.id != null && this.id.equals(role.getId());
    }

    public Role(Integer id, String nombre, String role) {
        this.id = id;
        this.nombre = nombre;
        this.role = role;
    }
    public Role() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
