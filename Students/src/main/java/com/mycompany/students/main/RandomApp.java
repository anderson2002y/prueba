/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.main;

/**
 *
 * @author LENOVO
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mycompany.students.pojo.Estudiante;
import com.mycompany.students.pojo.implement.EstudianteModelImpl;
import com.mycompany.students.pojo.services.EstudianteService;

public class RandomApp {
    public static void main(String[] args) throws IOException {
        Estudiante estudiante = null;
        EstudianteModelImpl eimpl = null;
        Scanner scan = new Scanner(System.in);
        EstudianteService estudianteService = new EstudianteService(scan);
        int opc = 0, i = 1;
        do {
        try {
        menu();
        System.out.print("opc: ");
        opc = scan.nextInt();
        eimpl = new EstudianteModelImpl();
        switch (opc) {
        case 1:{
            estudianteService.create();
            }
        break;
        case 2:
        {
            estudianteService.update();
        }
        break;
        case 3:
        {
            estudianteService.delete();
        }
        break;
        case 4:
        {
            estudianteService.BuscarId();
        }
        break;
        case 5:
            
        break;
        case 6:
        {
            estudianteService.BuscarApellido();
        }
        break;
        case 7:
        {
            estudianteService.BuscarCarnet();
        }
        break;
        case 8:{
            estudianteService.findAll();

            }
        
            break;
        case 9:{
            System.exit(0);
            }
            break;
        default:
        System.out.println("Opcion no valida!");
        }
        } catch (FileNotFoundException ex) {
        Logger.getLogger(RandomApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
        Logger.getLogger(RandomApp.class.getName()).log(Level.SEVERE, null, ex);
        }
        } while (opc != 9);
         }
    public static void menu() {
        System.out.println("Menu de Opciones para el manejo de Estudiantes");
        System.out.println("1. Registrar Estudiante");
        System.out.println("2. Editar Estudiante");
        System.out.println("3. Eliminar Estudiante");
        System.out.println("4. Buscar Estudiante por Id");
        System.out.println("5. Buscar Estudiante por Nombres");
        System.out.println("6. Buscar Estudiante por Apellidos");
        System.out.println("7. Buscar Estudiante por carnet");
        System.out.println("8. Listar todos Estudiantes");
        System.out.println("9. Salir");
        }
    public static void print(Estudiante e) {
        System.out.format("%10s %20s %20s %15s %10s\n", String.valueOf(e.getId()),
        e.getNames(), e.getLastnames(), e.getCarnet(), String.valueOf(e.getAge()));
        }
}

