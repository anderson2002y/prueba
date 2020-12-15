/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.pojo;

import java.time.LocalDate;

/**
 *
 * @author yasser.membreno
 */
public class ActivoFijo {
    private int id; // int
    private String nombre; //string
    private String descripcion;//string
    private int cantidad;//int
    private TipoActivoFijo clasificacion; //int
    private double valor;//double
    private LocalDate fechaCompra;//long
    private Empleado empleado;

    public ActivoFijo() {
    }

    public ActivoFijo(int id, String nombre, String descripcion, int cantidad, TipoActivoFijo clasificacion, double valor, LocalDate fechaCompra) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.clasificacion = clasificacion;
        this.valor = valor;
        this.fechaCompra = fechaCompra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public TipoActivoFijo getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(TipoActivoFijo clasificacion) {
        this.clasificacion = clasificacion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
    
    
}
