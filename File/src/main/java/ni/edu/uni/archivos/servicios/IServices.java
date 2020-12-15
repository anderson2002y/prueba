/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.servicios;

import java.io.IOException;

/**
 *
 * @author yasser.membreno
 */
public interface IServices<T> {
    void create() throws IOException;
    int update() throws IOException;
    boolean delete() throws IOException;
    void findAll() throws IOException;
    
}
