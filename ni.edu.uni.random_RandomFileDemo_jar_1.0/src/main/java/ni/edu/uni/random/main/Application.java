/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.edu.uni.archivos.servicios.ActivoFijoService;
import ni.edu.uni.archivos.servicios.EmpleadoService;
import ni.edu.uni.random.implement.ActivoFijoDaoImplement;
import ni.edu.uni.random.implement.EmpleadoDaoImplement;
import ni.edu.uni.random.pojo.ActivoFijo;
import ni.edu.uni.random.pojo.Empleado;
import ni.edu.uni.random.pojo.TipoActivoFijo;

/**
 *
 * @author yasser.membreno
 */
public class Application {

    private static ActivoFijo t;
    private static Empleado e;
    private static String cedula;

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
       public static void main(String[] args) throws IOException {
        int opc;
        boolean flag1 = true, flag2 = true;
        Scanner scan = new Scanner(System.in);
       // ActivoFijoService afService = new ActivoFijoService(scan);
      //  EmpleadoService eService = new EmpleadoService(scan);
        ActivoFijoDaoImplement afService = new ActivoFijoDaoImplement(scan);
        EmpleadoDaoImplement eService = new EmpleadoDaoImplement(scan);
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
                           
                                    afService.create(t);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 2:
                            {
                                try {
                                    afService.update(t);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 3:
                            {
                                try {
                                 
                                    afService.delete(t);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 4:
                            {
                                try {
                                    afService.findAll();
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 5:
                            {
                                try {
                                    afService.findById(opc);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 6:
                            {
                                try {
                                    afService.findByClasificacion(TipoActivoFijo.EDIFICIO);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 7:
                            {
                                try {
                                    afService.findByEmpleado(e);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                             case 8:
                            {
                                try {
                                    afService.asignarActivoFijo(t, e);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 9:
                            {
//                                try {
//                                    afService.findAll();
//                                } catch (IOException ex) {
//                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//                                }
                            }
                                break;

                            case 10:
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
                                    eService.create(e);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }                           
                                break;

                            case 2:
                               {
                                try {
                                    eService.update(e);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }   
                            
                                break;
                            case 3:
                             {
                                try {
                                    eService.delete(e);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }   
                                break;
                            case 4:
                            {
                                try {
                                    eService.findAll();
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case 5:
                            {
                                try {
                                    eService.findById(opc);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 6:
                            {
                                try {
                                    eService.findByCod(opc);
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 7:
                            {
                                try {
                                    eService.findByCedula(cedula);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }   
                              
                                break;
                            case 8:
                            {
                                try {
                                    eService.findByInss(cedula);
                                    
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;
                            case 9: 
                            {
                                try {
                                    eService.findByFechaContratacion(LocalDate.EPOCH);
                                } catch (IOException ex) {
                                    Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                                break;

                            case 10: 
                            {
                               // try {
                                  //  eService.
                               // } catch (IOException ex) {
                               //     Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
                               // }
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
        System.out.println("6. Buscar por Clasificacion");
        System.out.println("7. Buscar por empleado");
        System.out.println("8 Buscar por INNS");
        System.out.println("9. Ver activos fijos asignados por empleado");
        System.out.println("10. Cambiar estado de activo fijo");
        System.out.println("12. Retornar menu principal");
    }
    
    public static void menuGEmpleado(){
        System.out.println("Menu Gestion de empleado");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Actualizar empleado");
        System.out.println("3. Eliminar empleado");
        System.out.println("4. Visualizar todos");
        System.out.println("5. Buscar por id");
        System.out.println("6. Buscar por codigo empleado");
        System.out.println("7. Buscar por Cedula");
        System.out.println("8. Buscar por Inss");
        System.out.println("9. Buscar por Fecha contratacion");                
        System.out.println("10. Retornar menu principal");
    }

    public static void subMenuTipoActivoFijo() {
        System.out.println("Seleccione una opcion");
        System.out.println("1. Vehiculo");
        System.out.println("2. Edificio");
        System.out.println("3. Equipo de Computo");
        System.out.println("4. Mobiliario");
    }
//    public static void main(String[] args) {
//        try {
//            ActivoFijo af = new ActivoFijo(3,"Impresora", "Laser triple toner", 1, TipoActivoFijo.COMPUTO, 720,
//                    LocalDate.parse("03/03/2020", DateTimeFormatter.ofPattern("dd/M/yyyy")), ActivoFijo.EstadoActivoFijo.ACTIVO, null);
//            ActivoFijoDaoImplement afDao = new ActivoFijoDaoImplement();
//            int id = 1;
//            
//            
//            //afDao.create(af);
//////
////            ActivoFijo activosFijos[] = afDao.findAll();
////            
////            
////            for(ActivoFijo a : activosFijos){                
////                print(a);
////            }
////            af = afDao.findById(id);
////            
////            if (af == null) {
////                System.out.format("Activo fijo con id: %d no encontrado!\n", id);
////                return;
////            }
//            
////            print(af);
////            
////            af.setNombre("Archivero");
////            af.setDescripcion("4 gavetas");            
////            af.setValor(75);            
////            afDao.update(af);
////            
////            af = afDao.findById(id);
////            print(af);
//            //createEmpleado();
//            EmpleadoDaoImplement eDao = new EmpleadoDaoImplement();
//            id = 2;
//            Empleado e = eDao.findById(id);
//
//            if (e == null) {
//                System.out.format("El empleado con id %d no se encontro!\n", id);
//                return;
//            }
//            
//            ActivoFijo activosFijos[] = afDao.findByEmpleado(e);
//            if(activosFijos == null){
//                System.out.println("No hay activos fijos asignados a ese empleado");
//                return;
//            }
//            for(ActivoFijo a : activosFijos){
//                print(a);
//            }
////            
////            int key = afDao.asignarActivoFijo(af, e);
////            
////            if(key <= 0){
////                System.out.println("Asignacion no fue satisfactoria!");
////                return;
////            }
////            
////            af = afDao.findById(key);
////            
////            print(af);
////
////            print(e);
////            for(Empleado e : eDao.findAll() ){
////                print(e);
////            }
//        } catch (IOException | IllegalArgumentException ex) {
//            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    public static void createEmpleado() throws IOException {
//        Empleado e = new Empleado(1345, "401-100188-0022A", "Chepito", "Arias", "1111111-5",
//                LocalDate.parse("03/03/2019", DateTimeFormatter.ofPattern("dd/M/yyyy")), 15120.55);
//        EmpleadoDaoImplement eDao = new EmpleadoDaoImplement();
//
//        eDao.create(e);
//    }

    public static void print(ActivoFijo af) {
        System.out.format("%5d %20s %40s %20s %10.2f %10d %20s %20s\n", af.getId(), af.getNombre(),
                af.getDescripcion(), af.getClasificacion(), af.getValor(), af.getCantidad(), af.getFechaCompra().toString(), (af.getEmpleado() == null) ? "empty" : af.getEmpleado().getNombres());
    }

    public static void print(Empleado e) {
        System.out.format("%5d %5d %20s %20s %20s %20s %20s %10.2f \n", e.getId(), e.getCodEmpleado(),
                e.getCedula(), e.getNombres(), e.getApellidos(), e.getInss(),
                e.getFechaContratacion().toString(), e.getSalario());
    }

}
