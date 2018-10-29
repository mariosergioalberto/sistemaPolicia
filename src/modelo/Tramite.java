
package modelo;


/**
 * @author Laboratio
 */
public class Tramite {
    private TipoTramite tipotramite;
    private String descripcion;
    
    private Integer estado;

    public Tramite(TipoTramite tipotramite,String descripcion,Integer estado) {
        this.tipotramite = tipotramite;
        this.descripcion = descripcion;
        
        this.estado = estado;
    }

    public TipoTramite getTipotramite() {
        return tipotramite;
    }

    public String getDescripcion() {
        return descripcion;
    }

    

    public Integer getEstado() {
        return estado;
    }

    public void setTipotramite(TipoTramite tipotramite) {
        this.tipotramite = tipotramite;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    
    
}
