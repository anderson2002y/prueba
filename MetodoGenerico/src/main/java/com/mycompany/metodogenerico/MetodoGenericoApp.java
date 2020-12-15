/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.metodogenerico;

/**
 *
 * @author LENOVO
 */
public class MetodoGenericoApp {
    public static void main(String args[]) {

 Integer[] intArray = { 1, 2, 3, 4, 5 };
 Double[] doubleArray = { 1.1, 2.2, 3.3, 4.4 };
 Character[] charArray = { 'H', 'E', 'L', 'L', 'O' };
 System.out.println("El arreglo de enteros intArray contiene: ");
 printArray(intArray);
 System.out.println("\nEl arreglo de double doubleArray contiene: ");
 printArray(doubleArray);
 System.out.println("\nEl arreglo de char charArray contiene: ");
 printArray(charArray);
 }
 public static < E > void printArray( E[] inputArray ) {
 // Display array elements
 for(E element : inputArray) {
 System.out.printf("%s ", element);
 }
 System.out.println();
 }0
}
