/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author guiga
 */
public class test {
    public static void main (String[] nom) throws IOException{

    
    File monfichier = new File("./src/main/webapp/images/bb");
    boolean bool = monfichier.mkdirs();

    System.out.println("bool="+bool);


    }

}
