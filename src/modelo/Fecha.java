
package modelo;

/**
 *
 * @author Laboratio
 */
public class Fecha {
    
    private Integer dia;
    private Integer mes;
    private Integer año;
    
 
  public Fecha(){
     
      dia = this.dia;
      mes = this.mes;
      año = this.año;
  }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public Integer getDia() {
        return dia;
    }

    public Integer getMes() {
        return mes;
    }

    public Integer getAño() {
        return año;
    }
  
  
    
}
