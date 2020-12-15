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
public class Empleado {
    private int id;// 4
    private int codEmpleado; // 4
    private String cedula;// 000-000000-0000U => 16 * 2 + 3 => 35
    private String nombres; // 20 => 20 * 2 + 3 => 43
    private String apellidos;// 20 => 20 * 2 + 3 => 43
    private String inss; // 0000000-0 => 9 * 2 + 3 => 21
    private LocalDate FechaContratacion;//long => 8
    private double salario;// 8

    public Empleado() {
    }

    public Empleado(int codEmpleado, String cedula, String nombres, String apellidos, String inss, LocalDate FechaContratacion, double salario) {
        this.codEmpleado = codEmpleado;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.inss = inss;
        this.FechaContratacion = FechaContratacion;
        this.salario = salario;
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
