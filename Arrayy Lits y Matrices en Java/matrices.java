 
package ejercicio_nº_6;
 import java.util.*;
import javax.print.DocFlavor;
public class matrices {
/// Matriz
    public static int[][] Matriz;
    public static void main(String[] args) {
       Scanner datos=new Scanner(System.in);
       String Datos[]=new String[5];
       int filas;int columnas;boolean bandera=false;int filasmostrar,columnamostrar;
       int eliminar,r;String elemento;
       ArrayList Nombres=new ArrayList();
       ///Almacenar en Arraylist
        Arralist(Datos,datos,Nombres);
       /// imprimir
        System.out.println("");
        System.out.println("Datos impresos en ArrayList");
        EnviarDatosArrayList( Nombres);
        System.out.println("");
        System.out.println("Ingrese elemento a buscar");
         elemento=datos.next();
         System.out.println("");
        if( BuscarElementoArrayList(Nombres, elemento)){
            System.out.println("Elemento existe en ArrayList");
        }else{
            System.out.println("ese elemento no existe");
        }
        System.out.println("");
        System.out.println("Digite el elemento del Arraylist que desea eliminar");
        eliminar=datos.nextInt();
        System.out.println("");
        System.out.println("Nuevos elementos");
        System.out.println("");
         System.out.println("");
          
        Eliminarelemento(eliminar, Nombres);
       
         EnviarDatosArrayList(  Nombres);
         
        System.out.println("Desea seguir eliminando");
        r=datos.nextInt();
        while(r==1){
             System.out.println("");
         System.out.println("Ingrese elemento a buscar");
         elemento=datos.next();
         System.out.println("");
        if( BuscarElementoArrayList(Nombres, elemento)){
            System.out.println("Elemento existe en ArrayList");
        }else{
            System.out.println("ese elemento no existe");
        }
           System.out.println("Digite el elemento del Arraylist que desea eliminar");
        eliminar=datos.nextInt();
        System.out.println("");
        System.out.println("Nuevos elementos");
        System.out.println("");
        
        Eliminarelemento( eliminar, Nombres);
        
          EnviarDatosArrayList(  Nombres);
          
        System.out.println("Desea seguir eliminando");
        r=datos.nextInt();
        }
       ///Pedir filas y columnas de la Matriz
      do{
          System.out.println("Digite el # de filas de la Matriz "); 
          filas=datos.nextInt();
      }while(filas<=0);
       do{
          System.out.println("Digite el # de Columnas de la Matriz "); 
          columnas=datos.nextInt();
      }while(columnas<=0);
      /// Crear Matriz
     Matriz=new int[filas][columnas];
       ///Llamar Métodos 
       ///Método Rellenar Matriz
        LlenarMatriz(Matriz, columnas, filas, datos);
        ///Método para Mostrar Matriz
        System.out.println("");
        System.out.println("***********************Matriz******************");
        System.out.println("");
        MostrarMatriz(Matriz, columnas, filas);
        System.out.println("");
        System.out.println("***********************************************");
        System.out.println("");
        System.out.println("");
        if(filas==columnas){
            bandera=true;
        }
        if(bandera){
               System.out.println("******************* Matriz Transpuesta *********");
               System.out.println("");
              MostrarMatrizTranspuesta(Matriz, columnas, filas);
              System.out.println("");
              System.out.println("****************** Diagonal Principal*************");
              System.out.println("");
              MostrarDiagonalPrincipal(Matriz, columnas, filas);
              System.out.println("");
              System.out.println("***************************************************");
               System.out.println("");
              System.out.println("****************** Diagonal Secundario*************");
              System.out.println("");
              MostrarDiagonalSecundario(Matriz, filas, columnas);
              System.out.println("");
              System.out.println("***************************************************");
              System.out.println("");
              System.out.println("***************************************************");
              System.out.println("");
              System.out.println("Ingrese la fila a MOstrar");
              filasmostrar=datos.nextInt();
              System.out.println("****************** Fila de la matriz*************");
              System.out.println("");
              MostrarFilaMatriz(Matriz,columnas, filasmostrar);
              System.out.println("");
              System.out.println("***************************************************");
              System.out.println("");
              System.out.println("Ingrese la Columna que desea Mostrar");
              columnamostrar=datos.nextInt();
              System.out.println("****************** Columna de la matriz*************");
              System.out.println("");
              MostrarColumnaMatriz(Matriz, filas, columnamostrar);
              System.out.println("");
              System.out.println("***************************************************");
        }else{
            System.out.println("Imposible mostrar la Matriz Transpuesta diagonal principal y secundario ,ya que no es una matriz cuadrada");
            System.out.println("Ingrese la fila a MOstrar");
              filasmostrar=datos.nextInt();
              System.out.println("****************** Fila de la matriz*************");
              System.out.println("");
              MostrarFilaMatriz(Matriz,columnas, filasmostrar);
              System.out.println("");
              System.out.println("***************************************************");
              System.out.println("");
              System.out.println("Ingrese la Columna que desea Mostrar");
              columnamostrar=datos.nextInt();
              System.out.println("****************** Columna de la matriz*************");
              System.out.println("");
              MostrarColumnaMatriz(Matriz, filas, columnamostrar);
              System.out.println("");
              System.out.println("***************************************************");
        }
        System.out.println("");
        System.out.println("************************************************");
    }
    ///Método para Rellenar la Matriz
    public static void LlenarMatriz(int mat[][],int colum, int fila,Scanner sc){
        for(int i=0;i<fila;i++){
          for(int j=0;j<colum;j++){
              System.out.print("Digite la Matriz["+i+"]["+j+"] --> ");
              mat[i][j]=sc.nextInt();
          }  
        }
    }
    ///Método para mostrar la Matriz
      public static void MostrarMatriz(int mat[][],int colum, int fila){
        for(int i=0;i<fila;i++){
          for(int j=0;j<colum;j++){
              System.out.print( "\t"+"["+Matriz[i][j]+"]");  
          }  
           System.out.println("\n");
        } 
    }
       /// Método para Mostrar la Matriz Transpuesta
       public static void MostrarMatrizTranspuesta(int mat[][],int colum, int fila){
        for(int i=0;i<fila;i++){
          for(int j=0;j<colum;j++){
              System.out.print( "\t"+"["+Matriz[j][i]+"]");  
          }  
            System.out.println("\n");
        } 
    }
       ///Método para Mostrar la Diagonal Principal
        public static void MostrarDiagonalPrincipal(int mat[][],int colum, int fila){
        for(int i=0;i<fila;i++){
          for(int j=0;j<colum;j++){
              if(i==j){
                  System.out.print("["+mat[i][j]+"]"); 
              }      
          }     
        } 
    }
        /// Método para la Diagonal Secundaria
        public static void MostrarDiagonalSecundario(int mat[][],int fila, int colum){
        for(int i=0;i<fila;i++){
          for(int j=0;j<colum;j++){
              if((i+j)==fila-1){
                  System.out.print("["+mat[i][j]+"]"); 
              }      
          }     
        } 
    }
        ///Método para mostrar una fila de una Matriz
        public static void MostrarFilaMatriz(int mat[][], int colum,int resp1){
          for(int j=0;j<colum;j++){
              System.out.print("["+mat[resp1][j]+"]");  
         } 
      }
        ///Método para Mostrar una columna de una matriz 
         public static void MostrarColumnaMatriz(int mat[][], int fila,int resp1){
          for(int i=0;i<fila;i++){
              System.out.print("["+mat[i][resp1]+"]");  
         } 
      }
         public static void Arralist( String nombre[],Scanner sc,ArrayList lista){
             for(int i=0;i<nombre.length;i++){
                 System.out.println("Ingrese el Nombre "+"["+i +"] --> " );nombre[i]=sc.next();
                   lista.add(nombre[i]);
             }
             
         }
          public static void EnviarDatosArrayList( ArrayList lista){
              lista.forEach((MisDatos)->{
              System.out.println("* " +MisDatos);
                  
             });
         }
          ///Método para Eliminar elemento de un ArrayList con remove
           public static void Eliminarelemento(int elemento,ArrayList lista){
                lista.remove(elemento);
         }
           public static boolean BuscarElementoArrayList(ArrayList lista, String Dto){
               boolean bandera=false;
               if(lista.contains(Dto)){
                   bandera=true;
               }
               return bandera;
           }
          
 
}
