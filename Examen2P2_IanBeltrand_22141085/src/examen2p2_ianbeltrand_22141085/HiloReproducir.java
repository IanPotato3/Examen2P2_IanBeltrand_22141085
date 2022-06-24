package examen2p2_ianbeltrand_22141085;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class HiloReproducir extends Thread{
    
    //Atributos
    private JProgressBar bar;
    private JTextArea AreaTexto;
    private boolean reproducir;
    private boolean pausar;
    private Canciones song;
    
    //Constructores y Mutadores
    public HiloReproducir(JProgressBar bar, JTextArea AreaTexto, Canciones song) {
        this.bar = bar;
        this.AreaTexto = AreaTexto;
        this.song = song;
        reproducir = true;
        pausar = false;
    }

    public JProgressBar getBar() {
        return bar;
    }

    public void setBar(JProgressBar bar) {
        this.bar = bar;
    }

    public JTextArea getAreaTexto() {
        return AreaTexto;
    }

    public void setAreaTexto(JTextArea AreaTexto) {
        this.AreaTexto = AreaTexto;
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

    public Canciones getSong() {
        return song;
    }

    public void setSong(Canciones song) {
        this.song = song;
    }
    
    public void run(){
        int Contador = 0;
        int ContadorAntes = 0;
        
        while(reproducir){
            if(pausar == false){
                if(Contador != ContadorAntes){
                    char charActual = song.getLetra().charAt(Contador - 1);

                    AreaTexto.setText(AreaTexto.getText() + charActual);

                    if(Character.isUpperCase(charActual)){
                        bar.setValue(20);
                    }
                    if(Character.isLowerCase(charActual)){
                        bar.setValue(80);
                    }
                }else{
                    bar.setValue(bar.getValue()-30);
                }
                
                ContadorAntes = Contador;
                Contador = Contador + 1;
                
                if(Contador == song.getLetra().length() - 1){
                    reproducir = false;
                }
            }else{
                bar.setValue(bar.getValue()-10);
            }
            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                
            }
        }
    }
}
