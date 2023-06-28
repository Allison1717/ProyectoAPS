package com.latamsol.latamsol.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latamsol.latamsol.model.dao.IServicioDAO;
import com.latamsol.latamsol.model.entidad.Servicio;

@Service
public class ServicioServiceImp implements IServicioService {

    @Autowired
    private IServicioDAO servicioDAO;

    @Override
    public void guardarServicio(Servicio servicio) {
        servicioDAO.save(servicio);
    }

    @Override
    public List<Servicio> cargarServicios() {
        return (List<Servicio>) servicioDAO.findAll();
    }

    @Override
    public Servicio buscarServicio(Long id) {
        return servicioDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarServicio(Long id) {
        servicioDAO.deleteById(id);
    }
}
