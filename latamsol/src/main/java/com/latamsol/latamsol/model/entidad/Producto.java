package com.latamsol.latamsol.model.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @Column(name = "Nombre_producto", nullable = false)
    private String nombre;

    @Column(name = "Precio_venta", nullable = false)
    private double preciov;

    @Column(name = "Stock", nullable = false)
    private int stock;

    @Column(name = "Precio_compra", nullable = false)
    private double precioc;

    @Column(name = "Descripcion", nullable = false)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "Categoria_id_categoria", nullable = false)
    private Categoria categoria;

    // Constructor, getters, and setters

    public Producto() {
    }

    public Producto(String nombreProducto, double precioVenta, int stock, double precioCompra, String descripcion, Categoria categoria) {
        this.nombre = nombreProducto;
        this.preciov = precioVenta;
        this.stock = stock;
        this.precioc = precioCompra;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPreciov() {
        return preciov;
    }

    public void setPreciov(double preciov) {
        this.preciov = preciov;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioc() {
        return precioc;
    }

    public void setPrecioc(double precioc) {
        this.precioc = precioc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    
}
