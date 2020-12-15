/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class Listas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List <String> letras = new ArrayList <String>();
        letras.add("Anderson");
        letras.add("David");
        letras.add("Sanchez");
        letras.add("Vallecillo");
        letras.add("Master");
        Collections.sort(letras);
        for(String elemento: letras){
            System.out.println(elemento);
        }
        System.out.println();
        Collections.sort(letras, Collections.reverseOrder());
        for(String elemento: letras){
            System.out.println(elemento);
        }
        
    }
    
}
