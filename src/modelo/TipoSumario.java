
package modelo;

/**
 *
 * @author Laboratio
 */
public class TipoSumario {
    
    private Integer nro;
    private Integer año;
    private String causa;
    private String descripcion;

    public TipoSumario(Integer nro, Integer año, String causa, String descripcion) {
        this.nro = nro;
        this.año = año;
        this.causa = causa;
        this.descripcion = descripcion;
    }

    public Integer getNro() {
        return nro;
    }

    public Integer getAño() {
        return año;
    }

    public String getCausa() {
        return causa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
