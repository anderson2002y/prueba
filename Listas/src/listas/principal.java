/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.ArrayList;
import java.util.List;
import listas.persona;
/**
 *
 * @author LENOVO
 */
public class principal {
    public static void main(String[] args) {
        persona p1 = new persona("Pablo", "Morales",5);
        persona p2 = new persona("Alejandra", "Sanchez",43);
        List<persona> personas = new ArrayList<persona>();
        personas.add(p1);
        personas.add(p2);
        
        for(persona elemento: personas){
            System.out.println(elemento);        }
        }
    }
    

