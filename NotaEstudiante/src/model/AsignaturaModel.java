/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.Comparator;
import pojo.Asignatura;

/**
 *
 * @author Estudiante
 */
public class AsignaturaModel {

    private Asignatura[] asignaturas;

    public AsignaturaModel() {
    }

    public void add(Asignatura a) {
        asignaturas = add(a, asignaturas);
    }

    private Asignatura[] add(Asignatura a, Asignatura[] as) {
        if (as == null) {
            as = new Asignatura[1];
            as[as.length - 1] = a;
            return as;
        }

        as = Arrays.copyOf(as, as.length + 1);
        as[as.length - 1] = a;

        return as;
    }

    public Asignatura[] getAsignaturas() {
        return asignaturas;
    }

    public Asignatura findById(int id) {

        int index = Arrays.binarySearch(asignaturas, 
                new Asignatura(id, null, 0), 
                new Comparator<Asignatura>() {
            @Override
            public int compare(Asignatura t, Asignatura t1) {
                return t.getId() - t1.getId();
            }
        });

        return (index < 0) ? null : asignaturas[index];
    }
    
    public void fill(){
        Asignatura a1 = new Asignatura(1, "Fisica I", 4);
        Asignatura a2 = new Asignatura(2, "Fisica II", 4);
        Asignatura a3 = new Asignatura(3, "Contabilidad Costos", 4);
        Asignatura a4 = new Asignatura(4, "Ingles II", 4);
        Asignatura a5 = new Asignatura(5, "Algebra Lineal", 4);
        Asignatura a6 = new Asignatura(6, "Programacion I", 4);
        
        add(a1);
        add(a2);
        add(a3);
        add(a4);
        add(a5);
        add(a6);
    }
}
