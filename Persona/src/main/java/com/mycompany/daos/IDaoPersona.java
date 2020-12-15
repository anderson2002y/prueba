/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daos;

import com.mycompany.pojo.PersonaPojo;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public interface IDaoPersona extends IDao<PersonaPojo>{
    PersonaPojo findById(int id) throws IOException;
    PersonaPojo[] findByName(String nombre) throws IOException; 
}
