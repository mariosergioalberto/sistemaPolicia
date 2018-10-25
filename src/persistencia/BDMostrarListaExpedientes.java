
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sergio Alberto
 */
public class BDMostrarListaExpedientes {
    private MySqlConexion con;
    
    
    public BDMostrarListaExpedientes(MySqlConexion con){
        this.con = con;
    }
    
    public ResultSet RSListaExpedientes() throws SQLException{
        ResultSet expedientes = null;
        
        String consulta = "SELECT E.Expediente_FechaLlegada,TE.descripcion,E.expedienteNro,E.expedienteCausa,P.nombre,P.apellido,O.nombre,E.expedientePlazo FROM expediente E JOIN oficina O ON E.Oficina_idOficina_origen = O.idOficina\n" +
"JOIN tramite T ON E.idExpediente=T.Expediente_idExpediente\n" +
"JOIN empleado EMP ON T.Empleado_idEmpleado=EMP.idEmpleado\n" +
"JOIN persona P ON EMP.Persona_idPersona=P.idPersona\n" +
"JOIN tipoexpediente TE ON E.TipoExpediente_idTipoExpediente=TE.idTipoExpediente";
        
        PreparedStatement st = con.getConexion().prepareStatement(consulta);
        expedientes = st.executeQuery();
        
        return expedientes;
    }
    
}
