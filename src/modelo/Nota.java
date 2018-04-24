
package modelo;

/**
 *
 * @author Laboratio
 */
public class Nota {
    
    private Integer nroNota;
    private String descripcion;

    public Nota(Integer nroNota, String descripcion) {
        this.nroNota = nroNota;
        this.descripcion = descripcion;
    }

    public void setNroNota(Integer nroNota) {
        this.nroNota = nroNota;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNroNota() {
        return nroNota;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
}
