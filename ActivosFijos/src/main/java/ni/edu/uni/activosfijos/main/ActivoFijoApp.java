/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.activosfijos.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import ni.edu.uni.activosfijos.pojo.ActivoFijo;
import ni.edu.uni.activosfijos.pojo.TipoActivoFijo;

/**
 *
 * @author yasser.membreno
 */
public class ActivoFijoApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ActivoFijo activosFijos[] = null;
        int opc;
        double depreciaciones[][] = null;
        Scanner scan = new Scanner(System.in);
        
        
        do{
            menu();
            opc = scan.nextInt();

            switch(opc){
                case 1:                        
                        activosFijos = add(activosFijos,readData(scan));
                        break;
                case 2:
                        if(activosFijos == null){
                            System.out.println("No hay elementos para imprimir!!");
                            return;
                        }
                        System.out.format("%5s %20s %20s %20s %10s %10s %20s \n","Id","Nombre","Descripcion","Clasificacion","Valor",
                                "Cantidad","Fecha de compra");
                        for(ActivoFijo af : activosFijos){
                            print(af);
                        }
                        
                        break;
                case 3:
                        do{
                            subMenuTipoDepreciacion();
                            opc = scan.nextInt();
                        }while(opc < 1 || opc > 3);
                        
                        switch(opc){
                            case 1:
                                    if(activosFijos == null){
                                        return;
                                    }
                                    depreciaciones = new double[activosFijos.length + 1][20];
                                    int i = 0;
                                    for(ActivoFijo af : activosFijos){
                                        depreciaciones[i++] = lineaRecta(af);
                                    }
                                    
                                    for(int j=0; j<depreciaciones.length - 1;j++){
                                        for(int k=0; k<depreciaciones[j].length;k++){
                                            depreciaciones[depreciaciones.length - 1][k] += depreciaciones[j][k]; 
                                        }
                                    }
                                    printDeprecicacion(activosFijos, depreciaciones);
                                    break;
                                    
                            case 2:
                                break;
                        }
                        break;
                case 4:
                    System.exit(0);
                default:
            }
        }while(true);
        
        
    }
    
    public static void menu(){
        System.out.println("Menu de opciones:");
        System.out.println("1. Agregar Activo fijo");
        System.out.println("2. Visualizar todos");
        System.out.println("3. Calcular depreciacion de todos");
        System.out.println("4. Salir");
    }
    
    public static void subMenuTipoDepreciacion(){
        System.out.println("Seleccione una opcion");
        System.out.println("1. Linea recta");
        System.out.println("2. SDA incremental");
        System.out.println("3. Regresar al menu principal");
    }
    
    public static void subMenuTipoActivoFijo(){
        System.out.println("Seleccione una opcion");
        System.out.println("1. Vehiculo");
        System.out.println("2. Edificio");
        System.out.println("3. Equipo de Computo");
        System.out.println("4. Mobiliario");
        
    }
    
    public static ActivoFijo readData(Scanner scan){
        int id, cantidad,clasificacion;
        String nombre, descripcion, fechaCompra;         
        double valor;
        
        
        System.out.println("codigo: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println("Nombre: ");
        nombre = scan.nextLine();
        
        System.out.println("Descripcion: ");
        descripcion = scan.nextLine();
        
        System.out.println("Valor del activo: ");
        valor = scan.nextDouble();
        
        System.out.println("Cantidad: ");
        cantidad = scan.nextInt();
        
        do{
            subMenuTipoActivoFijo();
            clasificacion = scan.nextInt();
        }while(clasificacion < 1 || clasificacion > 4);
        
        System.out.println("Fecha de compra [dd/mm/yyyy]");
        fechaCompra = scan.next();
        
        return new ActivoFijo(id, nombre, descripcion, cantidad, TipoActivoFijo.values()[clasificacion - 1] , valor, 
                LocalDate.parse(fechaCompra, DateTimeFormatter.ofPattern("dd/M/yyyy")));
        
        
    }
    
    public static void print(ActivoFijo af){
        System.out.format("%5d %20s %20s %20s %10.2f %10d %20s \n",af.getId(),af.getNombre(),
                af.getDescripcion(),af.getClasificacion(),af.getValor(),af.getCantidad(), af.getFechaCompra().toString());
    }
    
    public static void printDeprecicacion(ActivoFijo[] activos, double dep[][]){
        for(int i=0; i<dep.length;i++){
            if(i == activos.length){
                System.out.format("%10s","Total");
            }else{
                System.out.format("%10s",activos[i].getNombre());
            }            
            for(int j=0;j<dep[i].length;j++){
                System.out.format("%10.2f",dep[i][j]);
            }
            System.out.println("");
        }
    }
    
    public static ActivoFijo[] add(ActivoFijo vector[], ActivoFijo value){
        if(vector == null){
            vector = new ActivoFijo[1];
            vector[0] = value;
            return vector;
        }

        ActivoFijo tmp[] = Arrays.copyOf(vector, vector.length+1);
        tmp[tmp.length - 1] = value;

        return tmp;
    }
    
    public static double[] lineaRecta(ActivoFijo af){
        int anos = af.getClasificacion().getAnos();
        double lr[] = new double[anos];
        
        for(int i = 1; i <= anos; i++){
            lr[i - 1] = af.getValor() / anos;
        }
        return lr;
    }
    
    public static double[] SDA(ActivoFijo af){
        int factor;
        int anos = af.getClasificacion().getAnos();
        factor = anos * (anos + 1)/2;
        double sda[] = new double[anos];
        
        for(int i = 1; i <= anos; i++){
            sda[i -1] = i/factor * af.getValor();
        }
        
        return sda;
    }
    
}
