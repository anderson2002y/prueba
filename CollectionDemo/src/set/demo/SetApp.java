/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package set.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Estudiante
 */
public class SetApp {
    public static void main(String[] args) {
        Map<Integer,String> casillero = new HashMap<>();
        Set<Integer> edades = new HashSet<>();
        Map<Integer,Set<Integer>> setInteger = new HashMap<>();
        
        setInteger.put(1, edades);
        casillero.put(1, "Pepito");
        casillero.put(2, "Ana");
        
        for(String v : casillero.values()){
            System.out.println("Nombre: " + v);
        }
        System.out.println("================================");
        
        String value = casillero.get(2);

        System.out.println("Nombre: " + value);
        
        Set<Integer> e = setInteger.get(1);
        
//        Integer value = 30;
        edades.add(16);
//        edades.add(18);
//        edades.add(25);
//        edades.add(5);
//        edades.add(value);
//        edades.add(value);
//        
//        Iterator it = edades.iterator();
//        while(it.hasNext()){
//            System.out.println("Edad: " + it.next()); 
//        } 
//        List<Integer> ledades = Arrays.
//                asList(edades.toArray(new Integer[0]));
//        Collections.sort(ledades);
//        System.out.println("================================");
//        for(Integer i : ledades){
//            System.out.println("Edad: " + i);
//        }
//        System.out.println("================================");
//        Collections.reverse(ledades);
//        for(Integer i : ledades){
//            System.out.println("Edad: " + i);
//        }
    }
}
