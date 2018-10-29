
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import modelo.Elemento;
import modelo.Expediente;
import modelo.Oficina;
import modelo.TipoElemento;

/**

 * @author Sergio Alberto
 */
public class BDAltaExpediente {
    
    private TipoElemento tipoelemento;
    private MySqlConexion con;
    
    public BDAltaExpediente(MySqlConexion con){
        this.con = con;
    }
    
   
    public TipoElemento buscarTipoElemento(String descripcion) throws SQLException, ClassNotFoundException{
        ResultSet rs = null;
        con.conectar();
        
        String consulta = "SELECT * FROM TipoElemento WHERE descripcion = '"+descripcion+"'";
        
        PreparedStatement st = con.getConexion().prepareStatement(consulta);
        
        rs = st.executeQuery();
        
        while(rs.next()){
             tipoelemento = new TipoElemento(rs.getInt("idTipoElemento"), descripcion);
        }
        
        con.cerrarConexion();
       return tipoelemento;
        
    }
    
     public void altaExpediente(Expediente expediente) throws SQLException, ClassNotFoundException{
        
        //con.conectar();
        
        String consulta = "INSERT INTO `expediente` "
                +"(`idExpediente`,`expedienteNro`,`descripcion`,`Oficina_idOficina_Origen`,`Oficina_idOficina_Destino`,`libro`,`folio`,`expedienteCausa`,`expedientePlazo`,`TipoExpediente_idTipoExpediente`,`Expediente_idExpedienteEstado`,`Expediente_FechaLlegada`,`Expediente_FechaEnvio`,`Empleado_idEmpleado`) "
                + "VALUES (NULL,"
                + "'"+expediente.getNroExpediente()+"',"
                + "'"+expediente.getDescripcion()+"',"
                + expediente.getOrigenOficina().getId()+","
                + expediente.getDestinoOficina().getId()+","
                + expediente.getLibro()+","
                + expediente.getFolio()+","
                + "'"+expediente.getCausa()+"',"
                + expediente.getPlazo()+","
                + expediente.getTipoexpediente().getId()+","
                + 1+","
                + "NOW(),NULL"
                +","+expediente.getResponsable().getId()+")";
        
        
        System.out.println(consulta);
        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
        
        st.execute();
        
        //con.cerrarConexion();
    }
    
    

//    
    public void altaElementos(ArrayList<Elemento> elementos) throws SQLException, ClassNotFoundException{
       
        Integer id = null;
        ResultSet rs = null;
        //con.conectar();
        
        for(int i=0;i<elementos.size();i++){
           String consultaAltaExpediente = "INSERT INTO `elemento` "
                +"(`idElemento`,`descripcion`,`TipoElemento_idTipoElemento`) "
                + "VALUES (NULL,"
                +"'"+elementos.get(i).getDescripcion()+"',"
                
                +elementos.get(i).getTipoElemento().getId()+")";
            
            PreparedStatement st = this.con.getConexion().prepareStatement(consultaAltaExpediente);
        
            st.execute();
            
        }
        
        
       // con.cerrarConexion();
        
    }
    
    public Integer obtenerUltimoExpedienteAgregadoSesion() throws SQLException{
        
       Integer id = null;
       ResultSet rs = null;
       String consultaID;
        
       consultaID = "SELECT DISTINCT LAST_INSERT_ID() FROM expediente";
        
       PreparedStatement st1 = this.con.getConexion().prepareStatement(consultaID);
       rs = st1.executeQuery();
       
        
       while(rs.next()){
            id = rs.getInt(1);
           
        } 
         
        return id;
    }
    
 
    
   public TipoElemento obtenerTipoElemento(Integer id) throws SQLException, ClassNotFoundException{
       ////con.conectar();
       TipoElemento tipo = null;
       ResultSet rs = null;
       
       String consulta = "SELECT * FROM tipoelemento WHERE idTipoElemento = "+id;
       
       PreparedStatement st = con.getConexion().prepareStatement(consulta);
       rs = st.executeQuery();
       
       while(rs.next()){
           tipo = new TipoElemento(rs.getInt("idTipoElemento"),rs.getString("descripcion"));
       }
       
       ///con.cerrarConexion();
       return tipo;
   }
}
