/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.model;

import java.util.Arrays;
import ni.edu.uni.random.pojo.Empleado;

/**
 *
 * @author yasser.membreno
 */
public class EmpleadoModel {
    private Empleado empleados[];

    public EmpleadoModel() {
    }
    
    public void add(Empleado value){
        if(empleados == null){
            empleados = new Empleado[1];
            empleados[0] = value;
            return;
        }

        empleados = Arrays.copyOf(empleados, empleados.length+1);
        empleados[empleados.length - 1] = value;        
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }
    
     
    
}
