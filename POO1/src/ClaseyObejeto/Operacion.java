/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClaseyObejeto;
import java.util.Scanner;
/**
 *
 * @author LENOVO
 */
public class Operacion {
    Scanner leer = new Scanner(System.in);
    int numero1;
    int numero2;
    int suma, resta, multiplicador, division;
    public void leerNumeros()
    {
        System.out.println("Ingrese el numero 1");
        numero1=leer.nextInt();
        System.out.println("Ingrese el numero 2");
        numero2=leer.nextInt();
    }
    public void sumar(){
        suma = numero1+numero2;
    }
    public void restar(){
        resta = numero1-numero2;
    }
    public void multiplicar(){
        multiplicador = numero1*numero2;
    }
    public void dividir(){
        division = numero1/numero2;
    }
    public void mostarResultados(){
        System.out.println("La suma es: "+suma);
        System.out.println("La resta es: "+resta);
        System.out.println("La multiplicacion es: "+multiplicador);
        System.out.println("La division es: "+division);
        
    }
}
