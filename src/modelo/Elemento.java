
package modelo;

/**
 *
 * @author Laboratio
 */
public class Elemento {
    private Integer numero;
    private String descripcion;
    private TipoElemento tipoElemento;
    
   

    public Elemento(Integer numero, String descripcion, TipoElemento tipoElemento) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.tipoElemento = tipoElemento;
        
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }


    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
}
