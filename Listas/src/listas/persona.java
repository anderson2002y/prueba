/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

/**
 *
 * @author LENOVO
 */
public class persona implements Comparable<persona>{
    private String nombre, apellido;
    private Integer id;
    public persona(String nombre, String apellido, Integer id){
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", id=" + id + '}'+"\n";
    }

    @Override
    public int compareTo(persona o) {
     return nombre.compareTo(o.getNombre());
    }
    
}
