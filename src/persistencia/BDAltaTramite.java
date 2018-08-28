
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.LineaTramite;


public class BDAltaTramite {
    
    
    private MySqlConexion con;
    
    public BDAltaTramite(MySqlConexion con){
       
        this.con=con;
    }
    
    public void altaTramite(Integer id,Integer plazo,Integer idempleado,Integer idEstado,Integer idExpediente) throws SQLException, ClassNotFoundException{
        //con.conectar();
        
        String consulta = "INSERT INTO `tramite` "
                + "(`idTramite`,`plazo`,`Empleado_idEmpleado`,`Expediente_idExpediente`,`Estado_idEstado`) "
                + "VALUES (NULL,"+plazo
                +","+idempleado
                +","+idExpediente
                +","+idEstado
                +");";
        
        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
        st.execute();
        
      
    }
    
    public void altaLineas( ArrayList<LineaTramite> lineasTramites, Integer ultimoId) throws SQLException, ClassNotFoundException{
        //Integer ultimoId = obtenerUltimoTramite();
       
        
        for(int i=0;i<lineasTramites.size();i++){
            
            String consulta = "INSERT INTO `lineatramite`"
                +"(`idLineaTramite`,`Tramite_idTramite`,`TipoTramite_idTipoTramite`,`descripcion`)"
                + "VALUES (NULL,"+ultimoId
                + ","+lineasTramites.get(i).getTipo().getId()
                + ",'"+lineasTramites.get(i).getDescripcion()
                +"');";
            PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
            st.execute();
        }
        
        //con.cerrarConexion();
      
    }
    
    public Integer obtenerUltimoTramite() throws SQLException{
        
        Integer id = null;
        ResultSet rs = null;
        String consultaID;
        
        consultaID = "SELECT DISTINCT LAST_INSERT_ID() FROM tramite";
        
        PreparedStatement st1 = this.con.getConexion().prepareStatement(consultaID);
        rs = st1.executeQuery();
       
        
       while(rs.next()){
            id = rs.getInt(1);
           
        } 
         
        return id;
    }
    
}
