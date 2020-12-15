/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author LENOVO
 */
import java.io.IOException;

public interface IDao<T> {
 void save(T t)throws IOException;
 void update(T t)throws IOException;
 void delete(T t)throws IOException;
 T[] findAll()throws IOException;
}
