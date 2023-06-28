package com.latamsol.latamsol.model.servicios;

import java.util.List;

import com.latamsol.latamsol.model.entidad.Categoria;

public interface ICategoriaService {
    public void guardarCategoria(Categoria categoria);
    public List<Categoria> cargarCategorias();
    public Categoria buscarCategoria(Long id);
    public void eliminarCategoria(Long id);
}
