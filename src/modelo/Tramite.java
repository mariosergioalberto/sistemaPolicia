
package modelo;

/**
 *
 * @author Laboratio
 */
public class Tramite {
    private Integer numero;
    private Integer folio;
    private Integer plazo;
    private Fecha fecha;
    private Historia historia;

    public Tramite(Integer numero, Integer folio, Integer plazo, Fecha fecha, Historia historia) {
        this.numero = numero;
        this.folio = folio;
        this.plazo = plazo;
        this.fecha = fecha;
        this.historia = historia;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setFolio(Integer folio) {
        this.folio = folio;
    }

    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public Integer getNumero() {
        return numero;
    }

    public Integer getFolio() {
        return folio;
    }

    public Integer getPlazo() {
        return plazo;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public Historia getHistoria() {
        return historia;
    }
    
    
}
