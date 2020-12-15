/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.collection;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author Sistema
 * @param <T>
 */
public interface Model<T> {
    int save(T t)throws IOException;
    boolean update(T t)throws IOException;
    boolean delete(T t)throws IOException;
    List<T> findAll()throws IOException;
}
