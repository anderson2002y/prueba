/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class ListApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        
        names.add("Pepito");
        names.add("Ana");
        names.add("Paul");
        names.add("Elena");
        names.add("Juan");
        
        for(String n : names){
            System.out.println("Nombre: " + n);
        }
        System.out.println("===============================");
        Collections.sort(names);
        Iterator it = names.iterator();
        while(it.hasNext()){
            System.out.println("Nombre: " + it.next());
        }
        System.out.println("===============================");
        Collections.reverse(names);
        names.stream().forEach(n-> System.out.println("Nombre: " + n));
    }
}
