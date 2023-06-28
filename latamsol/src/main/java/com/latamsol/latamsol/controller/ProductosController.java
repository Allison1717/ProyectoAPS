package com.latamsol.latamsol.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latamsol.latamsol.model.entidad.Categoria;
import com.latamsol.latamsol.model.entidad.Producto;
import com.latamsol.latamsol.model.servicios.ICategoriaService;
import com.latamsol.latamsol.model.servicios.IProductoService;

@Controller
public class ProductosController {

    @Autowired
    private IProductoService productoService;

    @Autowired
    private ICategoriaService categoriaService;

    @RequestMapping("/productos")
    public String productos(Model model){
        Producto producto = new Producto();
        List<Categoria> listaCategorias = categoriaService.cargarCategorias();
        model.addAttribute("producto", producto);
        model.addAttribute("listaProductos", productoService.cargarProductos());
        model.addAttribute("listaCategorias", listaCategorias);
        return "productos";
    }

    @RequestMapping(value = "/productos", method = RequestMethod.POST)
    public String guardar(Producto producto){
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    @RequestMapping("/productos/editar/{id}")
    public String editar(@PathVariable(value = "id") Long id, Model model){
        Producto producto = productoService.buscarProducto(id);
        List<Categoria> listaCategorias = categoriaService.cargarCategorias();
        model.addAttribute("producto", producto);
        model.addAttribute("listaProductos", productoService.cargarProductos());
        model.addAttribute("listaCategorias", listaCategorias);
        return "productos";
    }

    @RequestMapping("/productos/eliminar/{id}")
    public String eliminar(@PathVariable(value = "id") Long id){
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }
}
