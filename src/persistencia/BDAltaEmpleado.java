
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Empleado;


public class BDAltaEmpleado {
    private Empleado empleado;
    private MySqlConexion conec;
     
    public BDAltaEmpleado(Empleado empleado){
       
        this.conec = conec;
        this.empleado = empleado;
    }
    
   public void AgregarEmpleado() throws SQLException, ClassNotFoundException{
       
       String consultaPersona;
       String consultaEmpleado;
       String consultaID;
       
       conec = new MySqlConexion();
        
       conec.conectar();
        
       consultaPersona = "INSERT INTO `persona` "
                +"(`idPersona`,`nombre`,`apellido`,`dni`,`fecnac`,`direccion`) "
                + "VALUES (NULL,"
                + "'"+this.empleado.getNombre()+"',"
                + "'"+this.empleado.getApellido()+"',"
                + "'"+this.empleado.getDni()+"',"
                + "'"+this.empleado.getFechaNac()+"',"
                + "'"+this.empleado.getDireccion()+"')";
                System.out.println(consultaPersona);
             
       PreparedStatement st = this.conec.getConexion().prepareStatement(consultaPersona);
       st.execute();
                
        
       ResultSet rs = null;
        
       consultaID = "SELECT DISTINCT LAST_INSERT_ID() FROM persona"; //PARA OBTENER EL ULTIMO ID INSERTADO EN LA TABLA PERSONA
        
       PreparedStatement st1 = this.conec.getConexion().prepareStatement(consultaID);
       rs = st1.executeQuery();
       Integer id = null;
        
       while(rs.next()){
            id = rs.getInt(1);
           
        }

       consultaEmpleado = "INSERT INTO `empleado` "
                +"(`idEmpleado`,`legajo`,`Persona_idPersona`) "
                + "VALUES (NULL,"
                + "'"+this.empleado.getLegajo()+"',"
                +id+")";

       PreparedStatement st2 = this.conec.getConexion().prepareStatement(consultaEmpleado);
       st2.execute();
        
       conec.cerrarConexion();
 
   }
    
}
