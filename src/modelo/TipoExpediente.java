
package modelo;

/**
 *
 * @author Laboratio
 */
public class TipoExpediente {
  
    private Integer id;
    private String descripcion;
    
    public TipoExpediente(){
        id = this.id;
        descripcion = this.descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
