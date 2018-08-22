
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Laboratio
 */
public class Oficio extends Expediente{
    
    private Integer id;
    private Integer nroOficio;
    

    public Oficio(Integer nroOficio, String descripcion, ArrayList<Elemento> elementos, ArrayList<Tramite> tramites,Integer libro,Integer folio) {
        super(descripcion,elementos,tramites,libro,folio);
        this.nroOficio = nroOficio;
        
    }
    
    
    /*
    public Sumario(Integer nroSumario, Integer año,String descripcion, ArrayList<Elemento> elementos, ArrayList<Tramite> tramites,Integer libro,Integer folio) {
        
        super(descripcion,elementos,tramites,libro,folio);
        this.nroSumario = nroSumario;
        this.año = año;
    }
    */

    public void setNroOficio(Integer nroOficio) {
        this.nroOficio = nroOficio;
    }

   
    public Integer getNroOficio() {
        return nroOficio;
    }

   
    
    
    
}
