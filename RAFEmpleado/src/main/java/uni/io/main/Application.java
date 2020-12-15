/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.io.main;

import implementation.EmpleadoDaoImpl;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import uni.io.pojo.Empleado;

/**
 *
 * @author DocenteFCyS
 */
public class Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EmpleadoDaoImpl edao = new EmpleadoDaoImpl();
        Empleado pep = new Empleado(126, "Ana", "Conda", 
                "88885566", "ana.conda@gmail.com", 
                "Del ceibon San Judas 2 c Arriba", 25000);
        
        try {
            //edao.create(pep);
            List<Empleado> empleados = edao.getAll();
            for(Empleado e : empleados){
                System.out.println(e.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }
    
}
