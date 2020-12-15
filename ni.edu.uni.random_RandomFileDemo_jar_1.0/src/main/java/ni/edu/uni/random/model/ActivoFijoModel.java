/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.model;

import java.util.Arrays;
import ni.edu.uni.random.pojo.ActivoFijo;

/**
 *
 * @author yasser.membreno
 */
public class ActivoFijoModel {
    private ActivoFijo activosFijos[];

    public ActivoFijoModel() {
    }
    
    public void add(ActivoFijo value){
        if(activosFijos == null){
            activosFijos = new ActivoFijo[1];
            activosFijos[0] = value;
            return;
        }

        activosFijos = Arrays.copyOf(activosFijos, activosFijos.length+1);
        activosFijos[activosFijos.length - 1] = value;        
    }
    
    public boolean remove(ActivoFijo object){
        boolean flag = false;
        //instrucciones para eliminar un registro del arreglo
        //System.arraycopy
        return flag; 
    }

    public ActivoFijo[] getActivosFijos() {
        return activosFijos;
    }

    public void setActivosFijos(ActivoFijo[] activosFijos) {
        this.activosFijos = activosFijos;
    }
    
    
}
