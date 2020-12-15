/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoImplement;
import SaveDatos.Connection;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.EstudianteModel;
import pojo.Estudiante;

/**
 *
 * @author LENOVO
 */
public class EstudianteImpl implements IDaoEstudiante{
    private EstudianteModel afModel;
    private DataOutputStream dos;
    private DataInputStream dis;
    private File file;
    private static final String FILENAME = "Estudiantes.dat";
    private List<Estudiante> est = new ArrayList<>();
       public EstudianteImpl() throws FileNotFoundException {
       load();
         }
        private void load() throws FileNotFoundException{
        file = new File(FILENAME);
        dos = new DataOutputStream(new FileOutputStream(file,true));
        dis = new DataInputStream(new FileInputStream(file));
        }
        @Override
        public Estudiante[] findByApellido(String apellidos) throws IOException {
            Estudiante[] af = null;
             Estudiante temp = null;
                if (apellidos == null) {
                return af;
            }
            while (dis.available() > 0) {
                temp = new Estudiante();
                temp.setId(dis.readInt());
                temp.setNombres(dis.readUTF());
                temp.setApellidos(dis.readUTF());
                temp.setCarnet(dis.readUTF());
                temp.setEdad(dis.readInt());

                if (temp.getApellidos().equals(apellidos)) {
                    af = addEstudiante(temp, af);
                }    
        }
        return null;
        }
        @Override
        public Estudiante[] findByNombre(String nombres) throws IOException {
         Estudiante[] af = null;
         Estudiante temp = null;
            if (nombres == null) {
                return af;
            }
            while (dis.available() > 0) {
                temp = new Estudiante();
                temp.setId(dis.readInt());
                temp.setNombres(dis.readUTF());
                temp.setApellidos(dis.readUTF());
                temp.setCarnet(dis.readUTF());
                temp.setEdad(dis.readInt());

                if (temp.getNombres().equals(nombres)) {
                    af = addEstudiante(temp, af);
                }       
        }
        return af;
        }
        @Override
        public Estudiante finbById(int id) throws IOException {
            Estudiante af = null;
            if (id < 1) {
                return af;
            }
            while (dis.available() > 0) {
                af = new Estudiante();

                af.setId(dis.readInt());
                af.setNombres(dis.readUTF());
                af.setApellidos(dis.readUTF());
                af.setCarnet(dis.readUTF());
                af.setEdad(dis.readInt());


                if (af.getId() == id) {
                    break;
                } else {
                    af = null;
                }
            }

            return af;
        }
        @Override
        public Estudiante findByCarnet(String carnet) throws IOException {
            Estudiante af = null;
            if (carnet == null) {
                return af;
            }
            while (dis.available() > 0) {
                af = new Estudiante();
                af.setId(dis.readInt());
                af.setNombres(dis.readUTF());
                af.setApellidos(dis.readUTF());
                af.setCarnet(dis.readUTF());
                af.setEdad(dis.readInt());

                if (af.getCarnet().equals(carnet)) {
                    break;
                } else {
                    af = null;
                }         
        }
        return af;
        }
        @Override
        public void save(Estudiante t) throws IOException {
            dos = new DataOutputStream(new FileOutputStream(file,true));
            if(t == null || dos == null){
             return;
             }
             dos.writeInt(t.getId());
             dos.writeUTF(t.getNombres());
             dos.writeUTF(t.getApellidos());
             dos.writeUTF(t.getCarnet());
             dos.writeInt(t.getEdad());
        }
        
        @Override
        public void update(Estudiante t) throws IOException {
            int id = 0;
            Estudiante temp[] = findAll();

            FileOutputStream fos;
            fos = new FileOutputStream(file, false);        
            dos = new DataOutputStream(fos);
            
            for (Estudiante af : temp) {
                if (af.getId() == t.getId()) {
                    writeData(t);
                    id = t.getId();
                } else {
                    writeData(af);
                }
            }
            close();
        }
        @Override
        public void delete(Estudiante t) throws IOException {
      //  est.remove(t);
            int id = 0;
            Estudiante temp[] = findAll();

            FileOutputStream fos;
            fos = new FileOutputStream(file, false);        
            dos = new DataOutputStream(fos);
            
            for (Estudiante af : temp) {
                if (af.getId() != t.getId()) {
                    writeData(af);
                }
            }
            close();
        }
        private Estudiante[] addEstudiante(Estudiante e, Estudiante[] temp){
            if(temp == null){
                temp = new Estudiante[1];
                temp[temp.length - 1] = e;
                return temp;
            }

            temp = Arrays.copyOf(temp, temp.length + 1);
            temp[temp.length - 1] = e;
            return temp;
        }
        @Override
        public Estudiante[] findAll() throws IOException {
            Estudiante[] estudiantes = null;
            Estudiante e;
            load();
            while(dis.available() > 0){
                e = new Estudiante();
                e.setId(dis.readInt());
                e.setNombres(dis.readUTF());
                e.setApellidos(dis.readUTF());
                e.setCarnet(dis.readUTF());
                e.setEdad(dis.readInt());
                estudiantes = addEstudiante(e, estudiantes);
            }

            close();
            return estudiantes;
        }
    private void writeData(Estudiante t) throws IOException {

        dos.writeInt(t.getId());
        dos.writeUTF(t.getNombres());
        dos.writeUTF(t.getApellidos());
        dos.writeUTF(t.getCarnet());
        dos.writeInt(t.getEdad());
    
    }
    public void close() throws IOException{
        if(dos != null){
             dos.close();
        }
        if(dis != null){
             dis.close();
        }
    }
}



