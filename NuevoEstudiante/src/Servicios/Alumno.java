/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DaoImplement.EstudianteImpl;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static nuevoestudiante.NuevoEstudiante.print;
import pojo.Estudiante;

/**
 *
 * @author LENOVO
 */
public class Alumno implements EstudianteService{
    private Scanner scan;
    private EstudianteImpl student;
    private List<Estudiante> est = new ArrayList<>();
       public Alumno(Scanner scan) throws IOException {
       this.scan = scan;
       student= new EstudianteImpl();
        
       }
       
    @Override
    public  void findByApellido() throws IOException {
        String apellidos;
       scan.nextLine();
       System.out.println("Digite el apellido a buscar");
       apellidos = scan.nextLine();
        Estudiante[] af = student.findByApellido(apellidos);
       System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos",
        "Carnet", "Edad");
        for (Estudiante e : af) {
                print(e);
                }
    }

    @Override
    public void findByNombre() throws IOException {
       String nombres;
       scan.nextLine();
       System.out.println("Digite el nombre a buscar");
       nombres = scan.nextLine();
        Estudiante[] af = student.findByNombre(nombres);
       System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos",
        "Carnet", "Edad");
        for (Estudiante e : af) {
                print(e);
                }
        
    }

    @Override
    public void finbById() throws IOException {
       int id;
       System.out.println("Digite Id del activo a buscar:");
       id = scan.nextInt();
       Estudiante af = student.finbById(id);
       System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos",
        "Carnet", "Edad");
        print(af);
                
       
    }

    @Override
    public void findByCarnet() throws IOException {
       String carnet;
       scan.nextLine();
       System.out.println("Digite el carnet a buscar");
       carnet = scan.nextLine();
       Estudiante af = student.findByCarnet(carnet);
       System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos",
        "Carnet", "Edad");
        print(af);
               
    }

    @Override
    public void save() throws IOException {
       Estudiante estudiante = null;
        
        int id, edad;
        String nombres, apellidos, carnet;         
        System.out.println("Id: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println("Nombre: ");
        nombres = scan.nextLine();
        
        System.out.println("Apellidos: ");
        apellidos = scan.nextLine();
        
        System.out.println("Carnet: ");
        carnet = scan.nextLine();
        
        System.out.println("Edad: ");
         edad = scan.nextInt();
         estudiante= new Estudiante(id, nombres, apellidos, carnet, edad);
         student.save(estudiante);

      
    }

    @Override
    public void findAll() throws IOException {
         System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos",
               "Carnet", "Edad");
                for (Estudiante e : student.findAll()) {
                print(e);
                }
        
    }

    @Override
    public void update() throws IOException {
       Estudiante estudiante = null;
        
        int id, edad;
        String nombres, apellidos, carnet;         
        System.out.println("Digite Id del activo a actualizar:");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println("Nombre: ");
        nombres = scan.nextLine();
        
        System.out.println("Apellidos: ");
        apellidos = scan.nextLine();
        
        System.out.println("Carnet: ");
        carnet = scan.nextLine();
        
        System.out.println("Edad: ");
        edad = scan.nextInt();
        estudiante= new Estudiante(id, nombres, apellidos, carnet, edad);
        student.update(estudiante);
        
    }

    @Override
    public void delete() throws IOException {
       int id;
       System.out.println("Digite Id del estudiante a eliminar:");
       id = scan.nextInt();
       student.delete(student.finbById(id));
    }
    
}
