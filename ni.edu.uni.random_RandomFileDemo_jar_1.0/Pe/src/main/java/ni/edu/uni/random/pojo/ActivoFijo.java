/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.pojo;

import java.time.LocalDate;

/**
 *
 * @author yasser.membreno
 */
public class ActivoFijo {
    private int id; // int => 4
    private String nombre; //string => 30 => 60 => writeUTF => 1-3 bytes =>  63
    private String descripcion;//string => 100 => 200 => 203
    private int cantidad;//int => 4
    private TipoActivoFijo clasificacion; //int => 4
    private double valor;//double => 8
    private LocalDate fechaCompra;//long => 8
    public enum EstadoActivoFijo{
      ASIGNADO, ACTIVO, MALESTADO, REPARACION, INACTIVO    
    }
    private EstadoActivoFijo estado;//int =>  4
    private Empleado empleado; // //int => 4

    public ActivoFijo() {
    }

    public ActivoFijo(String nombre, String descripcion, int cantidad, TipoActivoFijo clasificacion, double valor, LocalDate fechaCompra, EstadoActivoFijo estado, Empleado empleado) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.clasificacion = clasificacion;
        this.valor = valor;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.empleado = empleado;
    }

    
    public ActivoFijo(int id, String nombre, String descripcion, int cantidad, TipoActivoFijo clasificacion, double valor, LocalDate fechaCompra, EstadoActivoFijo estado, Empleado empleado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.clasificacion = clasificacion;
        this.valor = valor;
        this.fechaCompra = fechaCompra;
        this.estado = estado;
        this.empleado = empleado;
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

    public EstadoActivoFijo getEstado() {
        return estado;
    }

    public void setEstado(EstadoActivoFijo estado) {
        this.estado = estado;
    }   
    
    
}
