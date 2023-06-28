package com.latamsol.latamsol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latamsol.latamsol.model.entidad.Cliente;
import com.latamsol.latamsol.model.servicios.IClienteService;

@Controller
public class ClientesController {

    @Autowired
    private IClienteService clienteService;

    @RequestMapping("/clientes")
    public String clientes(Model model){
        Cliente cliente = new Cliente();
        model.addAttribute("cliente", cliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes());
        return "clientes";
    }

    @RequestMapping(value = "/clientes", method = RequestMethod.POST)
    public String guardar(Cliente cliente){
        clienteService.guardarCliente(cliente);
        return "redirect:/clientes";
    }

    @RequestMapping("/cliente/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Cliente cliente = clienteService.buscarCliente(id);
        model.addAttribute("cliente", cliente);
        model.addAttribute("listaClientes", clienteService.cargarClientes());
        return "clientes";
    }

    @RequestMapping("/cliente/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        clienteService.eliminarCliente(id);
        return "redirect:/clientes";
    }
}
