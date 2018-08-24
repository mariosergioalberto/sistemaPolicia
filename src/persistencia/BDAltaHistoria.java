
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Laboratio
 */
public class BDAltaHistoria {
  
    private MySqlConexion con;
    private Date fechaHora;
    
    public BDAltaHistoria(MySqlConexion con){
        this.con = con;
    }
    
    public void altaHistoria(Integer idTramite) throws SQLException, ClassNotFoundException{
       String descripcion = "Entrada de expediente";
      //  con.conectar();
        
        
        String consulta = "INSERT INTO `historia` "
                +"(`idHistoria`,`fecha`,`descripcion`,`Tramite_idTramite`) "
                + "VALUES (NULL,"
                + "NOW(),'"
                + descripcion+"',"
                + idTramite+")";
        
        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
        
            st.execute();
        
        
        con.cerrarConexion();
    }
}
