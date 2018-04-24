
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Laboratio
 */
public class Sumario {
    
    private Integer nroSumario;
    private Integer año;
    private ArrayList<Oficio> oficios = new ArrayList<Oficio>();
    private ArrayList<Nota> notas = new ArrayList<Nota>();

    public Sumario(Integer nroSumario, Integer año) {
        this.nroSumario = nroSumario;
        this.año = año;
    }

    public void setNroSumario(Integer nroSumario) {
        this.nroSumario = nroSumario;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getNroSumario() {
        return nroSumario;
    }

    public Integer getAño() {
        return año;
    }
    
    
    
}
