/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.List;
import uni.io.pojo.Empleado;

/**
 *
 * @author DocenteFCyS
 */
public interface EmpleadoDao extends Dao<Empleado>{
    Empleado findByCode(int code) throws IOException;
    List<Empleado> findByLastnames(String lastnames) throws IOException;
}
