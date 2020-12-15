/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplement;

import pojo.Estudiante;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public interface IDaoEstudiante extends IDao<Estudiante>{
 Estudiante[] findByApellido(String apellidos)throws IOException;
 Estudiante[] findByNombre(String nombres)throws IOException;
 Estudiante finbById(int id)throws IOException;
 Estudiante findByCarnet(String carnet)throws IOException;

}
