/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.implement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import ni.edu.uni.archivos.utils.SearchAlgorithms;
import ni.edu.uni.archivos.utils.StringUtil;
import ni.edu.uni.random.dao.IDaoActivoFijo;
import ni.edu.uni.random.data.RandomConnection;
import ni.edu.uni.random.model.ActivoFijoModel;
import ni.edu.uni.random.pojo.ActivoFijo;
import ni.edu.uni.random.pojo.Empleado;
import ni.edu.uni.random.pojo.TipoActivoFijo;

/**
 *
 * @author yasser.membreno
 */
public class ActivoFijoDaoImplement implements IDaoActivoFijo {
    private RandomConnection rcHeader;
    private RandomConnection rcData;
    private final String FILENAME_HEADER = "afheader.dat";
    private final String FILENAME_DATA = "afdata.dat";
    private final int SIZE = 302;
    private File fileHeader;
    private File fileData;
    private final EmpleadoDaoImplement eDao;

    public ActivoFijoDaoImplement() throws IOException { //ESCRITORIO CON GAVETAS => 44 BYTES; BARRIL = 12 BYTES
        eDao = new EmpleadoDaoImplement();
        init();
    }

    public ActivoFijoDaoImplement(Scanner scan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void init() throws IOException {

        fileData = new File(FILENAME_DATA);
        fileHeader = new File(FILENAME_HEADER);

        rcData = new RandomConnection(fileData);
        rcHeader = new RandomConnection(fileHeader);

        if (rcHeader.getConnection().length() == 0) {
            rcHeader.getConnection().writeInt(0);//n
            rcHeader.getConnection().writeInt(0);//k
        }
    }

    @Override
    public ActivoFijo findById(int id) throws IOException {
        ActivoFijo e = null;
        
        if(id <= 0){
           throw new IllegalArgumentException("ERROR, los id no pueden ser menor o igual que cero!");
        }
        
        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();
        
        if(n==0){
           return e;
        }
        
        int pos = SearchAlgorithms.randomBinarySearch(rcHeader.getConnection(), id, 0, n - 1);

        if (pos < 0) {
            return e;
        }        

        long posData = (id - 1) * SIZE;

        rcData.getConnection().seek(posData);

        e = new ActivoFijo();

        e.setId(rcData.getConnection().readInt());
        e.setNombre(rcData.getConnection().readUTF().trim());
        e.setDescripcion(rcData.getConnection().readUTF().trim());
        e.setCantidad(rcData.getConnection().readInt());
        e.setClasificacion(TipoActivoFijo.values()[rcData.getConnection().readInt()]);
        e.setValor(rcData.getConnection().readDouble());
        e.setFechaCompra(LocalDate.ofEpochDay(rcData.getConnection().readLong()));
        e.setEstado(ActivoFijo.EstadoActivoFijo.values()[rcData.getConnection().readInt()]);
        int idEmpleado = rcData.getConnection().readInt();
        if (idEmpleado == 0) {
            e.setEmpleado(null);
        } else {
            e.setEmpleado(eDao.findById(idEmpleado));
        }
        
        rcHeader.close();
        rcData.close();
        return e;

    }

    @Override
    public ActivoFijo[] findByClasificacion(TipoActivoFijo clasificacion) throws IOException {
        ActivoFijoModel afModel = new ActivoFijoModel();
        ActivoFijo e;
        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();

        for (int i = 0; i < n; i++) {
            long posHeader = 8 + (i) * 4;

            rcHeader.getConnection().seek(posHeader);
            int key = rcHeader.getConnection().readInt();

            long posData = (key - 1) * SIZE;
            rcData.getConnection().seek(posData);
            e = new ActivoFijo();

            e.setId(rcData.getConnection().readInt());
            e.setNombre(rcData.getConnection().readUTF().trim());
            e.setDescripcion(rcData.getConnection().readUTF().trim());
            e.setCantidad(rcData.getConnection().readInt());
            e.setClasificacion(TipoActivoFijo.values()[rcData.getConnection().readInt()]);
            if(e.getClasificacion() != clasificacion){
                continue;
            }
            e.setValor(rcData.getConnection().readDouble());
            e.setFechaCompra(LocalDate.ofEpochDay(rcData.getConnection().readLong()));
            e.setEstado(ActivoFijo.EstadoActivoFijo.values()[rcData.getConnection().readInt()]);
            int idEmpleado = rcData.getConnection().readInt();
            if (idEmpleado == 0) {
                e.setEmpleado(null);
            } else {
                e.setEmpleado(null);
            }

            afModel.add(e);
        }
        rcHeader.close();
        rcData.close();

        return afModel.getActivosFijos();
    }

    @Override
    public int asignarActivoFijo(ActivoFijo af, Empleado e) throws IOException {
        if(af == null){
            return -1;
        }
        
        if(e == null){
            return -1;
        }
        
        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();
        
        int index = SearchAlgorithms.randomBinarySearch(rcHeader.getConnection(), af.getId(), 0, n - 1);
        
        if(index <= 0){
            return index;
        }
        
        long posData = (af.getId() - 1) * SIZE;
        
        rcData.getConnection().seek(posData);        
        rcData.getConnection().writeInt(af.getId());
        rcData.getConnection().writeUTF(StringUtil.FixLengthtString(af.getNombre(), 30));
        rcData.getConnection().writeUTF(StringUtil.FixLengthtString(af.getDescripcion(),100));
        rcData.getConnection().writeInt(af.getCantidad());
        rcData.getConnection().writeInt(af.getClasificacion().ordinal());
        rcData.getConnection().writeDouble(af.getValor());
        rcData.getConnection().writeLong(af.getFechaCompra().toEpochDay());
        rcData.getConnection().writeInt(af.getEstado().ordinal());
        rcData.getConnection().writeInt(e.getId());
        
        rcHeader.close();
        rcData.close();
        
        return af.getId();
    }

    //TO-DO implementar estos metodos 
    @Override
    public void asignarActivosFijos(ActivoFijo[] af, Empleado e) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public ActivoFijo[] findByEmpleado(Empleado e) throws IOException {
        if(e == null){
            return null;
        }
        ActivoFijoModel afModel = new ActivoFijoModel();
        ActivoFijo af;
        
        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();

        for (int i = 0; i < n; i++) {
            long posHeader = 8 + (i) * 4;

            rcHeader.getConnection().seek(posHeader);
            int key = rcHeader.getConnection().readInt();

            long posData = (key - 1) * SIZE;
            rcData.getConnection().seek(posData);
            af = new ActivoFijo();

            af.setId(rcData.getConnection().readInt());
            af.setNombre(rcData.getConnection().readUTF().trim());
            af.setDescripcion(rcData.getConnection().readUTF().trim());
            af.setCantidad(rcData.getConnection().readInt());
            af.setClasificacion(TipoActivoFijo.values()[rcData.getConnection().readInt()]);
            af.setValor(rcData.getConnection().readDouble());
            af.setFechaCompra(LocalDate.ofEpochDay(rcData.getConnection().readLong()));
            af.setEstado(ActivoFijo.EstadoActivoFijo.values()[rcData.getConnection().readInt()]);
            int idEmpleado = rcData.getConnection().readInt();
            if(idEmpleado != e.getId()){
                continue;
            }
            if (idEmpleado == 0) {
                af.setEmpleado(null);
            } else {
                af.setEmpleado(eDao.findById(idEmpleado));
            }

            afModel.add(af);
        }
        rcHeader.close();
        rcData.close();

        return afModel.getActivosFijos();    
    }
     //TO-DO implementar estos metodos 
   //@Override
  //  public ActivoFijo cambiarEstado(ActivoFijo activoFijo, ActivoFijo.EstadoActivoFijo estado,  ActivoFijo t) throws IOException {

    /**
     *
     * @param t
     * @return
     * @throws IOException
     */
    public int finBycambiarEstado(ActivoFijo t) throws IOException {
        int id = 0;
        if(t == null){
            return id;
        }
        
        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();
        
        if(n==0){
           return id;
        }
        
        int pos = SearchAlgorithms.randomBinarySearch(rcHeader.getConnection(), t.getId(), 0, n - 1);

        if (pos < 0) {
            return id;
        }   
        
        long posData = (t.getId() - 1) * SIZE;

        rcData.getConnection().seek(posData);
        
        
        rcData.getConnection().writeInt(t.getEstado().ordinal());
        if (t.getEmpleado() != null) {
            rcData.getConnection().writeInt(t.getEmpleado().getId());
        } else {
            rcData.getConnection().writeInt(0);
        }
        id = t.getId();
        rcHeader.close();
        rcData.close();
        
        return id;   
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(ActivoFijo t) throws IOException {
        if (t == null) {
            return;
        }

        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();
        int k = rcHeader.getConnection().readInt();

        long pos = k * SIZE;

        rcData.getConnection().seek(pos);

        rcData.getConnection().writeInt(++k);
        rcData.getConnection().writeUTF(StringUtil.FixLengthtString(t.getNombre(), 30));
        rcData.getConnection().writeUTF(StringUtil.FixLengthtString(t.getDescripcion(),100));
        rcData.getConnection().writeInt(t.getCantidad());
        rcData.getConnection().writeInt(t.getClasificacion().ordinal());
        rcData.getConnection().writeDouble(t.getValor());
        rcData.getConnection().writeLong(t.getFechaCompra().toEpochDay());
        rcData.getConnection().writeInt(t.getEstado().ordinal());
        if (t.getEmpleado() != null) {
            rcData.getConnection().writeInt(t.getEmpleado().getId());
        } else {
            rcData.getConnection().writeInt(0);
        }

        rcHeader.getConnection().seek(0);
        rcHeader.getConnection().writeInt(++n);
        rcHeader.getConnection().writeInt(k);

        long posHeader = 8 + (k - 1) * 4;

        rcHeader.getConnection().seek(posHeader);
        rcHeader.getConnection().writeInt(k);

        rcHeader.close();
        rcData.close();
    }

    @Override
    public int update(ActivoFijo t) throws IOException {
        int id = 0;
        if(t == null){
            return id;
        }
        
        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();
        
        if(n==0){
           return id;
        }
        
        int pos = SearchAlgorithms.randomBinarySearch(rcHeader.getConnection(), t.getId(), 0, n - 1);

        if (pos < 0) {
            return id;
        }   
        
        long posData = (t.getId() - 1) * SIZE;

        rcData.getConnection().seek(posData);
        
        rcData.getConnection().writeInt(t.getId());
        rcData.getConnection().writeUTF(StringUtil.FixLengthtString(t.getNombre(), 30));
        rcData.getConnection().writeUTF(StringUtil.FixLengthtString(t.getDescripcion(),100));
        rcData.getConnection().writeInt(t.getCantidad());
        rcData.getConnection().writeInt(t.getClasificacion().ordinal());
        rcData.getConnection().writeDouble(t.getValor());
        rcData.getConnection().writeLong(t.getFechaCompra().toEpochDay());
        rcData.getConnection().writeInt(t.getEstado().ordinal());
        if (t.getEmpleado() != null) {
            rcData.getConnection().writeInt(t.getEmpleado().getId());
        } else {
            rcData.getConnection().writeInt(0);
        }
        id = t.getId();
        rcHeader.close();
        rcData.close();
        
        return id;
        
    }
     //TO-DO implementar estos metodos 
    @Override
    public boolean delete(ActivoFijo t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivoFijo[] findAll() throws IOException {
        ActivoFijoModel afModel = new ActivoFijoModel();
        ActivoFijo e;
        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();

        for (int i = 0; i < n; i++) {
            long posHeader = 8 + (i) * 4;

            rcHeader.getConnection().seek(posHeader);
            int key = rcHeader.getConnection().readInt();

            long posData = (key - 1) * SIZE;
            rcData.getConnection().seek(posData);
            e = new ActivoFijo();

            e.setId(rcData.getConnection().readInt());
            e.setNombre(rcData.getConnection().readUTF().trim());
            e.setDescripcion(rcData.getConnection().readUTF().trim());
            e.setCantidad(rcData.getConnection().readInt());
            e.setClasificacion(TipoActivoFijo.values()[rcData.getConnection().readInt()]);
            e.setValor(rcData.getConnection().readDouble());
            e.setFechaCompra(LocalDate.ofEpochDay(rcData.getConnection().readLong()));
            e.setEstado(ActivoFijo.EstadoActivoFijo.values()[rcData.getConnection().readInt()]);
            int idEmpleado = rcData.getConnection().readInt();
            if (idEmpleado == 0) {
                e.setEmpleado(null);
            } else {
                e.setEmpleado(eDao.findById(idEmpleado));
            }

            afModel.add(e);
        }
        rcHeader.close();
        rcData.close();

        return afModel.getActivosFijos();
    }

    @Override
    public void cambiarEstado(ActivoFijo activoFijo, ActivoFijo.EstadoActivoFijo estado) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
