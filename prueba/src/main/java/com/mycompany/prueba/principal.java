/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class principal {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Coche> coches = new ArrayList();
    public static void main(String[]args)
    {
        leerCoches();
        System.out.println("Coches introducidos:");
        mostrarCoches();
  
    }
    public static void leerCoches()
    {
        String matricula, color;
        int anos;
        Coche aux;
        int i, N = 0;
        
            System.out.println("Numero de coches");
            N = sc.nextInt();
        
       sc.nextLine();
        for (i = 1; i <= N;i++)
        {
            System.out.println("Coche: "+i);
            System.out.println("Matricula: ");
            matricula = sc.nextLine();
            System.out.println("Color: ");
            color = sc.nextLine();
            System.out.println("Anos: ");
            anos = sc.nextInt();
            sc.nextLine();
            
            aux = new Coche();// objteto coche se le asgna un auxiliar
            aux.setMatricula(matricula);
            aux.setColor(color);
            aux.setColor(color);
            coches.add(aux);//se anade objeto final al array
        }
    }
    
    public static void mostrarCoches()
    {
        for(int i=0; i< coches.size(); i++)
            System.out.println(coches.get(i));
    }
}
