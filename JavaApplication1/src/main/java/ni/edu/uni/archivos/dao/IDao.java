/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.dao;

import java.io.IOException;

/**
 *
 * @author yasser.membreno
 * @param <T>
 */
//CRUD => Create, Read, Update, Delete
public interface IDao<T> {
    void create(T t) throws IOException;
    int update(T t) throws IOException;
    boolean delete(T t) throws IOException;
    T[] findAll() throws IOException;
}
