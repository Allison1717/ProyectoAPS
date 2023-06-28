package com.latamsol.latamsol.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latamsol.latamsol.model.dao.IProductoDAO;
import com.latamsol.latamsol.model.entidad.Producto;

@Service
public class ProductoServiceImp implements IProductoService {

    @Autowired
    private IProductoDAO productoDAO;

    @Override
    public void guardarProducto(Producto producto) {
        productoDAO.save(producto);
    }

    @Override
    public List<Producto> cargarProductos() {
        return (List<Producto>) productoDAO.findAll();
    }

    @Override
    public Producto buscarProducto(Long id) {
        return productoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarProducto(Long id) {
        productoDAO.deleteById(id);
    }
}
