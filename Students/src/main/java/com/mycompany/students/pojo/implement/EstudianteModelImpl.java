/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.students.pojo.implement;
import static com.mycompany.students.main.RandomApp.print;
import java.io.File;
/**
 *
 * @author LENOVO
 */
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import com.mycompany.students.pojo.Estudiante;
import com.mycompany.students.pojo.model.EstudianteModel;
import java.util.Comparator;

public class EstudianteModelImpl implements EstudianteModel {
    private File file;
    private RandomAccessFile raf;
    private String path;
    private final int SIZE = 117; 
    public EstudianteModelImpl() {
    path = "base1.dat";
    file = new File(path);
    }
    private void openRAF() throws IOException {
        System.out.println(file.exists());
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
    public Estudiante findByCarnet(String carnet) throws IOException {
    return null;
    }
    @Override
    public Estudiante[] findByLastname(String lastname) throws IOException {
    Estudiante[] arr=findAll();
    Estudiante[] founds=null;
    int l, r, key;
        System.out.println(lastname);
    Arrays.sort(arr,(Estudiante t, Estudiante t1)->t.getLastnames().compareToIgnoreCase(t1.getLastnames()));

    key=Arrays.binarySearch(arr, new Estudiante(0,null, lastname,null , 0),(Estudiante t, Estudiante t1)->t.getLastnames().compareToIgnoreCase(t1.getLastnames()));
                System.out.println(key);
    if(key>=0){
        l=r=key;
        while(--l>=0){
            if(arr[l].getLastnames().equalsIgnoreCase(lastname)){
                founds=addElement(founds, arr[l]);
            }else{
                break;
            }
        }
        founds=addElement(founds, arr[key]);//elemento del medio, en el medio
        while(++r<arr.length) {
            if (arr[r].getLastnames().equalsIgnoreCase(lastname)) {
                founds = addElement(founds, arr[r]);
            } else {
                break;
            }
        }
    }
    return founds;//si no se encuentra nada, se retornaria NULL, por valor inicializado
    }
    @Override
    public Estudiante[] findByAgeRange(int min, int max) throws IOException {
    return null;
    }
    @Override
    public int save(Estudiante t) throws IOException {
    openRAF();
    raf.seek(0);
    int n = raf.readInt();
    int k = raf.readInt();
    long pos = 8 + SIZE* n;
    raf.seek(pos);
    raf.writeInt(++k);
    raf.writeUTF(fixString(t.getCarnet(),10));
    raf.writeUTF(fixString(t.getNames(), 20));
    raf.writeUTF(fixString(t.getLastnames(), 20));
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
    public Estudiante findById(int id) throws IOException {
    Estudiante e = null;
    openRAF();
    raf.seek(0);
    int n = raf.readInt();
    if (id <= 0 || id > n) {
    return null;
    }
    long pos = 8 + (id - 1) * SIZE;
    raf.seek(pos);
    int code = raf.readInt();
    if (code == id) {
    e = new Estudiante();
    e.setId(code);
    e.setCarnet(raf.readUTF());
    e.setNames(raf.readUTF());
    e.setLastnames(raf.readUTF());
    e.setAge(raf.readInt());
    closeRAF();
    }
    closeRAF();
    return e;
    }
    @Override
    public boolean update(Estudiante t) throws IOException {
    int id=t.getId();
    openRAF();
    raf.seek(0);
    int n=raf.readInt();
    if(id<=0||id>n){
    closeRAF();
    return false;
    }
    long pos=8+(id-1)*SIZE;
    raf.seek(pos);
    int code=raf.readInt();//el id no se cambia
    if(code==id){
    raf.writeUTF(fixString(t.getCarnet(), 10));
    raf.writeUTF(fixString(t.getNames(), 20));
    raf.writeUTF(fixString(t.getLastnames(), 20));
    raf.writeInt(t.getAge());
    closeRAF();
    return true;
    }
    closeRAF();
    return false;
    }
    @Override
    public boolean delete(Estudiante t) throws IOException {
        openRAF();
        file.delete();
        closeRAF();

        /*for (Estudiante e : findAll()) {
            if (t.getId() != e.getId()) {
                save(e);
            }
        }*/
        

        return false;
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

