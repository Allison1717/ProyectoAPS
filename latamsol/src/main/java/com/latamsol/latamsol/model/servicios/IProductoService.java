package com.latamsol.latamsol.model.servicios;

import java.util.List;

import com.latamsol.latamsol.model.entidad.Producto;

public interface IProductoService {
    public void guardarProducto(Producto producto);
    public List<Producto> cargarProductos();
    public Producto buscarProducto(Long id);
    public void eliminarProducto(Long id);
}
