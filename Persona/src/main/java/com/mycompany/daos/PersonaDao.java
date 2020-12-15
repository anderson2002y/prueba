/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.daos;

import com.mycompany.pojo.PersonaPojo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class PersonaDao implements IDaoPersona{
    private DataOutputStream dos;
    private DataInputStream dis;
    private File file;
    
    PersonaDao personas=null;
    private static final String FILENAME = "Estudiantes.dat";
    private List<PersonaPojo> persona = new ArrayList<>();
       public PersonaDao() throws FileNotFoundException {
       load();
         }
        private void load() throws FileNotFoundException{
        file = new File(FILENAME);
        dos = new DataOutputStream(new FileOutputStream(file,true));
        dis = new DataInputStream(new FileInputStream(file));
        }
     
    @Override
    public PersonaPojo findById(int id) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonaPojo[] findByName(String nombre) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(PersonaPojo t) throws IOException {
      dos = new DataOutputStream(new FileOutputStream(file,true));
            if(t == null || dos == null){
             return;
             }
             dos.writeInt(t.getId());
             dos.writeUTF(t.getNombre());
             persona.add(t);
    }

    @Override
    public int update(PersonaPojo t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(PersonaPojo t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PersonaPojo> findAll() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
