/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alumno;
import com.mycompany.alumno.Escritura;
import com.mycompany.alumno.Lectura;
import com.mycompany.alumno.Principal;
import com.mycompany.alumno.Alumno;
/**
 *
 * @author LENOVO
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Escritura {

 public void escribir(String nombreArchivo, Alumno alumno) {
    System.out.println("Escribiendo información en el archivo");
    try {
        FileWriter fw = new FileWriter(nombreArchivo);
        //FileWriter fw = new FileWriter (nombreArchivo,true);
        BufferedWriter archivoEscritura = new BufferedWriter(fw);
        String almacenar = alumno.toString();
        archivoEscritura.write(almacenar);
        archivoEscritura.flush();
        archivoEscritura.close();
        } catch (IOException e) {
    System.out.println("Error al escribir en el archivo");
    e.printStackTrace();
    }
 }

    void escribir(String datosAlumnostxt, Alumno alumno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

