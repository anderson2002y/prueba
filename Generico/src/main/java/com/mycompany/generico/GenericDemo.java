/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.generico;

/**
 *
 * @author LENOVO
 */
public class GenericDemo {
    public static void Main (String args[]){
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1. 2.2, 3.3, 4.4, 5.5};
        
        Character[] charArray = {"H","E","L","L","0"};
        String[] stringArray = "Buenos dias";
        printfArray(intArray);
        printfArray(doubleArray);
        printfArray(charArray);
        printfArray(stringArray);
    }
    public static <E> void printArray(E[]array){
        System.out.format("[");
        For(E e : array){
        System.out.format("]\n")
    }
    }
}