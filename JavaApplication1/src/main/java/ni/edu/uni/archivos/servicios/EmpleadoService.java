/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.servicios;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import ni.edu.uni.archivos.implementation.EmpleadoDaoImplement;
import ni.edu.uni.archivos.main.ArchivosDatosApp;
import ni.edu.uni.archivos.model.EmpleadoModel;
import ni.edu.uni.archivos.pojo.ActivoFijo;
import ni.edu.uni.archivos.pojo.Empleado;
import ni.edu.uni.archivos.pojo.TipoActivoFijo;

/**
 *
 * @author yasser.membreno
 */
public class EmpleadoService implements IServices<Empleado>{
    private Scanner scan;
    private EmpleadoDaoImplement eDao;
    private EmpleadoModel eModel;

    public EmpleadoService(Scanner scan) {
        this.scan = scan;
        eDao = new EmpleadoDaoImplement();                
    }
   
    @Override
    public void create() throws IOException {
        int id, cod;
        String cedula, nombres, apellidos, inss, fecha;
        double salario;
        
        System.out.println("id: ");
        id = scan.nextInt();
        
        System.out.println("Codigo empleado: ");
        cod = scan.nextInt();
        
        scan.nextLine();
        
        System.out.println("Cedula: ");
        cedula = scan.nextLine();
        
        System.out.println("Nombre: ");
        nombres = scan.nextLine();
        
        System.out.println("Apellidos: ");
        apellidos = scan.nextLine();
        
        System.out.println("INSS: ");
        inss = scan.nextLine();
        
        System.out.println("Fecha de contratacion [dd/mm/yyyy]");
        fecha = scan.next();
        
        System.out.println("Salario: ");
        salario = scan.nextDouble();
        
        Empleado e = new Empleado(id, cod, cedula, nombres, apellidos, inss,
                LocalDate.parse(fecha,DateTimeFormatter.ofPattern("dd/M/yyyy") ), salario);
        
        eDao.create(e);
        System.out.println("El empleado se guardo satisfactoriamente!");
        
    }
    @Override
    public int update() throws IOException {
        int id, cod;
        String cedula, nombres, apellidos, inss, fecha;
        double salario;
        
         System.out.println("Digite Id del empleado a actualizar:");
        id = scan.nextInt();
        Empleado e = eDao.findById(id);
        
        scan.nextLine();
        
        System.out.println("id: ");
        id = scan.nextInt();
       
        
        System.out.println("Codigo empleado: ");
        cod = scan.nextInt();
        
        scan.nextLine();
        
        System.out.println("Cedula: ");
        cedula = scan.nextLine();
        
        System.out.println("Nombre: ");
        nombres = scan.nextLine();
        
        System.out.println("Apellidos: ");
        apellidos = scan.nextLine();
        
        System.out.println("INSS: ");
        inss = scan.nextLine();
        
        System.out.println("Fecha de contratacion [dd/mm/yyyy]");
        fecha = scan.next();
        
        System.out.println("Salario: ");
        salario = scan.nextDouble();
        
      
        e.setId(id);
        e.setCodEmpleado(cod);
        e.setCedula(cedula);
        e.setNombres(nombres);
        e.setApellidos(apellidos);
        e.setInss(inss);
        e.setFechaContratacion(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/M/yyyy")));
        e.setSalario(salario);
        id =  eDao.update(e);
        
        return id;
        
    }
    //@Override
    //public int update() throws IOException {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    @Override
    public boolean delete() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void findAll() throws IOException {
        printHeader();
        for(Empleado e : eDao.findAll()){
            ArchivosDatosApp.print(e);
        }
        
    }
    
    private void printHeader(){
        System.out.format("%5s %5s %20s %20s %20s %10s %25s %5s\n", 
                "Id","Codigo","Cedula","Nombres","Apellidos","Inss","Fecha de contratacion","Salario");
    }
    
    public void findByFechaContratacion() throws IOException{
        String fecha;
        eModel = new EmpleadoModel();
        System.out.println("Fecha de contratacion [dd/mm/yyyy]");
        fecha = scan.next();
        
        eModel.setEmpleados(eDao.findByFechaContratacion(LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/M/yyyy"))));
        if(eModel.getEmpleados() == null){
            System.out.println("No se encontraron Empleados en ese rango de fecha!");
            return;
        }
        printHeader();
        for(Empleado e : eModel.getEmpleados()){
            ArchivosDatosApp.print(e);
        }
    }
    
    public void findByRangoFecha() throws IOException{
        String fechaInicial, fechaFinal;        
        eModel = new EmpleadoModel();
        
        System.out.println("Fecha inicial [dd/mm/yyyy]");
        fechaInicial = scan.next();
        
        System.out.println("Fecha final [dd/mm/yyyy]");
        fechaFinal = scan.next();
        
        eModel.setEmpleados(eDao.findByRangoFecha(
                LocalDate.parse(fechaInicial, DateTimeFormatter.ofPattern("dd/M/yyyy")), 
                LocalDate.parse(fechaFinal, DateTimeFormatter.ofPattern("dd/M/yyyy"))
        ));
        if(eModel.getEmpleados() == null){
            System.out.println("No se encontraron Empleados en ese rango de fecha!");
            return;
        }
        printHeader();
        for(Empleado e : eModel.getEmpleados()){
            ArchivosDatosApp.print(e);
        }
    }

    public void findByInss() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
   
}
