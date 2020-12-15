/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.main;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.edu.uni.archivos.pojo.ActivoFijo;
import ni.edu.uni.archivos.pojo.Empleado;
import ni.edu.uni.archivos.servicios.ActivoFijoService;
import ni.edu.uni.archivos.servicios.EmpleadoService;

/**
 *
 * @author yasser.membreno
 */
public class ArchivosDatosApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int opc;
        boolean flag1 = true, flag2 = true;
        Scanner scan = new Scanner(System.in);
        ActivoFijoService afService = new ActivoFijoService(scan);
        EmpleadoService eService = new EmpleadoService(scan);
        do {
            menu();
            opc = scan.nextInt();

            switch (opc) {
                case 1:
                    do {
                        menuGAFijo();
                        opc = scan.nextInt();

                        switch (opc) {
                            case 1:
                            {
                                try {
                                    afService.create();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 2:
                            {
                                try {
                                    afService.update();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 3:
                                break;
                            case 4:
                            {
                                try {
                                    afService.findAll();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 5:
                                break;
                            case 6:
                                try {
                                    afService.findByClasificacio();// case 6 para buscar activo fijo por clasificacion
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            
                                break;
                            case 7:
                            {
                                try {
                                    afService.asignarActivoFijo();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 8:
                            {
                                try {
                                    afService.findActivosFijosByEmpleado();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case 9:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Opcion no es valida!!");
                        }
                    } while (flag2);
                    break;
                case 2:
                    do {
                        menuGEmpleado();
                        opc = scan.nextInt();

                        switch (opc) {
                            case 1:
                            {
                                try {
                                    eService.create();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }                           
                                break;

                            case 2:
                                 {
                                try {
                                    eService.update();// actualizar empleado
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                            
                                break;
                            case 3:
                                break;
                            case 4:
                            {
                                try {
                                    eService.findAll();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case 5:
                                break;
                            case 6:
                                 try {
                                    eService.findByInss();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                    
                                break;
                            case 7:
                                break;
                            case 8:
                                
                               try {
                                    eService.finByCodigo();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            case 9: 
                            {
                                try {
                                    eService.findByFechaContratacion();//toma como ejemplo
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case 10:
                            {
                                try {
                                    eService.findByRangoFecha();
                                } catch (IOException ex) {
                                    Logger.getLogger(ArchivosDatosApp.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;                            
                            case 11:
                                flag2 = false;
                                break;
                            default:
                                System.out.println("Opcion no es valida!!");
                        }
                    } while (flag2);
                    break;
                case 3:
                    System.out.println("Hasta luego!!");
                    flag1 = false;
                    break;
                default:
                    System.out.println("Opcion no es valida!!");
            }
        } while (flag1);
//
    }

    public static void menu() {
        System.out.println("Menu Principal");
        System.out.println("1. Gestionar Activos Fijos.");
        System.out.println("2. Gestionar Empleados.");
        System.out.println("3. Salir.");
    }

    public static void menuGAFijo() {
        System.out.println("Menu Gestion Activo Fijo");
        System.out.println("1. Agregar Activo fijo");
        System.out.println("2. Actualiar Activo fijo");
        System.out.println("3. Eliminar Activo fijo");
        System.out.println("4. Visualizar todos");
        System.out.println("5. Buscar por Id");
        System.out.println("6. Buscar por Clasificacion");// hacerlo
        System.out.println("7. Asignar activo fijo");
        System.out.println("8. Ver activos fijos asignados por empleado");
        System.out.println("9. Retornar menu principal");
    }
    
    public static void menuGEmpleado(){
        System.out.println("Menu Gestion de empleado");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Actualizar empleado");// Hacerlo
        System.out.println("3. Eliminar empleado");
        System.out.println("4. Visualizar todos");
        System.out.println("5. Buscar por id");
        System.out.println("6. Buscar por codigo empleado");
        System.out.println("7. Buscar por Cedula");
        System.out.println("8. Buscar por Inss");
        System.out.println("9. Buscar por Fecha contratacion");
        System.out.println("10. Buscar por Rango de Fecha contratacion");                
        System.out.println("11. Retornar menu principal");
    }

    public static void subMenuTipoActivoFijo() {
        System.out.println("Seleccione una opcion");
        System.out.println("1. Vehiculo");
        System.out.println("2. Edificio");
        System.out.println("3. Equipo de Computo");
        System.out.println("4. Mobiliario");

    }

    public static void print(ActivoFijo af) {
        System.out.format("%5d %20s %20s %20s %10.2f %10d %20s \n", af.getId(), af.getNombre(),
                af.getDescripcion(), af.getClasificacion(), af.getValor(), af.getCantidad(), af.getFechaCompra().toString());
    }
    
    public static void print(Empleado e){
        System.out.format("%5d %5d %20s %20s %20s %10s %25s %5.2f\n", 
                e.getId(),e.getCodEmpleado(),e.getCedula(),e.getNombres(),e.getApellidos(),e.getInss(),e.getFechaContratacion().toString(),e.getSalario());
    }

}
