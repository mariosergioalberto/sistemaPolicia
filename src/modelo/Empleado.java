
package modelo;

/**
 *
 * @author Laboratio
 */
public class Empleado {
    
    private Integer legajo;
    private String nombre;
    private String apellido;
    private Integer dni; 
    private Fecha fechaNac;

    public Empleado(Integer legajo, String nombre, String apellido, Integer dni, Fecha fechaNac) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
    }

    public void setLegajo(Integer legajo) {
        this.legajo = legajo;
    }

    public Integer getLegajo() {
        return legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
    
    
    
}
