
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Oficina;


public class BDAltaOficina {
    
    private Oficina oficina;
    private MySqlConexion con;
    
    public BDAltaOficina(MySqlConexion con){
     this.con = con;
     
    }
    
    public void AgregarOficina(Oficina oficina) throws SQLException, ClassNotFoundException{
        
        
        this.con.conectar();
        
        String consulta;
        
        consulta = "INSERT INTO `oficina` "
                +"(`idOficina`,`nombre`,`direccion`) "
                + "VALUES (NULL,"
                + "'"+oficina.getNombre()+"',"
                + "'"+oficina.getDireccion()+"')";
        
        
        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
        st.execute();
        
       
        
        con.cerrarConexion();
    }
}
