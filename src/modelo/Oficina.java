
package modelo;

/**
 *
 * @author Laboratio
 */
public class Oficina {
    
    private Integer id;
    private String nombre;
    private String direccion;
    private Integer nroDireccion;
   
    

    public Oficina(Integer id, String nombre, String direccion, Integer nroDireccion, String descripcion, Integer tipo) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nroDireccion = nroDireccion;
       
    }
    public Oficina(){
        
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNroDireccion(Integer nroDireccion) {
        this.nroDireccion = nroDireccion;
    }

    

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getNroDireccion() {
        return nroDireccion;
    }

  
    
    
   
   
    
}
