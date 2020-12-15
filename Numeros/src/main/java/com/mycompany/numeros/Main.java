/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.numeros;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class Main {
    
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el tamano del arreglo");
        int n = teclado.nextInt();
        int array []= new int[n];
        for(int i=0; i < array.length; i++){
            System.out.println("ingrese el dato: ");
            array[i]=teclado.nextInt();
        }
            int mayor, menor;
            mayor=menor=array[0];
            for (int i=0 ; i<array.length; i++){
               if(array[i]> mayor){
                   mayor= array[i];
               }
               if(array[i]< mayor){
                   menor= array[i];
               }
           }
        System.out.println("El numero mayor es "+mayor);
        System.out.println("El numero m es "+menor);
    }
}
