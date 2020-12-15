/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.servicios;

import java.io.IOException;
import ni.edu.uni.random.pojo.ActivoFijo;

/**
 *
 * @author yasser.membreno
 */
public interface IServiceActivoFijo extends IServices<ActivoFijo>{
    ActivoFijo findById() throws IOException;
    ActivoFijo[] findByClasificacion() throws IOException;
}
