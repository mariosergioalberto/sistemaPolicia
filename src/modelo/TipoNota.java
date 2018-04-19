
package modelo;

/**
 *
 * @author Laboratio
 */
public class TipoNota {
    
    private Integer nro;
    private String Descripcion;

    public TipoNota(Integer nro, String Descripcion) {
        this.nro = nro;
        this.Descripcion = Descripcion;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getNro() {
        return nro;
    }

    public String getDescripcion() {
        return Descripcion;
    }
    
    
    
}
