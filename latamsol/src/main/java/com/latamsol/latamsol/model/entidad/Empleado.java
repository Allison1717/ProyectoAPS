package com.latamsol.latamsol.model.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleados")
    private Long id;
    @Column(name = "DNI")
    private String dni;
    @Column(name = "Nombres")
    private String nombre;
    @Column(name = "Apellidos")
    private String apellido;
    @Column(name = "Genero")
    private String genero;
    @Column(name = "Correo")
    private String correo;
    @Column(name = "Telefono")
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "Cargo_id_cargo")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "Login_Usuario")
    private Login login;

    
    public Empleado(String dni, String nombre, String apellido, String genero, String correo, String telefono,
            Cargo cargo, Login login) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.correo = correo;
        this.telefono = telefono;
        this.cargo = cargo;
        this.login = login;
    }

    public Empleado() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    

}
