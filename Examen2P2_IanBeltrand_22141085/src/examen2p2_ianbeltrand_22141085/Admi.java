package examen2p2_ianbeltrand_22141085;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Admi {
    
    //Atributos
    ArrayList<Canciones> canciones = new ArrayList();
    File file = new File("./Canciones.ian");
    
    //Constructores y mutadores
    public Admi(){
        
    }
    
    public ArrayList<Canciones> getCanciones() {
        return canciones;
    }

    public void setCanciones(ArrayList<Canciones> canciones) {
        this.canciones = canciones;
    }
    
    //Funciones
    public void GuardarArchivo() throws FileNotFoundException, IOException{
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        
        try{
            fw = new FileOutputStream(file);
            bw = new ObjectOutputStream(fw);
            
            for (Canciones cancion : canciones) {
                bw.writeObject(cancion);
            }
            
            bw.flush();
        }catch(Exception e){
            
        }
        
        bw.close();
        fw.close();
    }
    
    public void CargarArchivo() throws FileNotFoundException, IOException{
        try{
            canciones = new ArrayList();
            Canciones cancionTemporal;
            
            if(file.exists()){
                FileInputStream input = new FileInputStream(file);
                ObjectInputStream object = new ObjectInputStream(input);
                
                try{
                    while((cancionTemporal = (Canciones)object.readObject()) != null){
                        canciones.add(cancionTemporal);
                    }
                }catch(Exception e){
                    
                }
                
                object.close();
                input.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
