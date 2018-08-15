
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Laboratio
 */
public class BDMostrarListaElementos {
    
    private MySqlConexion con;
    
    public BDMostrarListaElementos(MySqlConexion con){
        this.con = con;
    }
    
    public ResultSet rsListaElementos() throws SQLException, ClassNotFoundException{
        
        ResultSet listaElementos = null;
        
        String consultaElementos = "SELECT * FROM tipoElemento";
        
        PreparedStatement elementos = this.con.getConexion().prepareStatement(consultaElementos);
        
        listaElementos = elementos.executeQuery();
        
        
        return listaElementos;
        
    }
    
}
