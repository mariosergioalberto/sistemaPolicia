
package persistencia;

import java.sql.SQLException;
import modelo.Empleado;


public class BDAltaEmpleado {
    private Empleado empleado;
    private MySqlConexion conec;
     private String consulta;
    public BDAltaEmpleado(Empleado empleado){
       
        this.conec = conec;
        this.empleado = empleado;
    }
    
   public void AgregarEmpleado() throws SQLException, ClassNotFoundException{
       conec = new MySqlConexion();
        
        conec.conectar();
        
        consulta = "INSERT INTO `persona` ";//*************************************COMPLETAR!!!!!!!!
                
                
        
        
   }
    
}
