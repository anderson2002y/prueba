/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.dao;

import java.io.IOException;
import java.time.LocalDate;
import ni.edu.uni.archivos.pojo.Empleado;

/**
 *
 * @author yasser.membreno
 */
public interface IDaoEmpleado extends IDao<Empleado>{
    Empleado findById(int id) throws IOException;
    Empleado findByCodEmpleado(int cod) throws IOException;
    Empleado findByInss(String inss) throws IOException;
    Empleado findByCedula(String cedula) throws IOException;
    Empleado[] findByFechaContratacion(LocalDate fecha) throws IOException;
    Empleado[] findByRangoFecha(LocalDate startDate, LocalDate endDate) throws IOException;
    
}
