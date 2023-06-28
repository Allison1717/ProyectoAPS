package com.latamsol.latamsol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latamsol.latamsol.model.entidad.Cargo;
import com.latamsol.latamsol.model.entidad.Empleado;
import com.latamsol.latamsol.model.entidad.Login;
import com.latamsol.latamsol.model.servicios.ICargoService;
import com.latamsol.latamsol.model.servicios.IEmpleadoService;
import com.latamsol.latamsol.model.servicios.ILoginService;

@Controller
public class EmpleadosController {

    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private ICargoService cargoService;

    @Autowired
    private ILoginService loginService;

    @RequestMapping("/empleados")
    public String empleados(Model model){
        Empleado empleado = new Empleado();
        List<Cargo> listaCargos = cargoService.cargarCargos();
        List<Login> listaLogins = loginService.cargarLogins();
        model.addAttribute("empleado", empleado);
        model.addAttribute("listaEmpleados", empleadoService.cargarEmpleados());
        model.addAttribute("listaCargos", listaCargos);
        model.addAttribute("listaLogins", listaLogins);
        return "empleados";
    }

    @RequestMapping(value = "/empleados", method = RequestMethod.POST)
    public String guardar(Empleado empleado){
        empleadoService.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @RequestMapping("/empleados/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Empleado empleado = empleadoService.buscarEmpleado(id);
        List<Cargo> listaCargos = cargoService.cargarCargos();
        List<Login> listaLogins = loginService.cargarLogins();
        model.addAttribute("empleado", empleado);
        model.addAttribute("listaEmpleados", empleadoService.cargarEmpleados());
        model.addAttribute("listaCargos", listaCargos);
        model.addAttribute("listaLogins", listaLogins);
        return "empleados";
    }

    @RequestMapping("/empleados/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        empleadoService.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
