package com.latamsol.latamsol.model.dao;
import org.springframework.data.repository.CrudRepository;

import com.latamsol.latamsol.model.entidad.Categoria;

public interface ICategoriaDAO extends CrudRepository<Categoria, Long>{
    
}
