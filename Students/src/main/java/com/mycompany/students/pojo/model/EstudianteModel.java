/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.pojo.model;
import com.mycompany.students.pojo.Estudiante;
import java.io.IOException;
/**
 *
 * @author LENOVO
 */

    
public interface EstudianteModel extends Model<Estudiante>{
    Estudiante findById(int id)throws IOException;
    Estudiante findByCarnet(String carnet)throws IOException;
    Estudiante[] findByLastname(String lastname)throws IOException;
    Estudiante[] findByAgeRange(int min, int max)throws IOException;
}


