/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Sergio Alberto
 */
public class LineaTramite {
    
    private Integer id;
    private TipoTramite tipo;
    private String descripcion;
    
    public LineaTramite(Integer id,TipoTramite tipo, String descripcion){
        this.id=id;
        this.tipo=tipo;
        this.descripcion=descripcion;
    }

    public Integer getId() {
        return id;
    }

    public TipoTramite getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipo(TipoTramite tipo) {
        this.tipo = tipo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
