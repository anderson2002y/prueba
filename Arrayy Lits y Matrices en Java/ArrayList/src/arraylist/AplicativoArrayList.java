 
package arraylist;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class AplicativoArrayList 
{
    public static String Dat[];
    public static void main(String[] args) 
    {
        Scanner Datos =new Scanner(System.in);
        List listas=new ArrayList();  
        int limite;String buscar;String elem;int resp;
        boolean flag1;
        flag1 = true;
        int opcion ;
        do{
        
        MostrarMenu();
        opcion=Datos.nextInt();
        switch (opcion) 
        {
                case 1:
                     {
                        System.out.println("Ingrese la Cantidad de nombres a almacenar");
                        limite=Datos.nextInt();
                        Dat=new String[limite];
                        ///Rellenar el ArrayList
                         AlmacenarElementosArrayList(Dat, listas, Datos);
                         System.out.println("");       
                       }
                         break;
                case 2:
                     {
                        ///mostrar Elementos del ArrayList
                        System.out.println("");
                        System.out.println(" Se encuentran "+listas.size()+" nombres en la lista");
                        MostrarElementosArrayList(listas);
                        System.out.println("");    
                       }
                         break;
                case 3:
                     {
                       System.out.println("Ingrese el nombre a eliminar ");
                       buscar=Datos.next();
                       if(BuscarElemento(listas, buscar))
                        {
                        System.out.println("Elemento encontrado y eliminado");
                         }else{
                         System.out.println("Elemento no existe");
                          }
                        System.out.println("");     
                       }
                         break;
                
                case 4:
                     {
                        System.out.println("Lista ordenada!");
                        Ordenar(listas);
                        System.out.println("");       
                      }
                         break;
                case 5:
                     {
                        System.out.println("Hasta luego!!");
                         flag1 = false; 
                                
                      }
                         break;
                default:
                {
                System.out.println("Opcion no es valida!!");
                }
        }
       
        }while(flag1);
    }
    public static void AlmacenarElementosArrayList(String Array[],List list,
            Scanner sc){
        for(int i=0;i<Array.length;i++){
            System.out.println("Ingrese el Nombre ["+i+"] --> ");
            Array[i]=sc.next();
            list.add(Array[i]);
        }
    }
    /// Método para Mostrar los Elementos del ArrayLits
    public static void MostrarElementosArrayList(List list){
       System.out.println("Lista de espera...");
       list.forEach((lista)->{
           System.out.println("* "+lista);
       });
    }
    ///Método para buscar elemento del ArrayList
    public static boolean BuscarElemento(List list,String md)
    {
       boolean bandera=false;
        if(list.contains(md)){
            bandera=true;
            
            list.remove(md);
        }
        return bandera;
    }
    // Método para eliminar elemento de un ArrayList
    //public static String EliminarElementoArrayList(List list, String elemento)//, string palabra)
    //{    
    //     list.remove(elemento);   
    //    return null;
   // }
    public static String Ordenar(List list) //, string palabra)
    {
        Collections.sort(list);
        list.forEach((datos) -> {
            System.out.println(datos);
        });
        return null;
    }
  
    private static void MostrarMenu() 
    {
       System.out.println("Ingrese la opcion que desee:");
       System.out.println("1. Ingesar nombre de trabajador");
       System.out.println("2. Mostrar la lista de espera");
       System.out.println("3. Elminar trbajador de la lista de espera por nombre");
       System.out.println("4. Ordenar el listado");
       System.out.println("5. Salir");
       
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
