
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Laboratio
 */
public class BDMostrarListaTiposTramites {
    
    
    private MySqlConexion con;
    
    public BDMostrarListaTiposTramites() throws SQLException, ClassNotFoundException{
        
    }
    
    public ResultSet RSListaTipoTramites() throws SQLException, ClassNotFoundException{
        con = new MySqlConexion();
        con.conectar();
        ResultSet tiposTramites = null;
        
        PreparedStatement st = con.getConexion().prepareStatement("SELECT * FROM tipotramite");
        tiposTramites = st.executeQuery();
        
        
        return tiposTramites;
    }

    public void cerrarCon() {
        con.cerrarConexion();
    }
    
}
