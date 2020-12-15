/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import pojo.Estudiante;

/**
 *
 * @author Sistema
 */
public class EstudianteModelImpl implements EstudianteModel {

    private File file;
    private RandomAccessFile raf;
    private String path;
    private final int SIZE = 137;

    public EstudianteModelImpl() {
        path = "estudiante.dat";
        file = new File(path);
    }

    private void openRAF() throws IOException {
        if (!file.exists()) {
            file.createNewFile();
            raf = new RandomAccessFile(file, "rw");
            raf.seek(0);
            raf.writeInt(0);
            raf.writeInt(0);
        } else {
            raf = new RandomAccessFile(file, "rw");
        }
    }

    private void closeRAF() throws IOException {
        if (raf != null) {
            raf.close();
        }
    }

    public EstudianteModelImpl(String path) {
        this.path = path;
        file = new File(path);
    }

    public EstudianteModelImpl(File file) {
        this.file = file;
    }

    @Override
    public Estudiante findById(int id) throws IOException {
        Estudiante e = null;
        openRAF();
        raf.seek(0);
        int n = raf.readInt();

        int index = binarySearch(id, 0, n - 1);
        if (index < 0) {
            return e;
        }
        e = findByIndex(index);

        closeRAF();
        return e;
    }

    @Override
    public Estudiante findByCarnet(String carnet) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estudiante[] findByLastname(String lastname) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estudiante[] findByAgeRange(int min, int max) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(Estudiante t) throws IOException {
        openRAF();
        raf.seek(0);
        int n = raf.readInt();
        int k = raf.readInt();

        long pos = 8 + SIZE * n;
        raf.seek(pos);
        raf.writeInt(++k);
        raf.writeUTF(fixString(t.getCarnet(), 10));
        raf.writeUTF(fixString(t.getNames(), 20));
        raf.writeUTF(fixString(t.getLastnames(), 30));
        raf.writeInt(t.getAge());

        raf.seek(0);
        raf.writeInt(++n);
        raf.writeInt(k);

        closeRAF();
        return 1;
    }

    private String fixString(String text, int capacity) {
        StringBuilder sb = null;

        if (text == null) {
            sb = new StringBuilder(capacity);
        } else {
            sb = new StringBuilder(text);
            sb.setLength(capacity);
        }

        return sb.toString();
    }

    @Override
    public boolean update(Estudiante t) throws IOException {
        openRAF();
        boolean flag = false;
        raf.seek(0);
        int n = raf.readInt();

        int index = binarySearch(t.getId(), 0, n - 1);
        if (index < 0) {
            return flag;
        }

        long pos = 8 + index * SIZE;
        raf.seek(pos);

        raf.writeInt(t.getId());
        raf.writeUTF(fixString(t.getCarnet(), 10));
        raf.writeUTF(fixString(t.getNames(), 20));
        raf.writeUTF(fixString(t.getLastnames(), 30));
        raf.writeInt(t.getAge());
        if (index != -1) {
            flag = true;
        }
        closeRAF();
        return flag;
    }

    private int binarySearch(int id, int left, int right) throws IOException {
        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;
        Estudiante e = findByIndex(middle);
        if (e.getId() == id) {
            return middle;
        } else if (e.getId() > id) {
            return binarySearch(id, left, middle - 1);
        } else {
            return binarySearch(id, middle + 1, right);
        }
    }

    private Estudiante findByIndex(int index) throws IOException {
        if (raf == null) {
            openRAF();
        }

        long pos = 8 + index * SIZE;
        raf.seek(pos);
        Estudiante e = new Estudiante();
        e.setId(raf.readInt());
        e.setCarnet(raf.readUTF());
        e.setNames(raf.readUTF());
        e.setLastnames(raf.readUTF());
        e.setAge(raf.readInt());

        return e;
    }

    @Override
    public boolean delete(Estudiante t) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estudiante[] findAll() throws IOException {
        Estudiante estudiantes[] = null;
        openRAF();
        raf.seek(0);
        int n = raf.readInt();
        Estudiante e;
        for (int i = 0; i < n; i++) {
            long pos = 8 + i * SIZE;
            raf.seek(pos);
            e = new Estudiante();
            e.setId(raf.readInt());
            e.setCarnet(raf.readUTF());
            e.setNames(raf.readUTF());
            e.setLastnames(raf.readUTF());
            e.setAge(raf.readInt());
            estudiantes = addElement(estudiantes, e);
        }
        closeRAF();
        return estudiantes;
    }

    private Estudiante[] addElement(Estudiante est[], Estudiante e) {
        if (est == null) {
            est = new Estudiante[1];
            est[0] = e;
            return est;
        }

        est = Arrays.copyOf(est, est.length + 1);
        est[est.length - 1] = e;
        return est;
    }
}
