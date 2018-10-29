
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Elemento;

/**
 *
 * @author Laboratio
 */
public class BDAltaElementosExpediente {
    
    private MySqlConexion con;
    
    
    public BDAltaElementosExpediente(MySqlConexion con){
        this.con = con;
    }
    
    public void AltaElementos(Integer idultimoexpediente,ArrayList<Elemento> elementos) throws SQLException, ClassNotFoundException{
      ////////////////// con.conectar();
        
        for(int i=0;i<elementos.size();i++){
            
            String consulta = "INSERT INTO `elemento`"
                +"(`idElemento`,`descripcion`,`TipoElemento_idTipoElemento`,`Expediente_idExpediente`)"
                + "VALUES (NULL,'"+elementos.get(i).getDescripcion()
                
                + "',"+elementos.get(i).getTipoElemento().getId()
                + ","+idultimoexpediente
                +");";
            System.out.println(elementos.get(i).getTipoElemento().getId()+"---"+elementos.get(i).getDescripcion()+"---"+idultimoexpediente);
            PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
            st.execute();
        }
        
       ////////////con.cerrarConexion();
    }
    
    
}
