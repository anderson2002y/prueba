/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.implement;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.time.LocalDate;
import ni.edu.uni.archivos.utils.SearchAlgorithms;
import ni.edu.uni.random.dao.IDaoEmpleado;
import ni.edu.uni.random.data.RandomConnection;
import ni.edu.uni.random.model.EmpleadoModel;
import ni.edu.uni.random.pojo.Empleado;

/**
 *
 * @author yasser.membreno
 */
public class EmpleadoDaoImplement implements IDaoEmpleado {

    private RandomConnection rcHeader;
    private RandomConnection rcData;
    private File fileHeader;
    private File fileData;
    private final String FILENAME_HEADER = "eHeader.dat";
    private final String FILENAME_DATA = "eData.dat";
    private final int SIZE = 166;

    public EmpleadoDaoImplement() throws IOException {
        init();
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
    public Empleado findById(int id) throws IOException {
        Empleado e = null;

        if (id <= 0) {
            return e;
        }

        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();

        int index = SearchAlgorithms.randomBinarySearch(rcHeader.getConnection(), id, 0, n - 1);

        if (index <= 0) {
            return e;
        }

        long posData = (id - 1) * SIZE;

        rcData.getConnection().seek(posData);

        e = new Empleado();

        e.setId(rcData.getConnection().readInt());
        e.setCodEmpleado(rcData.getConnection().readInt());
        e.setCedula(rcData.getConnection().readUTF());
        e.setNombres(rcData.getConnection().readUTF());
        e.setApellidos(rcData.getConnection().readUTF());
        e.setInss(rcData.getConnection().readUTF());
        e.setFechaContratacion(LocalDate.ofEpochDay(rcData.getConnection().readLong()));
        e.setSalario(rcData.getConnection().readDouble());
        
        rcHeader.close();
        rcData.close();

        return e;
    }

    //TO-DO implementar metodo
    @Override
    public Empleado findByCod(int cod) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TO-DO implementar metodo
    @Override
    public Empleado findByCedula(String cedula) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TO-DO implementar metodo
    @Override
    public Empleado findByInss(String inss) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TO-DO implementar metodo
    @Override
    public Empleado[] findByFechaContratacion(LocalDate fecha) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TO-DO implementar metodo
    @Override
    public Empleado[] findBySalario(double salario) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Empleado t) throws IOException {
        if (t == null) {
            return;
        }

        RandomAccessFile rafHeader = rcHeader.getConnection();
        RandomAccessFile rafData = rcData.getConnection();
        rafHeader.seek(0);

        int n = rafHeader.readInt();
        int k = rafHeader.readInt();

        long posData = k * SIZE;

        rafData.seek(posData);

        rafData.writeInt(++k);
        rafData.writeInt(t.getCodEmpleado());
        rafData.writeUTF(t.getCedula());
        rafData.writeUTF(t.getNombres());
        rafData.writeUTF(t.getApellidos());
        rafData.writeUTF(t.getInss());
        rafData.writeLong(t.getFechaContratacion().toEpochDay());
        rafData.writeDouble(t.getSalario());

        rafHeader.seek(0);
        rafHeader.writeInt(++n);
        rafHeader.writeInt(k);

        long posHeader = 8 + (k - 1) * 4;

        rafHeader.seek(posHeader);
        rafHeader.writeInt(k);

        rcHeader.close();
        rcData.close();
    }
    //TO-DO implementar metodo
    @Override
    public int update(Empleado t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //TO-DO implementar metodo
    @Override
    public boolean delete(Empleado t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado[] findAll() throws IOException {
        Empleado e = null;
        EmpleadoModel eModel = new EmpleadoModel();

        rcHeader.getConnection().seek(0);
        int n = rcHeader.getConnection().readInt();

        for (int i = 0; i < n; i++) {
            long posHeader = 8 + (i) * 4;

            rcHeader.getConnection().seek(posHeader);
            int key = rcHeader.getConnection().readInt();

            long posData = (key - 1) * SIZE;
            rcData.getConnection().seek(posData);

            e = new Empleado();

            e.setId(rcData.getConnection().readInt());
            e.setCodEmpleado(rcData.getConnection().readInt());
            e.setCedula(rcData.getConnection().readUTF());
            e.setNombres(rcData.getConnection().readUTF());
            e.setApellidos(rcData.getConnection().readUTF());
            e.setInss(rcData.getConnection().readUTF());
            e.setFechaContratacion(LocalDate.ofEpochDay(rcData.getConnection().readLong()));
            e.setSalario(rcData.getConnection().readDouble());

            eModel.add(e);
        }
        rcHeader.close();
        rcData.close();

        return eModel.getEmpleados();
    }

}
