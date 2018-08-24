
package modelo;

/**
 *
 * @author Laboratio
 */
public class TipoTramite {
    private Integer id;
    private String descripcion;
    
    
    public TipoTramite(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
    
    public TipoTramite(){
        
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){
        return this.descripcion;
    }
    
}
