
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Laboratio
 */
public class Expediente {
    
    
    private Integer id;
    
    private String descripcion;
    private ArrayList<Elemento> elementos = new ArrayList<Elemento>();
    private ArrayList<Tramite> tramites = new ArrayList<Tramite>();
    private Oficina origenOficina;
    private Oficina destinoOficina;
    private Integer libro;
    private Integer folio;

    public Expediente(String descripcion, ArrayList<Elemento> elementos, ArrayList<Tramite> tramites,Integer libro,Integer folio) {
        this.libro = libro;
        this.folio = folio;
        this.descripcion = descripcion;
        this.elementos = elementos;
        this.tramites = tramites;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<Elemento> getElementos() {
        return elementos;
    }

    public void setElementos(ArrayList<Elemento> elementos) {
        this.elementos = elementos;
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

    public void setOrigenOficina(Oficina origenOficina) {
        this.origenOficina = origenOficina;
    }

    public void setDestinoOficina(Oficina destinoOficina) {
        this.destinoOficina = destinoOficina;
    }

    public Oficina getOrigenOficina() {
        return origenOficina;
    }

    public Oficina getDestinoOficina() {
        return destinoOficina;
    }

    public void setLibro(Integer libro) {
        this.libro = libro;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public Integer getLibro() {
        return libro;
    }

    public Integer getFolio() {
        return folio;
    }
   
}
