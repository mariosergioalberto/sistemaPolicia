
package persistencia;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Sergio Alberto
 */
public class BDAltaTramite {
    
    private Integer id;
    private Integer plazo;
    private Integer idempleado;
    private Integer idEstado;
    private Integer idExpediente;
    private MySqlConexion con;
    
    public BDAltaTramite(MySqlConexion con){
       
        this.con=con;
    }
    
    public void altaTramite(Integer id,Integer plazo,Integer idempleado,Integer idEstado,Integer idExpediente) throws SQLException, ClassNotFoundException{
        con.conectar();
        
        String consulta = "INSERT INTO `tramite` "
                + "(`idTramite`,`plazo`,`Empleado_idEmpleado`,`Expediente_nro`,`Estado_idEstado`) "
                + "VALUES (NULL,"+plazo
                +","+idempleado
                +","+idEstado
                +","+idExpediente
                +");";
        
        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
        st.execute();
        
       con.cerrarConexion();
    }
    
}
