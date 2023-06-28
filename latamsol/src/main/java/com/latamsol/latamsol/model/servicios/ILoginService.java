package com.latamsol.latamsol.model.servicios;

import java.util.List;

import com.latamsol.latamsol.model.entidad.Login;

public interface ILoginService {
    public void guardarLogin(Login login);
    public List<Login> cargarLogins();
    public Login buscarLogin(String id);
    public void eliminarLogin(String id);
}
