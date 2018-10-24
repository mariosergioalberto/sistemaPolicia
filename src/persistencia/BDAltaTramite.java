
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Tramite;



public class BDAltaTramite {
    
    
    private MySqlConexion con;
    
    public BDAltaTramite(MySqlConexion con){
       
        this.con=con;
    }
    
    public void altaTramite(ArrayList<Tramite> tramites,Integer idExpediente) throws SQLException, ClassNotFoundException{
        //con.conectar();
        
       for(int i=0;i<tramites.size();i++){
           
           String consulta = "INSERT INTO `tramite` "
                + "(`idTramite`,`TipoTramite_idTipoTramite`,`descripcion`,`Empleado_idEmpleado`,`Expediente_idExpediente`,`Estado_idEstado`) "
                + "VALUES (NULL,"+tramites.get(i).getTipotramite().getId()
                +",'"+tramites.get(i).getDescripcion()
                +"',"+tramites.get(i).getEmpleado().getId()
                +","+idExpediente
                +","+tramites.get(i).getEstado()
                +");";
        
           System.out.println(consulta);
        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
        st.execute();
        
       }
        
        
        
      
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
