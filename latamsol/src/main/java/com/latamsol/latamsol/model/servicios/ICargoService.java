package com.latamsol.latamsol.model.servicios;

import java.util.List;

import com.latamsol.latamsol.model.entidad.Cargo;

public interface ICargoService {
    public void guardarCargo(Cargo cargo);
    public List<Cargo> cargarCargos();
    public Cargo buscarCargo(Long id);
    public void eliminarCargo(Long id);
}
