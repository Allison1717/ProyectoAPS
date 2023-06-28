package com.latamsol.latamsol.model.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.latamsol.latamsol.model.dao.IEmpleadoDAO;
import com.latamsol.latamsol.model.entidad.Empleado;

@Service
public class EmpleadoServiceImp implements IEmpleadoService {

    @Autowired
    private IEmpleadoDAO empleadoDAO;

    @Override
    public void guardarEmpleado(Empleado empleado) {
        empleadoDAO.save(empleado);
    }

    @Override
    public List<Empleado> cargarEmpleados() {
        return (List<Empleado>) empleadoDAO.findAll();
    }

    @Override
    public Empleado buscarEmpleado(Long id) {
        return empleadoDAO.findById(id).orElse(null);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoDAO.deleteById(id);
    }
}
