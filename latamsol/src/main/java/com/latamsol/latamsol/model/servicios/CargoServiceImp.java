package com.latamsol.latamsol.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latamsol.latamsol.model.dao.ICargoDAO;
import com.latamsol.latamsol.model.entidad.Cargo;

@Service
public class CargoServiceImp implements ICargoService {

    @Autowired
    private ICargoDAO cargoDAO;

    @Override
    public void guardarCargo(Cargo cargo) {
        cargoDAO.save(cargo);
    }

    @Override
    public List<Cargo> cargarCargos() {
        return (List<Cargo>) cargoDAO.findAll();
    }

    @Override
    public Cargo buscarCargo(Long id) {
        return cargoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarCargo(Long id) {
        cargoDAO.deleteById(id);
    }
}
