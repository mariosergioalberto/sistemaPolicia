package modelo;

/**
 *
 * @author Laboratio
 */
public class LineaHistoria {
    private Integer id;
    private Fecha fecha;
    private String descripcion;

    public LineaHistoria(Integer id, Fecha fecha, String descripcion) {
        this.id = id;
        this.fecha = fecha;
        this.descripcion = descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
}
