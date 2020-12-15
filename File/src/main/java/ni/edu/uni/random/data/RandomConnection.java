/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.random.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author yasser.membreno
 */
public class RandomConnection {
    private RandomAccessFile raf;
    private File file;
    
    public RandomConnection(File file) {
        this.file = file;
    }
    
    public RandomAccessFile getConnection() throws FileNotFoundException{
        if(raf == null){
            raf = new RandomAccessFile(file, "rw"); // "rw", "r" 
        }

        return raf;        
    }
    
    public void close() throws IOException{
        if(raf != null){
            raf.close();
            raf = null;
        }
    }
    
}
