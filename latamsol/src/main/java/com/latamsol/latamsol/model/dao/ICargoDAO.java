package com.latamsol.latamsol.model.dao;
import org.springframework.data.repository.CrudRepository;

import com.latamsol.latamsol.model.entidad.Cargo;

public interface ICargoDAO extends CrudRepository<Cargo, Long>{
    
}
