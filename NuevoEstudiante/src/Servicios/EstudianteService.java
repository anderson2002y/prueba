/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DaoImplement.IDao;
import java.io.IOException;
import pojo.Estudiante;

/**
 *
 * @author LENOVO
 */

 public interface EstudianteService extends IService<Estudiante>{
 void findByApellido()throws IOException;
 void findByNombre()throws IOException;
 void finbById()throws IOException;
 void findByCarnet()throws IOException;
 
}

