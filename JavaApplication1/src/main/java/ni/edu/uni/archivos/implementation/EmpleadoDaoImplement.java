/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.implementation;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import ni.edu.uni.archivos.dao.IDaoEmpleado;
import ni.edu.uni.archivos.datos.FileConnection;
import ni.edu.uni.archivos.model.EmpleadoModel;
import ni.edu.uni.archivos.pojo.Empleado;

/**
 *
 * @author yasser.membreno
 */
public class EmpleadoDaoImplement implements IDaoEmpleado{
    private FileConnection fileConnection;
    private DataOutputStream dos;
    private DataInputStream dis;
    private final String FILENAME = "empleado.dat";
    private EmpleadoModel eModel;

    public EmpleadoDaoImplement() {    
    }    
        
    @Override
    public Empleado findById(int id) throws IOException {
        Empleado e = null;
        
        if(id <= 0){
            return e;
        }
        
        dis = FileConnection.getInstance(new File(FILENAME)).getDataInputStream();
        while(dis.available() > 0){
            e = new Empleado();
            
            e.setId(dis.readInt());
            e.setCodEmpleado(dis.readInt());
            e.setCedula(dis.readUTF());
            e.setNombres(dis.readUTF());
            e.setApellidos(dis.readUTF());
            e.setInss(dis.readUTF());
            e.setFechaContratacion(LocalDate.ofEpochDay(dis.readLong()));
            e.setSalario(dis.readDouble());
            
            if(e.getId() == id){
                break;
            }else{
                e = null;
            }
            
        }
        FileConnection.getInstance(new File(FILENAME)).close();
        
        return e;
    }

    @Override
    public Empleado findByCodEmpleado(int cod) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado findByInss(String inss) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado findByCedula(String cedula) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado[] findByFechaContratacion(LocalDate fecha) throws IOException {
        Empleado e;
        eModel = new EmpleadoModel();
        
        if(fecha == null){
            return eModel.getEmpleados();
        }
        
        dis = FileConnection.getInstance(new File(FILENAME)).getDataInputStream();
        if(dis == null){
            return eModel.getEmpleados();
        }
        
        while(dis.available() > 0){
            e = new Empleado();
            
            e.setId(dis.readInt());
            e.setCodEmpleado(dis.readInt());
            e.setCedula(dis.readUTF());
            e.setNombres(dis.readUTF());
            e.setApellidos(dis.readUTF());
            e.setInss(dis.readUTF());
            e.setFechaContratacion(LocalDate.ofEpochDay(dis.readLong()));
            e.setSalario(dis.readDouble());
            
            if(e.getFechaContratacion().equals(fecha)){
                eModel.add(e);
            }
        }
        FileConnection.getInstance(new File(FILENAME)).close();
        return eModel.getEmpleados();
    }

    @Override
    public Empleado[] findByRangoFecha(LocalDate startDate, LocalDate endDate) throws IOException {
         Empleado e;
        eModel = new EmpleadoModel();
        
        if(startDate == null || endDate == null){
            return eModel.getEmpleados();
        }
        
        dis = FileConnection.getInstance(new File(FILENAME)).getDataInputStream();
        if(dis == null){
            return eModel.getEmpleados();
        }
        
        while(dis.available() > 0){
            e = new Empleado();
            
            e.setId(dis.readInt());
            e.setCodEmpleado(dis.readInt());
            e.setCedula(dis.readUTF());
            e.setNombres(dis.readUTF());
            e.setApellidos(dis.readUTF());
            e.setInss(dis.readUTF());
            e.setFechaContratacion(LocalDate.ofEpochDay(dis.readLong()));
            e.setSalario(dis.readDouble());
            
            if(e.getFechaContratacion().compareTo(startDate) >= 0 && e.getFechaContratacion().compareTo(endDate) <= 0){
                eModel.add(e);
            }
        }
        FileConnection.getInstance(new File(FILENAME)).close();
        return eModel.getEmpleados();
    }

   
    @Override
    public void create(Empleado t) throws IOException {
        dos = FileConnection.getInstance(new File(FILENAME)).getDataOutputStream();
        if(dos == null){
            return;
        }
        
        writeData(t);
        
        FileConnection.getInstance(new File(FILENAME)).close();
    }
    
    private void writeData(Empleado t) throws IOException{
        dos.writeInt(t.getId());
        dos.writeInt(t.getCodEmpleado());
        dos.writeUTF(t.getCedula());
        dos.writeUTF(t.getNombres());
        dos.writeUTF(t.getApellidos());
        dos.writeUTF(t.getInss());
        dos.writeLong(t.getFechaContratacion().toEpochDay());
        dos.writeDouble(t.getSalario());
    }

    @Override
    public int update(Empleado t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Empleado t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado[] findAll() throws IOException {
        eModel = new EmpleadoModel();
        Empleado e = null;
        dis = FileConnection.getInstance(new File(FILENAME)).getDataInputStream();
        
        if(dis == null){
            return eModel.getEmpleados();
        }
        
        while(dis.available() > 0){
            e = new Empleado();
            
            e.setId(dis.readInt());
            e.setCodEmpleado(dis.readInt());
            e.setCedula(dis.readUTF());
            e.setNombres(dis.readUTF());
            e.setApellidos(dis.readUTF());
            e.setInss(dis.readUTF());
            e.setFechaContratacion(LocalDate.ofEpochDay(dis.readLong()));
            e.setSalario(dis.readDouble());
            
            eModel.add(e);
        }
        FileConnection.getInstance(new File(FILENAME)).close();
        return eModel.getEmpleados();
    }
    
}
