package modelo;

import java.util.Date;

/**
 *
 * @author Laboratio
 */
public class Historia {
    private Integer id;
    private Date fechaHora;
    
    private String descripcion;

    public Historia(Date fechaHora, String descripcion) {
        this.id = id;
        this.fechaHora = fechaHora;
        
        this.descripcion = descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFechaHora(Date fecha) {
        this.fechaHora = fechaHora;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
}
