package com.latamsol.latamsol.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latamsol.latamsol.model.dao.ILoginDAO;
import com.latamsol.latamsol.model.entidad.Login;

@Service
public class LoginServiceImp implements ILoginService {

    @Autowired
    private ILoginDAO loginDAO;

    @Override
    public void guardarLogin(Login login) {
        loginDAO.save(login);
    }

    @Override
    public List<Login> cargarLogins() {
        return (List<Login>) loginDAO.findAll();
    }

    @Override
    public Login buscarLogin(String id) {
        return loginDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarLogin(String id) {
        loginDAO.deleteById(id);
    }
}
