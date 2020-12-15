/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.pojo.model;

/**
 *
 * @author LENOVO
 */
import java.io.IOException;

public interface Model<T> {
    int save(T t)throws IOException;
    boolean update(T t)throws IOException;
    boolean delete(T t)throws IOException;
    T[] findAll()throws IOException;
}
