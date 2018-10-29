
package modelo;

/**
 *
 * @author Laboratio
 */
public class Elemento {
    private Integer id;
    private String descripcion;
    private TipoElemento tipoElemento;
   
    
   

    public Elemento(String descripcion, TipoElemento tipoElemento) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipoElemento = tipoElemento;
        
        
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

    

    
    
    public String toString(){
        return descripcion;
    }
    
}
