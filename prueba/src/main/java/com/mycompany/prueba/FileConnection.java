/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.prueba;

//package ni.edu.uni.archivos.datos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author yasser.membreno
 */
//Singleton
public class FileConnection {
    private FileOutputStream fos;
    private FileInputStream fis;
    private DataOutputStream dos;
    private DataInputStream dis;
    private static File file;
    private static FileConnection fileConnection = null;
    
    private FileConnection(File file){
        FileConnection.file = file;
    }
    
    public static FileConnection getInstance(File file){
        if(fileConnection == null){
            fileConnection = new FileConnection(file);
        }
        
        if(!FileConnection.file.equals(file)){
            fileConnection = new FileConnection(file);
        }
        
        return fileConnection;
    }
    
    private void openOutput() throws FileNotFoundException{
        fos = new FileOutputStream(file, true);        
        dos = new DataOutputStream(fos);        
    }
    
     private void openOutputToUpdate() throws FileNotFoundException{
        fos = new FileOutputStream(file, false);        
        dos = new DataOutputStream(fos);        
    }
    
    private void openInput() throws FileNotFoundException, IOException{
        if(!file.exists()){
            file.createNewFile();
        }
        fis = new FileInputStream(file);
        dis = new DataInputStream(fis);
    }
    
    public void close() throws IOException{
        if(dis != null){
            dis.close();
            dis = null;
        }
        
        if(dos != null){
            dos.close();
            dos = null;
        }
        
        if(fis != null){
            fis.close();
            fis = null;
        }
        
        if(fos != null){
            fos.close();
            fos = null;
        }       
        
    }
    
    public DataOutputStream getDataOutputStream() throws FileNotFoundException{
        if(dos == null){
            openOutput();
        }
        return dos;
    }
    
    public DataOutputStream getDataOutputStreamToUpdate() throws FileNotFoundException{
        if(dos == null){
            openOutputToUpdate();
        }
        return dos;
    }
    
    public DataInputStream getDataInputStream() throws FileNotFoundException, IOException{
        if(dis == null){
            openInput();
        }
        return dis;
    }
}