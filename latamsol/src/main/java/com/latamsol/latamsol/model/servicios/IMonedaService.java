package com.latamsol.latamsol.model.servicios;

import java.util.List;

import com.latamsol.latamsol.model.entidad.Moneda;

public interface IMonedaService {
    public void guardarMoneda(Moneda moneda);
    public List<Moneda> cargarMonedas();
    public Moneda buscarMoneda(Long id);
    public void eliminarMoneda(Long id);
}
