/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.collection.EstudianteModelImpl;
import pojo.Estudiante;

/**
 *
 * @author Sistema
 */
public class RandomApp {
    public static void main(String[] args) {
        EstudianteModelImpl emi = new EstudianteModelImpl();
        
        try {
//            emi.save(
//                    new Estudiante(
//                             "2015-4321U",
//                            "Esteban",
//                            "Suarez",18)
//            );

//            Estudiante est = emi.findById(1);
//            est.setLastnames("Buttom");
//            est.setAge(18);
//            emi.update(est);
            List<Estudiante> estudiantes = emi.findAll();
            System.out.println("Lenght: " + estudiantes.size());
            System.out.println("IsEmpty: " + estudiantes.isEmpty());
            System.out.format("Nombre:%s Apellidos:%s\n" 
                    , estudiantes.get(4).getNames(),
                    estudiantes.get(4).getLastnames());
            estudiantes.clear();
            
            for(Estudiante e : estudiantes){
                System.out.println("Id: " + e.getId());
                System.out.println("carnte: " + e.getCarnet());
                System.out.println("Nombres: " + e.getNames());
                System.out.println("Apellidos: " + e.getLastnames());
                System.out.println("Edad: " + e.getAge());
                
            }
        } catch (IOException ex) {
            Logger.getLogger(RandomApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
