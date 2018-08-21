
package modelo;

/**
 *
 * @author Laboratio
 */
public class Elemento {
    private Integer id;
    private String descripcion;
    private TipoElemento tipoElemento;
    private Integer cantidad;
    
   

    public Elemento(Integer id, String descripcion, TipoElemento tipoElemento,Integer cantidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipoElemento = tipoElemento;
        this.cantidad = cantidad;
        
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }


    public void setId(Integer numero) {
        this.id = numero;
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

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    public String toString(){
        return descripcion;
    }
    
}
