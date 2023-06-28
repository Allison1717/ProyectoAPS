package com.latamsol.latamsol.model.servicios;

import java.util.List;

import com.latamsol.latamsol.model.entidad.Servicio;

public interface IServicioService {
    public void guardarServicio(Servicio servicio);
    public List<Servicio> cargarServicios();
    public Servicio buscarServicio(Long id);
    public void eliminarServicio(Long id);
}
