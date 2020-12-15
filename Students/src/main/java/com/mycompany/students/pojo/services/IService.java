/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.pojo.services;

import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public interface IService<T> {
    void create()throws IOException;
    void delete()throws IOException;
    void findAll() throws IOException;
    void update() throws IOException;
}
