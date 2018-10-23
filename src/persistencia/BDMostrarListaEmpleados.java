
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Persona;


public class BDMostrarListaEmpleados {
    private MySqlConexion con;
    
    public BDMostrarListaEmpleados(MySqlConexion con){
       this.con = con;
        
    }
    
    public ResultSet RSListaEmpleados() throws SQLException, ClassNotFoundException{
        
        
        ResultSet empleados = null;
        
        PreparedStatement st = con.getConexion().prepareStatement("SELECT * FROM empleado");
        empleados = st.executeQuery();
        
        return empleados;
    }
    
   
    public Persona obtenerPersona(Integer idPersona) throws SQLException{
        Persona persona = null;
        ResultSet rs = null;
        
        Statement consulta = con.getConexion().createStatement();
        rs = consulta.executeQuery("SELECT * FROM persona WHERE idPersona='" + idPersona + "'");
        
        while(rs.next()){
            persona = new Persona(rs.getString("nombre"),rs.getString("apellido"),rs.getInt("dni"),rs.getString("fecnac"),rs.getString("direccion"));
            
            
        }
        System.out.println(persona);
        return persona;
    }
    
    
   
}
