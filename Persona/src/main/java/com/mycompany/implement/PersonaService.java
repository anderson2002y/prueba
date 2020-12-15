/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.implement;

import com.mycompany.pojo.PersonaPojo;
import java.io.IOException;

/**
 *
 * @author LENOVO
 */
public interface PersonaService extends IService<PersonaPojo>{
   void BuscarId() throws IOException;
    void BuscarNombre () throws IOException;
}
