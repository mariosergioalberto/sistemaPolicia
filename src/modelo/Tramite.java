
package modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Laboratio
 */
public class Tramite {
    private Integer id;
    
    private Integer plazo;
    
    private Historia historia;
    private ArrayList<TipoTramite> tramites;

    public Tramite(Integer numero,Integer plazo,ArrayList<TipoTramite> tramites, Historia historia) {
        this.id = numero;
       
        this.plazo = plazo;
       
        this.tramites = tramites;
        this.historia = historia;
    }

    public void setId(Integer numero) {
        this.id = numero;
    }

  
    public void setPlazo(Integer plazo) {
        this.plazo = plazo;
    }

  
    public void setHistoria(Historia historia) {
        this.historia = historia;
    }

    public Integer getId() {
        return id;
    }



    public Integer getPlazo() {
        return plazo;
    }


    public Historia getHistoria() {
        return historia;
    }
    
    
}
