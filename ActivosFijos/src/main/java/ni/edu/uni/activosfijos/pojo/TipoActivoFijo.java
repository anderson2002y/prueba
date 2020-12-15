/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.activosfijos.pojo;

/**
 *
 * @author yasser.membreno
 */
public enum TipoActivoFijo {
    VEHICULO(5),EDIFICIO(20),COMPUTO(2),MOBILIARIO(3);
    
    int anos;

    private TipoActivoFijo(int anos) {
        this.anos = anos;
    }

    public int getAnos() {
        return anos;
    }
    
}
