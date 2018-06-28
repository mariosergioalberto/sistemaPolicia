
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
    private String fechaNac;
    private String direccion;
    private Integer nroDireccion;
    private String rango;

    public Empleado(Integer legajo, String nombre, String apellido, Integer dni, String fechaNac, String direccion, Integer nroDireccion, String rango) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNac = fechaNac;
        this.direccion = direccion;
        this.nroDireccion = nroDireccion;
        this.rango = rango;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getNroDireccion() {
        return nroDireccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNroDireccion(Integer nroDireccion) {
        this.nroDireccion = nroDireccion;
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

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Integer getDni() {
        return dni;
    }

    public String getFechaNac() {
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

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }
       
}
