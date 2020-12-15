/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Arrays;
import java.util.Comparator;
import pojo.Estudiante;
import pojo.Notas;

/**
 *
 * @author Estudiante
 */
public class NotasModel {
    private Notas[] notas;

    public NotasModel() {
    }
    
    public void add(Notas e) {
        notas = add(e, notas);
    }

    private Notas[] add(Notas a, Notas[] as) {
        if (as == null) {
            as = new Notas[1];
            as[as.length - 1] = a;
            return as;
        }

        as = Arrays.copyOf(as, as.length + 1);
        as[as.length - 1] = a;

        return as;
    }

    public Notas[] getNotas() {
        return notas;
    }
    
    public Notas[] findByStudent(Estudiante e){
        Notas[] temp = null;
        int left, right;
        
        Arrays.sort(notas, new Comparator<Notas>() {
            @Override
            public int compare(Notas t, Notas t1) {
                return t.getEstudiante().getId() - 
                        t1.getEstudiante().getId();
            }
        });
        
        int index = Arrays.binarySearch(notas, 
                new Notas(e,null,0), 
                new Comparator<Notas>() {
            @Override
            public int compare(Notas t, Notas t1) {
                return t.getEstudiante().getId() - t1.getEstudiante().getId();
            }
        });
        
        left = right = index;
        
        while((--left) >= 0){
            if(notas[left].getEstudiante().getId() != e.getId()){
                break;
            }
            temp = add(notas[left], temp);
        }
        
        temp = add(notas[index],temp);
        
        while((++right)<= notas.length -1){
             if(notas[right].getEstudiante().getId() != e.getId()){
                break;
            }
            temp = add(notas[right], temp);
        }
        return temp;
    }
    
}
