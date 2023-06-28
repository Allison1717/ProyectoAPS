package com.latamsol.latamsol.model.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "servicios")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicios",nullable = false)
    private String id;
    @Column(name = "Precio",nullable = false)
    private double precio;
    @Column(name = "Cantidad_dias",nullable = false)
    private String duracion;
    @Column(name = "Detalle",nullable = true)
    private String detalle;
    
    @ManyToOne
    @JoinColumn(name = "Moneda_id_moneda", nullable = false)
    private Moneda moneda;

    public Servicio(double precio, String duracion, String detalle, Moneda moneda) {
        this.precio = precio;
        this.duracion = duracion;
        this.detalle = detalle;
        this.moneda = moneda;
    }

    public Servicio() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    
}
