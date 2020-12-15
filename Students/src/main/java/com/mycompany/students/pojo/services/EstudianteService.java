/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.pojo.services;

import static com.mycompany.students.main.RandomApp.print;
import com.mycompany.students.pojo.Estudiante;
import com.mycompany.students.pojo.implement.EstudianteModelImpl;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class EstudianteService implements IServiceEstudiante  {
    EstudianteModelImpl estudianteModelImpl = null;
    Estudiante estudiante = null;
     private Scanner scan;
     public EstudianteService(Scanner scan) throws IOException {
        this.scan = scan;
        estudiante = new Estudiante();
        estudianteModelImpl = new EstudianteModelImpl();
     }
    @Override
    public void create() throws IOException {
        String id, Names, LastName, Carnet;
        int Age;
        scan.nextLine();
        System.out.println("Carnet");
        Carnet= scan.nextLine();
        System.out.println("Nombre");
        Names= scan.nextLine();
        System.out.println("Apellido");
        LastName= scan.nextLine();
        System.out.println("Edad");
        Age = scan.nextInt();
        estudiante = new Estudiante(0,Carnet,Names,LastName,Age);
        estudianteModelImpl.save(estudiante);
    }

    @Override
    public void findAll() throws IOException {
        System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos","Carnet", "Edad");
        for (Estudiante e : estudianteModelImpl.findAll()) {
            print(e);
        }
    }

    @Override
    public void update() throws IOException {
        int id, Age;
        String Carnet, Names, LastName;
        System.out.println("Ingrese el id del estudiante:");
        id = scan.nextInt();
        estudianteModelImpl.findById(id);
        Estudiante af = estudianteModelImpl.findById(id);
        scan.nextLine();
        System.out.println("Carnet:");
        Carnet= scan.nextLine();
        System.out.println("Nombre:");
        Names=scan.nextLine();
        System.out.println("Apellidos:");
        LastName= scan.nextLine();
        System.out.println("Edad:");
        Age= scan.nextInt();
        
        af.setId(id);
        af.setCarnet(Carnet);
        af.setNames(Names);
        af.setLastnames(LastName);
        af.setAge(Age);
        if (estudianteModelImpl.update(af)) {
            System.out.println("Estudiante actulizado");
        }
        
        
    }

    @Override
    public void BuscarId() throws IOException {
        int id;
        System.out.println("Digite Id del estudiante a buscar:");
        id = scan.nextInt();
        estudianteModelImpl.findById(id);
        System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos","Carnet", "Edad");
        Estudiante e = estudianteModelImpl.findById(id);
        print(e);
      
    }

    @Override
    public void BuscarApellido() throws IOException {
     String LastName;
      System.out.println("Digite apellido del estudiante a buscar:");
       scan.nextLine();
       LastName = scan.nextLine();

       System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos","Carnet", "Edad");
        
       estudianteModelImpl.findByLastname(LastName);
    }

    @Override
    public void BuscarCarnet() throws IOException {
        String Carnet;
        System.out.println("Digite el carnte del estudiante a buscar:");
        Carnet = scan.nextLine();
        estudianteModelImpl.findByCarnet(Carnet);
        System.out.format("%10s %20s %20s %15s %10s\n", "Id", "Nombres", "Apellidos","Carnet", "Edad");
//       for{ Estudiante e : estudianteModelImpl.findByCarnet(Carnet)) {
//            print(e);
        }

    @Override
    public void delete() throws IOException {
        int id;
        System.out.println("Digite Id del estudiante a eliminar:");
        id = scan.nextInt();

        Estudiante e = estudianteModelImpl.findById(id);
        estudianteModelImpl.delete(e);
    }
    }

 
    


