
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.TipoTramite;


public class BDAltaTipoTramite {
    
    private TipoTramite tipoTramite;
    private MySqlConexion con, conec;
    
    
    private String consulta;
    
    public BDAltaTipoTramite(TipoTramite tramite){
        this.con = con;
        this.tipoTramite = tramite;
        
    }
    
    public void AltaTipoTramite() throws SQLException, ClassNotFoundException{
        
        conec = new MySqlConexion();
        
        conec.conectar();
        
        
        consulta = "INSERT INTO `tipotramite` "
                + "(`idTipoTramite`,`descripcion`) "
                + "VALUES (NULL,'"+this.tipoTramite.getDescripcion()+"');";
        
        
        System.out.println(consulta);
        
        PreparedStatement st = this.conec.getConexion().prepareStatement(consulta);
        st.execute();
        
       
    }
   
}
