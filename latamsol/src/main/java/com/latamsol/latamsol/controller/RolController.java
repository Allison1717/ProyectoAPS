package com.latamsol.latamsol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latamsol.latamsol.model.entidad.Cargo;
import com.latamsol.latamsol.model.servicios.ICargoService;

@Controller
public class RolController {

    @Autowired
    private ICargoService cargoService;

    @RequestMapping("/GestionRol")
    public String cargos(Model model){
        Cargo cargo = new Cargo();
        model.addAttribute("cargo", cargo);
        model.addAttribute("listaCargos", cargoService.cargarCargos());
        return "rol";
    }

    @RequestMapping(value = "/GestionRol", method = RequestMethod.POST)
    public String guardar(Cargo cargo){
        cargoService.guardarCargo(cargo);
        return "redirect:/GestionRol";
    }

    @RequestMapping("/GestionRol/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Cargo cargo = cargoService.buscarCargo(id);
        model.addAttribute("cargo", cargo);
        model.addAttribute("listaCargos", cargoService.cargarCargos());
        return "rol";
    }

    @RequestMapping("/GestionRol/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        cargoService.eliminarCargo(id);
        return "redirect:/GestionRol";
    }
}
