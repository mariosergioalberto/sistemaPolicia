
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Laboratio
 */
public class Expediente {
    
    
    
    private String causa;
    private String descripcion;
    private ArrayList<Elemento> elementos = new ArrayList<Elemento>();
    private ArrayList<Tramite> tramites = new ArrayList<Tramite>();

    public Expediente(String causa, String descripcion,  ArrayList<Elemento> elementos, ArrayList<Tramite> tramites) {
        
        
        this.causa = causa;
        this.descripcion = descripcion;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
    }

    

  

    public String getCausa() {
        return causa;
    }

  
    public void setCausa(String causa) {
        this.causa = causa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTramites(ArrayList<Tramite> tramites) {
        this.tramites = tramites;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<Tramite> getTramites() {
        return tramites;
    }
    
   
    
}
