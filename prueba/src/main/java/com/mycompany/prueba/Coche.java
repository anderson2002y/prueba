/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba;

/**
 *
 * @author LENOVO
 */
public class Coche {
    private String matricula;
    private String color;
    private int anos;
    
    public String getMaticula()
            {
                return matricula;
            }
    public void setMatricula(String matricula)
    {
        this.matricula= matricula;
    }
    public String getColor()
            {
                return color;
            }
    public void setColor(String color)
    {
        this.color=color;
    }
    public int getAnos()
            {
                return anos;
            }
    public void setAnos(int anos)
    {
        this.anos=anos;
    }
    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMatricula ");
        sb.append(matricula);
        sb.append("\nColor ");
        sb.append(color);
        sb.append("\nAno ");
        sb.append(anos);
        return sb.toString();
    }
    
}
