/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.io.pojo;

/**
 *
 * @author DocenteFCyS
 */
public class Empleado {
    private int id;
    private int code;
    private String names;
    private String lastnames;
    private String phone;
    private String email;
    private String address;
    private float wage;

    public Empleado() {
    }

    public Empleado(int code, String names, String lastnames, String phone, String email, String address, float wage) {
        this.code = code;
        this.names = names;
        this.lastnames = lastnames;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.wage = wage;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getWage() {
        return wage;
    }

    public void setWage(float wage) {
        this.wage = wage;
    }

    
    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", code=" + code + ", names=" + names + ", lastnames=" + lastnames + ", phone=" + phone + ", email=" + email + ", address=" + address + ", wage=" + wage + '}';
    }
    
    
    
}
