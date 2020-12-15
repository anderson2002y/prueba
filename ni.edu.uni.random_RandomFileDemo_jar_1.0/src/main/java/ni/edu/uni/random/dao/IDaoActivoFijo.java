/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.dao;

import java.io.IOException;
import ni.edu.uni.random.pojo.ActivoFijo;
import ni.edu.uni.random.pojo.Empleado;
import ni.edu.uni.random.pojo.TipoActivoFijo;


/**
 *
 * @author yasser.membreno
 */
public interface IDaoActivoFijo extends IDao<ActivoFijo>{
    ActivoFijo findById(int id) throws IOException;
    ActivoFijo[] findByClasificacion(TipoActivoFijo clasificacion) throws IOException;
    int asignarActivoFijo(ActivoFijo af, Empleado e) throws IOException;
    void asignarActivosFijos(ActivoFijo[] af, Empleado e) throws IOException;
    ActivoFijo[] findByEmpleado(Empleado e) throws IOException;  
    void cambiarEstado(ActivoFijo activoFijo, ActivoFijo.EstadoActivoFijo estado) throws IOException;
    
}
