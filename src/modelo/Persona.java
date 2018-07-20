
package modelo;

public class Persona {
    
    private String nombre;
    private String apellido;
    private Integer dni;
    private String fechaNac;
    private String direccion;
    
    public Persona(String nombre,String apellido,Integer dni,String fechaNac,String direccion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.direccion = direccion;
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

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getDireccion() {
        return direccion;
    }
    
    
    
}
