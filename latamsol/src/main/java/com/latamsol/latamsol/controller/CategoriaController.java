package com.latamsol.latamsol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latamsol.latamsol.model.entidad.Categoria;
import com.latamsol.latamsol.model.servicios.ICategoriaService;

@Controller
public class CategoriaController {

    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/GestionCategoria")
    public String categorias(Model model){
        Categoria categoria = new Categoria();
        model.addAttribute("categoria", categoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
        return "categoria";   
    }  

    @RequestMapping(value = "/GestionCategoria", method = RequestMethod.POST)
    public String guardar(Categoria categoria){
        categoriaService.guardarCategoria(categoria);
        return "redirect:/GestionCategoria";
    }

    @RequestMapping("/GestionCategoria/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Categoria categoria = categoriaService.buscarCategoria(id);
        model.addAttribute("categoria", categoria);
        model.addAttribute("listaCategorias", categoriaService.cargarCategorias());
        return "categoria";
    }

    @RequestMapping("/GestionCategoria/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        categoriaService.eliminarCategoria(id);
        return "redirect:/GestionCategoria";  
    }
}
