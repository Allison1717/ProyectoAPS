package com.latamsol.latamsol.model.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "login")
public class Login {
    @Id
    @Column(name = "Usuario")
    private String usuario;
    @Column(name = "Contraseña")
    private String password;
    @ManyToOne
    @JoinColumn(name = "Cargo_id_cargo")
    private Cargo cargo;

    public Login(String usuario, String password, Cargo cargo) {
        this.usuario = usuario;
        this.password = password;
        this.cargo = cargo;
    }
    public Login() {
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Cargo getCargo() {
        return cargo;
    }
    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    
}
