package examen2p2_ianbeltrand_22141085;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class HiloGrabar extends Thread{
    
    //Atributos
    private JProgressBar bar;
    private JTextArea AreaTexto;
    private boolean Grabando;
    private String Texto = "";
    
    //Constructor y mutadores

    public HiloGrabar(JProgressBar bar, JTextArea AreaTexto) {
        this.bar = bar;
        this.AreaTexto = AreaTexto;
        Grabando = true;
    }

    public JProgressBar getBar() {
        return bar;
    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }

    public boolean isGrabando() {
        return Grabando;
    }

    public void setGrabando(boolean Grabando) {
        this.Grabando = Grabando;
    }
    
    //Hilo
    public void run(){
        int largoActual = 0;
        int largoAntes = 0;
        
        while(Grabando){
            Texto = AreaTexto.getText();
            
            if(Texto != null && Texto.length() > 0){
                largoActual = Texto.length();
                
                if(largoActual != largoAntes){
                    char LastChar = Texto.charAt(Texto.length() - 1);
                    if(Character.isUpperCase(LastChar)){
                        bar.setValue(20);
                    }
                    if(Character.isLowerCase(LastChar)){
                        bar.setValue(80);

                    }

                }else{
                    bar.setValue(bar.getValue() - 1);
                }
                
                largoAntes = Texto.length();
            }
            
            try {
                Thread.sleep(3);
            } catch (InterruptedException ex) {

            }
        }
    }
}
