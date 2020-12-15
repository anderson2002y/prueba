/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.Comparator;
import pojo.Asignatura;
import pojo.Estudiante;

/**
 *
 * @author Estudiante
 */
public class EstudianteModel {
    private Estudiante[] estudiantes;

    public EstudianteModel() {
    }
    
    public void add(Estudiante e) {
        estudiantes = add(e, estudiantes);
    }

    private Estudiante[] add(Estudiante a, Estudiante[] as) {
        if (as == null) {
            as = new Estudiante[1];
            as[as.length - 1] = a;
            return as;
        }

        as = Arrays.copyOf(as, as.length + 1);
        as[as.length - 1] = a;

        return as;
    }
    
     public Estudiante findById(int id) {

        int index = Arrays.binarySearch(estudiantes, 
                new Estudiante(id, "", "",""), 
                new Comparator<Estudiante>() {
            @Override
            public int compare(Estudiante t, Estudiante t1) {
                return t.getId() - t1.getId();
            }
        });

        return (index < 0) ? null : estudiantes[index];
    }
     
    public void fill(){
        Estudiante e1 = new Estudiante(1, "2015-1025U", "Pepito", "Perez");
        Estudiante e2 = new Estudiante(2, "2016-1025U", "Ana", "Conda");
        Estudiante e3 = new Estudiante(3, "2017-1025U", "Lucy", "Fer");
        
        add(e1);
        add(e2);
        add(e3);
    }
}
