/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.dao;

import java.io.IOException;
import ni.edu.uni.archivos.pojo.ActivoFijo;
import ni.edu.uni.archivos.pojo.Empleado;
import ni.edu.uni.archivos.pojo.TipoActivoFijo;

/**
 *
 * @author yasser.membreno
 */
public interface IDaoActivoFijo extends IDao<ActivoFijo>{
    ActivoFijo findById(int id) throws IOException;
    ActivoFijo[] findByClasificacion(TipoActivoFijo clasificacion) throws IOException;
    void asignarActivoFijo(ActivoFijo af, Empleado e) throws IOException;
    void asignarActivosFijos(ActivoFijo[] af, Empleado e) throws IOException;
    ActivoFijo[] findByEmpleado(Empleado e) throws IOException;        
    
}
