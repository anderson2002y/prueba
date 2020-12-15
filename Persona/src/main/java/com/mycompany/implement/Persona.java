/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.implement;

import com.mycompany.daos.PersonaDao;
import com.mycompany.pojo.PersonaPojo;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author LENOVO
 */
public class Persona implements PersonaService{
   
    Scanner scan = new Scanner(System.in);
    PersonaDao personaImplement;
    List<PersonaPojo> persona = new ArrayList<>();
    public Persona(Scanner scan) throws IOException {
       this.scan = scan;
       personaImplement= new PersonaDao();
        
       }
    @Override
    public void BuscarId() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void BuscarNombre() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create() throws IOException {
     int id;
     String nombre;       
        
    
        System.out.println("codigo: ");
        id = scan.nextInt();
        scan.nextLine();
        System.out.println("Nombre: ");
        nombre = scan.nextLine();
        
       
        
        
        persona= new PersonaPojo();
        person = new PersonaPojo();
        personaImplement.create(t);
    }

    @Override
    public void update() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void findAll() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
