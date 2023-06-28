package com.latamsol.latamsol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latamsol.latamsol.model.entidad.Moneda;
import com.latamsol.latamsol.model.entidad.Servicio;
import com.latamsol.latamsol.model.servicios.IMonedaService;
import com.latamsol.latamsol.model.servicios.IServicioService;

@Controller
public class ServicioController {

    @Autowired
    private IServicioService servicioService;

    @Autowired
    private IMonedaService monedaService;

    @RequestMapping("/GestionServicio")
    public String servicios(Model model){
        Servicio servicio = new Servicio();
        List<Moneda> listaMonedas = monedaService.cargarMonedas();
        model.addAttribute("servicio", servicio);
        model.addAttribute("listaServicios", servicioService.cargarServicios());
        model.addAttribute("listaMonedas", listaMonedas);
        return "servicios";
    }

    @RequestMapping(value = "/GestionServicio", method = RequestMethod.POST)
    public String guardar(Servicio servicio){
        servicioService.guardarServicio(servicio);
        return "redirect:/GestionServicio";
    }

    @RequestMapping("/GestionServicio/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Servicio servicio = servicioService.buscarServicio(id);
        List<Moneda> listaMonedas = monedaService.cargarMonedas();
        model.addAttribute("servicio", servicio);
        model.addAttribute("listaServicios", servicioService.cargarServicios());
        model.addAttribute("listaMonedas", listaMonedas);
        return "servicios";
    }

    @RequestMapping("/GestionServicio/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        servicioService.eliminarServicio(id);
        return "redirect:/GestionServicio";
    }
}
