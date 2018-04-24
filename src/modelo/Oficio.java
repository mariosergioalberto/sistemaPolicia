
package modelo;

/**
 *
 * @author Laboratio
 */
public class Oficio {
    
    private Integer nroOficio;
    private String descripcion;

    public Oficio(Integer nroOficio, String descripcion) {
        this.nroOficio = nroOficio;
        this.descripcion = descripcion;
    }

    public void setNroOficio(Integer nroOficio) {
        this.nroOficio = nroOficio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNroOficio() {
        return nroOficio;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
}
