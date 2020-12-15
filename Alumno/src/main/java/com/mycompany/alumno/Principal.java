/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.alumno;
import com.mycompany.alumno.Alumno;
import com.mycompany.alumno.Lectura;
import com.mycompany.alumno.Escritura;
/**
 *
 * @author LENOVO
 */

public class Principal {
 public static void main(String[] args) {
 Alumno alumno;
 alumno = leerAlumno();
 guardarAlumno(alumno);
 cargarAlumnos();

 }
 public static Alumno leerAlumno() {
 Alumno alumno = new Alumno();
 alumno.setNombre("Nombre del Alumno");
 alumno.setIdAlumno(1);
 alumno.setLicenciatura("Licenciatura del Alumno");
 return alumno;
 }
 public static void guardarAlumno(Alumno alumno) {
 Escritura escribir = new Escritura();
 escribir.escribir("datosAlumnos.txt", alumno);
 }
 public static void cargarAlumnos() {
 Lectura leer = new Lectura();
 leer.leer("datosAlumnos.txt");
 }
}