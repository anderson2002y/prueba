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
import ni.edu.uni.archivos.dao.IDaoActivoFijo;
import ni.edu.uni.archivos.datos.FileConnection;
import ni.edu.uni.archivos.model.ActivoFijoModel;
import ni.edu.uni.archivos.pojo.ActivoFijo;
import ni.edu.uni.archivos.pojo.Empleado;
import ni.edu.uni.archivos.pojo.TipoActivoFijo;

/**
 *
 * @author yasser.membreno
 */
public class ActivoFijoDaoImplement implements IDaoActivoFijo {

    private final String FILENAME = "activofijo.dat";
    private ActivoFijoModel afModel;
    private DataOutputStream dos;
    private DataInputStream dis;
    private EmpleadoDaoImplement eDao;

    public ActivoFijoDaoImplement() {
        eDao = new EmpleadoDaoImplement();
    }

    @Override
    public ActivoFijo findById(int id) throws IOException {
        ActivoFijo af = null;
        if (id < 1) {
            return af;
        }
        dis = FileConnection.getInstance(new File(FILENAME)).getDataInputStream();
        while (dis.available() > 0) {
            af = new ActivoFijo();

            af.setId(dis.readInt());
            af.setNombre(dis.readUTF());
            af.setDescripcion(dis.readUTF());
            af.setCantidad(dis.readInt());
            af.setClasificacion(TipoActivoFijo.values()[dis.readInt()]);
            af.setValor(dis.readDouble());
            af.setFechaCompra(LocalDate.ofEpochDay(dis.readLong()));
            af.setEmpleado(eDao.findById(dis.readInt()));

            if (af.getId() == id) {
                break;
            } else {
                af = null;
            }
        }

        FileConnection.getInstance(new File(FILENAME)).close();

        return af;
    }

    //TO-DO implementar el metodo
    @Override
    public ActivoFijo[] findByClasificacion(TipoActivoFijo clasificacion) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(ActivoFijo t) throws IOException {
        dos = FileConnection.getInstance(new File(FILENAME)).getDataOutputStream();
        if (dos == null) {
            return;
        }
        writeData(t);

        FileConnection.getInstance(new File(FILENAME)).close();
    }

    private void writeData(ActivoFijo t) throws IOException {
        dos.writeInt(t.getId());
        dos.writeUTF(t.getNombre());
        dos.writeUTF(t.getDescripcion());
        dos.writeInt(t.getCantidad());
        dos.writeInt(t.getClasificacion().ordinal());
        dos.writeDouble(t.getValor());
        dos.writeLong(t.getFechaCompra().toEpochDay());
        if (t.getEmpleado() == null) {
            dos.writeInt(0);
        } else {
            dos.writeInt(t.getEmpleado().getId());
        }
    }

    @Override
    public int update(ActivoFijo t) throws IOException {
        int id = 0;
        ActivoFijo temp[] = findAll();

        dos = FileConnection.getInstance(new File(FILENAME)).getDataOutputStreamToUpdate();
        for (ActivoFijo af : temp) {
            if (af.getId() == t.getId()) {
                writeData(t);
                id = t.getId();
            } else {
                writeData(af);
            }
        }
        FileConnection.getInstance(new File(FILENAME)).close();
        return id;
    }

    private ActivoFijo[] dropDuplicates(ActivoFijo temp[]) {
        ActivoFijo current = temp[0];
        boolean found = false;
        ActivoFijoModel amodel = new ActivoFijoModel();

        for (int i = 0; i < temp.length; i++) {
            if (current == temp[i] && !found) {
                found = true;
            } else if (current != temp[i]) {
                amodel.add(current);
                current = temp[i];
                found = false;
            }
        }

        return amodel.getActivosFijos();
    }

    @Override
    public boolean delete(ActivoFijo t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ActivoFijo[] findAll() throws IOException {
        afModel = new ActivoFijoModel();
        ActivoFijo af = null;
        dis = FileConnection.getInstance(new File(FILENAME)).getDataInputStream();

        if (dis == null) {
            return afModel.getActivosFijos();
        }

        while (dis.available() > 0) {
            af = new ActivoFijo();

            af.setId(dis.readInt());
            af.setNombre(dis.readUTF());
            af.setDescripcion(dis.readUTF());
            af.setCantidad(dis.readInt());
            af.setClasificacion(TipoActivoFijo.values()[dis.readInt()]);
            af.setValor(dis.readDouble());
            af.setFechaCompra(LocalDate.ofEpochDay(dis.readLong()));
            af.setEmpleado(eDao.findById(dis.readInt()));
            afModel.add(af);
        }

        FileConnection.getInstance(new File(FILENAME)).close();
        return afModel.getActivosFijos();
    }

    @Override
    public void asignarActivoFijo(ActivoFijo af, Empleado e) throws IOException {
        af.setEmpleado(e);
        update(af);
    }

    @Override
    public void asignarActivosFijos(ActivoFijo[] af, Empleado e) throws IOException {
        for (ActivoFijo a : af) {
            a.setEmpleado(e);
            update(a);
        }
    }

    @Override
    public ActivoFijo[] findByEmpleado(Empleado e) throws IOException {
        afModel = new ActivoFijoModel();
        ActivoFijo af ;
        if (e == null) {
            return afModel.getActivosFijos();
        }

        dis = FileConnection.getInstance(new File(FILENAME)).getDataInputStream();
        if (dis == null) {
            return afModel.getActivosFijos();
        }

        while (dis.available() > 0) {
            af = new ActivoFijo();

            af.setId(dis.readInt());
            af.setNombre(dis.readUTF());
            af.setDescripcion(dis.readUTF());
            af.setCantidad(dis.readInt());
            af.setClasificacion(TipoActivoFijo.values()[dis.readInt()]);
            af.setValor(dis.readDouble());
            af.setFechaCompra(LocalDate.ofEpochDay(dis.readLong()));
            af.setEmpleado(eDao.findById(dis.readInt()));
            
            if(af.getEmpleado() == null){
                continue;
            }
            
            if(e.getId() == af.getEmpleado().getId()){
                afModel.add(af);
            }

        }
        FileConnection.getInstance(new File(FILENAME)).close();
        return afModel.getActivosFijos();
    }

}
