package com.latamsol.latamsol.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latamsol.latamsol.model.dao.IMonedaDAO;
import com.latamsol.latamsol.model.entidad.Moneda;

@Service
public class MonedaServiceImp implements IMonedaService {

    @Autowired
    private IMonedaDAO monedaDAO;

    @Override
    public void guardarMoneda(Moneda moneda) {
        monedaDAO.save(moneda);
    }

    @Override
    public List<Moneda> cargarMonedas() {
        return (List<Moneda>) monedaDAO.findAll();
    }

    @Override
    public Moneda buscarMoneda(Long id) {
        return monedaDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarMoneda(Long id) {
        monedaDAO.deleteById(id);
    }
}
