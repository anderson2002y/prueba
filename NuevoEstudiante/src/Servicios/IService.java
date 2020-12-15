/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public interface IService<T> {
    
 void save()throws IOException;
 void update()throws IOException;
 void delete()throws IOException;
 void findAll()throws IOException;
}


