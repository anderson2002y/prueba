/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.pojo;

/**
 *
 * @author LENOVO
 */
public class Estudiante {
    private int id;
    private String Names;
     private String Lastnames;
    private String carnet;
    private int age;
    public Estudiante() {
    }

    public Estudiante(int id, String Names, String Lastnames, String carnet, int age) {
        this.id = id;
        this.Names = Names;
        this.Lastnames = Lastnames;
        this.carnet = carnet;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String Names) {
        this.Names = Names;
    }

    public String getLastnames() {
        return Lastnames;
    }

    public void setLastnames(String Lastnames) {
        this.Lastnames = Lastnames;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
 
}