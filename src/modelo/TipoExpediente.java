
package modelo;


public class TipoExpediente {
    
    Integer id;
    String descripcion;
    
    public TipoExpediente(Integer id,String descripcion){
        this.descripcion = descripcion;
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
     public String toString(){
      return this.descripcion;
  }
}
