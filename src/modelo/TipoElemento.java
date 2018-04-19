package modelo;

/**
 *
 * @author Laboratio
 */
public class TipoElemento {
    
  private Integer id;
  private String descripcion;

    public TipoElemento(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
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
  
  
    
}
