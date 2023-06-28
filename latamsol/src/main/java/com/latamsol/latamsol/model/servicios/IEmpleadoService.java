package com.latamsol.latamsol.model.servicios;

import java.util.List;

import com.latamsol.latamsol.model.entidad.Empleado;

public interface IEmpleadoService {
    public void guardarEmpleado(Empleado empleado);
    public List<Empleado> cargarEmpleados();
    public Empleado buscarEmpleado(Long id);
    public void eliminarEmpleado(Long id);
}
