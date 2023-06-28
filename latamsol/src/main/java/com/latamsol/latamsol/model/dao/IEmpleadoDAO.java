package com.latamsol.latamsol.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.latamsol.latamsol.model.entidad.Empleado;

public interface IEmpleadoDAO extends CrudRepository<Empleado, Long> {
    
}
