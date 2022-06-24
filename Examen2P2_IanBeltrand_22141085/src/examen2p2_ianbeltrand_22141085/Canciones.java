package examen2p2_ianbeltrand_22141085;

import java.io.Serializable;
import java.util.ArrayList;

public class Canciones implements Serializable{
    
    //Atributos
    String Nombre;
    String Categoria;
    String Letra;
    
    private static final long SerailVersionUID = 333L;
    //Constructores y Mutadores

    public Canciones(String Nombre, String Categoria, String Letra) {
        this.Nombre = Nombre;
        this.Categoria = Categoria;
        this.Letra = Letra;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public String getLetra() {
        return Letra;
    }

    public void setLetra(String Letra) {
        this.Letra = Letra;
    }

    @Override
    public String toString() {
        return Nombre;
    }
        
}
