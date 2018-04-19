
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Laboratio
 */
public class Expediente {
    
    private Integer nro;
    private Integer año;
    private String causa;
    private ArrayList<Elemento> elementos = new ArrayList<Elemento>(); 

    public Expediente(Integer nro, Integer año, String causa, ArrayList<Elemento> elementos) {
        this.nro = nro;
        this.año = año;
        this.causa = causa;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    public Integer getNro() {
        return nro;
    }

    public Integer getAño() {
        return año;
    }

    public String getCausa() {
        return causa;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }
    
   
    
}
