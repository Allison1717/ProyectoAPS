package com.latamsol.latamsol.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latamsol.latamsol.model.entidad.Login;
import com.latamsol.latamsol.model.entidad.Cargo;
import com.latamsol.latamsol.model.servicios.ILoginService;
import com.latamsol.latamsol.model.servicios.ICargoService;

@Controller
public class LoginController {

    @Autowired
    private ILoginService loginService;

    @Autowired
    private ICargoService cargoService;

    @RequestMapping("/registro")
    public String logins(Model model){
        Login login = new Login();
        List<Cargo> listaCargos = cargoService.cargarCargos();
        model.addAttribute("login", login);
        model.addAttribute("listaLogins", loginService.cargarLogins());
        model.addAttribute("listaCargos", listaCargos);
        return "registro";
    }

    @RequestMapping(value = "/registro", method = RequestMethod.POST)
    public String guardar(Login login){
        loginService.guardarLogin(login);
        return "redirect:/registro";
    }

    @RequestMapping("/registro/editar/{usuario}")
    public String editar(@PathVariable(value = "usuario") String id, Model model){
        Login login = loginService.buscarLogin(id);
        List<Cargo> listaCargos = cargoService.cargarCargos();
        model.addAttribute("login", login);
        model.addAttribute("listaLogins", loginService.cargarLogins());
        model.addAttribute("listaCargos", listaCargos);
        return "registro";
    }

    @RequestMapping("/registro/eliminar/{usuario}")
    public String eliminar(@PathVariable(value = "usuario") String id){
        loginService.eliminarLogin(id);
        return "redirect:/registro";
    }
}
