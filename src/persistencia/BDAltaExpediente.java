
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.TipoElemento;

/**
 *
 * @author Sergio Alberto
 */
public class BDAltaExpediente {
    
    private TipoElemento tipoelemento;
    private MySqlConexion con;
    
   
    public TipoElemento buscarTipoElemento(String descripcion) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        con.conectar();
        
        String consulta = "SELECT * FROM TipoElemento WHERE descripcion = '"+descripcion+"'";
        
        PreparedStatement st = con.getConexion().prepareStatement(consulta);
        
        rs = st.executeQuery();
        
        while(rs.next()){
             tipoelemento = new TipoElemento(rs.getInt("idTipoElemento"), descripcion);
        }
        
        con.cerrarConexion();
       return tipoelemento;
        
    }
    
    public void altaSumario(){
        
        
        
    }
    
    
}
