/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.pojo.services;

import com.mycompany.students.pojo.Estudiante;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public interface IServiceEstudiante extends IService<Estudiante>{
    void BuscarId()throws IOException;
    void BuscarApellido()throws IOException;
    void BuscarCarnet()throws IOException;
    
}
