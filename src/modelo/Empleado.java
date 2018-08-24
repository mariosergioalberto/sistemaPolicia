
package modelo;

/**
 *
 * @author Laboratio
 */
public class Empleado extends Persona{
    private Integer id;
    private Integer legajo;
    
    private String rango;

    public Empleado(Integer legajo, String nombre, String apellido, Integer dni, String fechaNac, String direccion, String rango) {
        super(nombre,apellido,dni,fechaNac,direccion);
        this.id = id;
        this.legajo = legajo;
        this.rango = rango;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
    
    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Integer getLegajo() {
        return legajo;
    }
    
    public String toString(){
        return super.getNombre()+" "+super.getApellido();
    }
       
}
