
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.TipoTramite;



/**
 *
 * @author Laboratio
 */
public class BDAltaTipoTramite {
    
    private TipoTramite tipoTramite;
    private Conector con;
    
    private String consulta;
    
    public BDAltaTipoTramite(Conector con){
        this.con = con;
        
    }
    
   
    
    public void AltaTipoTramite(TipoTramite tipoTramite) throws SQLException{
        
      
        
        consulta = "INSERT INTO `tipotramite` "
                + "(`idTipoTramite,`descripcion`) "
                + "VALUES (NULL,"+tipoTramite.getDescripcion()+")";
        
        
        PreparedStatement st = con.getConexion().prepareStatement(consulta);
        st.execute();
        
       
    }
    
    
    
}
