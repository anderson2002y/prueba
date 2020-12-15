/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import pojo.Estudiante;

/**
 *
 * @author LENOVO
 */
public class EstudianteModel {
    private Estudiante estudiante[];

    public EstudianteModel() {
    }
    
    public void add(Estudiante value){
        if(estudiante == null){
            estudiante = new Estudiante[1];
            estudiante[0] = value;
            return;
        }

        estudiante = Arrays.copyOf(estudiante, estudiante.length+1);
        estudiante[estudiante.length - 1] = value;        
    }

    public Estudiante[] getEstudiante() {
        return estudiante;
    }

    public void setActivosFijos(Estudiante[] estudiante) {
        this.estudiante = estudiante;
    }
    
    
}

