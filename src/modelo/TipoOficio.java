
package modelo;

/**
 *
 * @author Laboratio
 */
public class TipoOficio {
    
    private Integer nro;
    private String causa;
    private String descripcion;

    public TipoOficio(Integer nro, String causa, String descripcion) {
        this.nro = nro;
        this.causa = causa;
        this.descripcion = descripcion;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNro() {
        return nro;
    }

    public String getCausa() {
        return causa;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
