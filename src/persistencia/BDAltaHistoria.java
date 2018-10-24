
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.Historia;

/**
 *
 * @author Laboratio
 */
public class BDAltaHistoria {
  
    private MySqlConexion con;
 
    
    
    public BDAltaHistoria(MySqlConexion con){
        this.con = con;
    }
    
    public void altaHistoria(Integer idExpediente,Historia historia) throws SQLException, ClassNotFoundException{
       
      
        
        
        String consulta = "INSERT INTO `historia` "
                +"(`idHistoria`,`fecha`,`descripcion`,`Expediente_idExpediente`) "
                + "VALUES (NULL,"
                + "NOW(),'"
                + historia.getDescripcion()+"',"
                + idExpediente+")";
        
        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
        
            st.execute();
        
        
        
    }
}
