/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oracle
 */
public class Serializacion1 {

    /**
     * @param args the command line arguments
     */
        static File directorio = new File("/home/oracle/NetBeansProjects/serializacion1/archivos");
        static File archivo = new File("/home/oracle/NetBeansProjects/serializacion1/archivos/serial.txt");
        
    public static void main(String[] args) {
            try {
                // TODO code application logic here
                carpeta(directorio);
                archivo(archivo);
                escribir(archivo);
                lectura(archivo);
            } catch (IOException ex) {
                Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    static void carpeta(File directorio){

        if(directorio.exists())
            System.out.println("Directorio existente "+directorio.getPath());
        else
            directorio.mkdir();
    }
    
    static void archivo(File archivo) throws IOException{

        if(archivo.exists())
            System.out.println("Archivo de texto existente "+archivo.getPath());
        else
            archivo.createNewFile();
    }
    
    static void escribir(File archivo){
        try{
            ObjectOutputStream arch = new ObjectOutputStream(new FileOutputStream(archivo));
            mclase obs = new mclase("ola",-7,2.7E10);
            arch.writeObject(obs);
            System.out.println(obs.toString());
            arch.close();
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    static mclase lectura(File archivo){
        mclase ms = new mclase();
 
        try {
            ObjectInputStream lectura = new ObjectInputStream(new FileInputStream(archivo));
            ms =(mclase) lectura.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serializacion1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ms;
    }
    
    
    
    
}
