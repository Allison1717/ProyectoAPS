package com.latamsol.latamsol.model.dao;
import org.springframework.data.repository.CrudRepository;

import com.latamsol.latamsol.model.entidad.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{
    
}
