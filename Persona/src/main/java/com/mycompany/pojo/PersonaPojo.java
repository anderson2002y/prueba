/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pojo;

/**
 *
 * @author LENOVO
 */
public class PersonaPojo {
    private int id;
    private String nombre;
    
    public PersonaPojo(){
    
    }   

    public PersonaPojo(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    
}

