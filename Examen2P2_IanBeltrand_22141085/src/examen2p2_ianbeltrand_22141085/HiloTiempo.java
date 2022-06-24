package examen2p2_ianbeltrand_22141085;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

public class HiloTiempo extends Thread{
    
    //Atributos
    private JLabel label;
    private boolean reproducir;
    private boolean pausar;
    
    //Constructores
    public HiloTiempo(JLabel label, boolean reproducir) {
        this.label = label;
        this.reproducir = reproducir;
        pausar = false;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public boolean isReproducir() {
        return reproducir;
    }

    public void setReproducir(boolean reproducir) {
        this.reproducir = reproducir;
    }

    public boolean isPausar() {
        return pausar;
    }

    public void setPausar(boolean pausar) {
        this.pausar = pausar;
    }
    
    public void run(){
        int segundos = 0;
        while(reproducir){
            if(pausar == false){
                label.setText("Tiempo: " + segundos + " segundos");
            }
            
            segundos = segundos + 1;
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloTiempo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
