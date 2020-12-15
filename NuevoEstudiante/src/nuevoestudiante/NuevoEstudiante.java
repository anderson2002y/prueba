/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuevoestudiante;

/**
 *
 * @author LENOVO
 */
import DaoImplement.EstudianteImpl;
import Servicios.Alumno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Estudiante;
public class NuevoEstudiante {
 public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(System.in);
    Alumno eService = new Alumno(scan);
    int opc = 0;
    do {
  
      
            menu();
            System.out.print("opc: ");
            opc = scan.nextInt();
           
            
            switch (opc) {
            case 1: {
                
                            eService.save();    
                            
                     
                }
            break;
            case 2:
            {
                eService.update();
            }
            break;
            case 3:
            {
                eService.delete();
            }
            break;
            case 4:{
                eService.finbById();
            }
            break;
            case 5:{
                eService.findByNombre();
            }
            break;
            case 6:{
                eService.findByApellido();
            }
            break;
            case 7:{
                eService.findByCarnet();
            }
            break;
            case 8: {
                    eService.findAll();
                }
            break;
            case 9: {
            System.exit(0);
            }
            break;
            default:
            System.out.println("Opcion no valida!");
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
    System.out.format("%10d %20s %20s %15s %10d\n", e.getId(), e.getNombres(),
    e.getApellidos(), e.getCarnet(), e.getEdad());
 }
}
 
 
