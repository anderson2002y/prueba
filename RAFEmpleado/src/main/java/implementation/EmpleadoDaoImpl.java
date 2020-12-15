/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementation;

import dao.EmpleadoDao;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import uni.io.pojo.Empleado;

/**
 *
 * @author DocenteFCyS
 */
public class EmpleadoDaoImpl implements EmpleadoDao {
    private File fHeader;
    private File fData;
    private RandomAccessFile rafHeader;
    private RandomAccessFile rafData;
    private final int SIZE = 627;

    public EmpleadoDaoImpl() {
    }
    
    private void open() throws IOException{
        fHeader = new File("empleado.header");
        fData = new File("empleado.dat");
        if(!fHeader.exists()){
            fHeader.createNewFile();
            fData.createNewFile();
            rafHeader = new RandomAccessFile(fHeader,"rw");
            rafData = new RandomAccessFile(fData,"rw");
            rafHeader.seek(0);
            rafHeader.writeInt(0);//n
            rafHeader.writeInt(0);//k
        }else{
            rafHeader = new RandomAccessFile(fHeader,"rw");
            rafData = new RandomAccessFile(fData,"rw");
        }
    }
    
    private void close() throws IOException{
        if(rafHeader != null){
            rafHeader.close();
        }
        if(rafData != null){
            rafData.close();
        }
    }
    
    @Override
    public Empleado findByCode(int code) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Empleado> findByLastnames(String lastnames) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Empleado t) throws IOException {
        open();
        rafHeader.seek(0);
        int n = rafHeader.readInt();
        int k = rafHeader.readInt();
        
        long posData = k*SIZE;
        rafData.seek(posData);
        
        rafData.writeInt(k+1);
        rafData.writeInt(t.getCode());
        rafData.writeUTF(t.getNames());
        rafData.writeUTF(t.getLastnames());
        rafData.writeUTF(t.getPhone());
        rafData.writeUTF(t.getEmail());
        rafData.writeUTF(t.getAddress());
        rafData.writeFloat(t.getWage());
        
        long posHeader = 8 + k*4;
        rafHeader.seek(0);
        rafHeader.writeInt(++n);
        rafHeader.writeInt(++k);
        rafHeader.seek(posHeader);
        rafHeader.writeInt(k);
        
        close();
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
    public List<Empleado> getAll() throws IOException {
        open();
        List<Empleado> empleados = new ArrayList<>();
        rafHeader.seek(0);
        int n = rafHeader.readInt();
        int k = rafHeader.readInt();
        
        for(int i = 0; i < n; i++){
            long posHeader = 8 + i*4;
            rafHeader.seek(posHeader);
            int id = rafHeader.readInt();
            
            long posData = (id - 1)*SIZE;
            rafData.seek(posData);
            
            Empleado e = new Empleado();
            e.setId(rafData.readInt());
            e.setCode(rafData.readInt());
            e.setNames(rafData.readUTF());
            e.setLastnames(rafData.readUTF());
            e.setPhone(rafData.readUTF());
            e.setEmail(rafData.readUTF());
            e.setAddress(rafData.readUTF());
            e.setWage(rafData.readFloat());
            
            empleados.add(e);
           
        }
        close();
        
        return empleados;
    }
    
}
