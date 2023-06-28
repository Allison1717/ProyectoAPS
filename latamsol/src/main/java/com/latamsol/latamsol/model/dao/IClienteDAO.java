package com.latamsol.latamsol.model.dao;
import org.springframework.data.repository.CrudRepository;

import com.latamsol.latamsol.model.entidad.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{
    
}
