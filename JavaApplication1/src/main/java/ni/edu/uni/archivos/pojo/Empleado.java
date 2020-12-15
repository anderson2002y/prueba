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
public class Empleado {
    private int id;
    private int codEmpleado;
    private String cedula;
    private String nombres;
    private String apellidos;
    private String inss;
    private LocalDate FechaContratacion;
    private double salario;

    public Empleado() {
    }

    public Empleado(int id, int codEmpleado, String cedula, String nombres, String apellidos, String inss, LocalDate FechaContratacion, double salario) {
        this.id = id;
        this.codEmpleado = codEmpleado;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.inss = inss;
        this.FechaContratacion = FechaContratacion;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getInss() {
        return inss;
    }

    public void setInss(String inss) {
        this.inss = inss;
    }

    public LocalDate getFechaContratacion() {
        return FechaContratacion;
    }

    public void setFechaContratacion(LocalDate FechaContratacion) {
        this.FechaContratacion = FechaContratacion;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
