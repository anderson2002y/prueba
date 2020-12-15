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
public class NewClass {
     public static void mai(String args[]) {

 Integer[] intArra = { 1, 2, 3, 4, 5 };
 Double[] doubleArra = { 1.1, 2.2, 3.3, 4.4 };
 Character[] charArra = { 'H', 'E', 'L', 'L', 'O' };
 printArra(intArra);
 printArra(doubleArra);
 printArra(charArra);
 }
     public static < E > void printArra( E[] inputArray ) {
 // Display array elements
 for(E element : inputArray) {
 System.out.printf("%s ", element);
 }
 System.out.println();
 }
}
