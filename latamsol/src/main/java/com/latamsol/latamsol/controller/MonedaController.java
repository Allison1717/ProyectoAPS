package com.latamsol.latamsol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latamsol.latamsol.model.entidad.Moneda;
import com.latamsol.latamsol.model.servicios.IMonedaService;

@Controller
public class MonedaController {

    @Autowired
    private IMonedaService monedaService;

    @RequestMapping("/GestionMoneda")
    public String monedas(Model model){
        Moneda moneda = new Moneda();
        model.addAttribute("moneda", moneda);
        model.addAttribute("listaMonedas", monedaService.cargarMonedas());
        return "moneda";   
    }  

    @RequestMapping(value = "/GestionMoneda", method = RequestMethod.POST)
    public String guardar(Moneda moneda){
        monedaService.guardarMoneda(moneda);
        return "redirect:/GestionMoneda";
    }

    @RequestMapping("/GestionMoneda/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Moneda moneda = monedaService.buscarMoneda(id);
        model.addAttribute("moneda", moneda);
        model.addAttribute("listaMonedas", monedaService.cargarMonedas());
        return "moneda";
    }

    @RequestMapping("/GestionMoneda/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        monedaService.eliminarMoneda(id);
        return "redirect:/GestionMoneda";  
    }
}
