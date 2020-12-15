/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.uni.archivos.utils;

/**
 *
 * @author yasser.membreno
 */
public class StringUtil {
    
    public static String FixLengthtString(String text, int length){
        StringBuilder stringBuilder = null;
        
        if(text == null){
            stringBuilder = new StringBuilder(length);
        }else{
            stringBuilder = new StringBuilder(text);//jf;asjf;lsdkfjalkfjas;flkjsdlf ;kjsdflksdjf
            stringBuilder.setLength(length);
        }
        
        return stringBuilder.toString();
    }
}
