
package modelo;

import java.util.ArrayList;

public class Nota extends Expediente{
    
    private Integer nroNota;
    

    public Nota(Integer nroNota, String descripcion, String causa, ArrayList<Elemento> elementos, ArrayList<Tramite> tramites){
               
        super(causa,descripcion,elementos,tramites);
        this.nroNota = nroNota;
        
    }

    public void setNroNota(Integer nroNota) {
        this.nroNota = nroNota;
    }

                                                     
    public Integer getNroNota() {
        return nroNota;
    }

  
    
   
}
