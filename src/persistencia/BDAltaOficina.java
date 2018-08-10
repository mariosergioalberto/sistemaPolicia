
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.Oficina;


public class BDAltaOficina {
    
    private Oficina oficina;
    private MySqlConexion con;
    
    public BDAltaOficina(Oficina oficina){
     this.oficina = oficina;
     //this.con = con;
    }
    
    public void AgregarOficina() throws SQLException, ClassNotFoundException{
        con = new MySqlConexion();
        
        con.conectar();
        
        String consulta;
        
        consulta = "INSERT INTO `oficina` "
                +"(`idOficina`,`nombre`,`direccion`) "
                + "VALUES (NULL,"
                + "'"+this.oficina.getNombre()+"',"
                + "'"+this.oficina.getDireccion()+"')";
        
        
        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
        st.execute();
        
       
        
        con.cerrarConexion();
    }
}
