package com.latamsol.latamsol.model.dao;
import org.springframework.data.repository.CrudRepository;

import com.latamsol.latamsol.model.entidad.Login;

public interface ILoginDAO extends CrudRepository<Login, String>{

}
