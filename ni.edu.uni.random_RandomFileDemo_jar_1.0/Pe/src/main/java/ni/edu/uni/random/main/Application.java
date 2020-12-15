/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ActivoFijo af = new ActivoFijo(3,"Impresora", "Laser triple toner", 1, TipoActivoFijo.COMPUTO, 720,
                    LocalDate.parse("03/03/2020", DateTimeFormatter.ofPattern("dd/M/yyyy")), ActivoFijo.EstadoActivoFijo.ACTIVO, null);
            ActivoFijoDaoImplement afDao = new ActivoFijoDaoImplement();
            int id = 1;
            
            
            //afDao.create(af);
////
//            ActivoFijo activosFijos[] = afDao.findAll();
//            
//            
//            for(ActivoFijo a : activosFijos){                
//                print(a);
//            }
//            af = afDao.findById(id);
//            
//            if (af == null) {
//                System.out.format("Activo fijo con id: %d no encontrado!\n", id);
//                return;
//            }
            
//            print(af);
//            
//            af.setNombre("Archivero");
//            af.setDescripcion("4 gavetas");            
//            af.setValor(75);            
//            afDao.update(af);
//            
//            af = afDao.findById(id);
//            print(af);
            //createEmpleado();
            EmpleadoDaoImplement eDao = new EmpleadoDaoImplement();
            id = 2;
            Empleado e = eDao.findById(id);

            if (e == null) {
                System.out.format("El empleado con id %d no se encontro!\n", id);
                return;
            }
            
            ActivoFijo activosFijos[] = afDao.findByEmpleado(e);
            if(activosFijos == null){
                System.out.println("No hay activos fijos asignados a ese empleado");
                return;
            }
            for(ActivoFijo a : activosFijos){
                print(a);
            }
//            
//            int key = afDao.asignarActivoFijo(af, e);
//            
//            if(key <= 0){
//                System.out.println("Asignacion no fue satisfactoria!");
//                return;
//            }
//            
//            af = afDao.findById(key);
//            
//            print(af);
//
//            print(e);
//            for(Empleado e : eDao.findAll() ){
//                print(e);
//            }
        } catch (IOException | IllegalArgumentException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void createEmpleado() throws IOException {
        Empleado e = new Empleado(1345, "401-100188-0022A", "Chepito", "Arias", "1111111-5",
                LocalDate.parse("03/03/2019", DateTimeFormatter.ofPattern("dd/M/yyyy")), 15120.55);
        EmpleadoDaoImplement eDao = new EmpleadoDaoImplement();

        eDao.create(e);
    }

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
