/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Sistema
 */
public class Estudiante {
    private int id;
    private String carnet;
    private String names;
    private String lastnames;
    private int age;

    public Estudiante() {
    }

    public Estudiante(String carnet, String names, String lastnames, int age) {
        this.carnet = carnet;
        this.names = names;
        this.lastnames = lastnames;
        this.age = age;
    }
    
    public Estudiante(int id, String carnet, String names, String lastnames, int age) {
        this.id = id;
        this.carnet = carnet;
        this.names = names;
        this.lastnames = lastnames;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastnames() {
        return lastnames;
    }

    public void setLastnames(String lastnames) {
        this.lastnames = lastnames;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
