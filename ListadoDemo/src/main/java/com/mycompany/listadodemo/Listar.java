/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author LENOVO
 */

package com.mycompany.listadodemo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Listar {
 public static void main(String[] args) {
 List a1 = new ArrayList();
 a1.add("Zara");
 a1.add("Mahnaz");
 a1.add("Ayan");
 System.out.println(" Elementos de la lista a1");
 a1.forEach((name) -> {
     System.out.print("\t" + name.toString());
     });

 List l1 = new LinkedList();
 l1.add("Zara");
 l1.add("Mahnaz");
 l1.add("Ayan");
 System.out.println();
 System.out.println(" Elementos de la lista l1");
 l1.forEach((name) -> {
     System.out.print("\t" + name.toString());
     });
 System.out.println("");
 }
}