
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Laboratio
 */
public class Expediente {
    
    
    private String numero;
    private TipoExpediente tipoexpediente;
    private String descripcion;
    private ArrayList<Elemento> elementos = new ArrayList<Elemento>();
    private ArrayList<Tramite> tramites = new ArrayList<Tramite>();
    private Oficina origenOficina;
    private Oficina destinoOficina;
    private Integer libro;
    private Integer folio;
    private Integer plazo;
    private String causa;

    public Expediente(String numero,TipoExpediente tipoexpediente,String descripcion, ArrayList<Elemento> elementos, ArrayList<Tramite> tramites,Integer libro,Integer folio, Integer plazo,String causa,Oficina origenOficina,Oficina destinoOficina) {
        this.numero = numero;
        this.tipoexpediente = tipoexpediente;
        this.libro = libro;
        this.folio = folio;
        this.descripcion = descripcion;
        this.elementos = elementos;
        this.tramites = tramites;
        this.plazo = plazo;
        this.causa = causa;
        this.origenOficina = origenOficina;
        this.destinoOficina = destinoOficina;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public String getNumero() {
        return numero;
    }

    public String getCausa() {
        return causa;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public String getNroExpediente() {
        return numero;
    }

    public void setNroExpediente(String numero) {
        this.numero = numero;
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

    public void setTipoexpediente(TipoExpediente tipoexpediente) {
        this.tipoexpediente = tipoexpediente;
    }

    public TipoExpediente getTipoexpediente() {
        return tipoexpediente;
    }
   
}
