/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import model.AsignaturaModel;
import model.EstudianteModel;
import model.NotasModel;
import pojo.Notas;

/**
 *
 * @author Estudiante
 */
public class App {
    public static void main(String[] args) {
        AsignaturaModel amodel = new AsignaturaModel();
        EstudianteModel emodel = new EstudianteModel();
        NotasModel nmodel = new NotasModel();
        
        amodel.fill();
        emodel.fill();
        
        nmodel.add(new Notas(emodel.findById(1),amodel.findById(1),65));
        nmodel.add(new Notas(emodel.findById(1),amodel.findById(2),70));
        nmodel.add(new Notas(emodel.findById(1),amodel.findById(3),72));
        
        nmodel.add(new Notas(emodel.findById(2),amodel.findById(4),66));
        nmodel.add(new Notas(emodel.findById(2),amodel.findById(5),80));
        
        Notas[] notas = nmodel.findByStudent(emodel.findById(2));
        
        System.out.format("%12s %10s\n", "Asignatura","Nota");
        for(Notas n : notas){
            System.out.format("%12s %10d\n",
                    n.getAsignatura().getNombre(),n.getNota());
            
        }
        
    }
}
