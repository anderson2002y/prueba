/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yasser.membreno
 */
public class ArchivosSecuencialesApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        String fileName = "hola.txt";
        int n;
        String text = "\nEstamos probando el append con el FileOutputStream!!\n";//"Probano el constructor con dos parametros y sobrescribiendo el archivo";//
        String inputText = "";
        try {
            fos = new FileOutputStream(fileName, true);
            fis = new FileInputStream(fileName);
            writeString(fos, text);
            while ((n = fis.read()) != -1) {
                inputText += (char) n;
            }

            System.out.println("Texto: \n" + inputText);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivosSecuencialesApp.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivosSecuencialesApp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                close(fos, fis);
            } catch (IOException ex) {
                Logger.getLogger(ArchivosSecuencialesApp.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public static void close(FileOutputStream fos, FileInputStream fis) throws IOException {
        if (fos != null) {
            fos.close();
        }
        if (fis != null) {
            fis.close();
        }
    }

    public static void writeString(FileOutputStream fos, String text) throws IOException {
        if (fos == null) {
            return;
        }

        if (text == null) {
            return;
        }

        fos.write(text.getBytes());
    }

}

/**
 * *
 * 1. Archivos secuenciales => Logs => FileOutputStream, FileInputStream =>
 * OutputStream, InputStream 2. Archivos aleatorios => Registros de datos. Bases
 * de datos 3. Persistencia de objetos => guardar todo el objeto dentro archivo
 * => JSON; NOSQL => MongoDB; Firebase
 */
