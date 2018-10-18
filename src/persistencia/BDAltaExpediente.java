
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Elemento;
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
    
    public void altaExpediente(String numeroExpediente, String descripcion,Integer nroOrigen, Integer nroDestino,Integer libro,Integer folio,String expedienteCausa, Integer expedientePlazo,Integer idTipoExpediente) throws SQLException, ClassNotFoundException{
        
        //con.conectar();
        
        String consulta = "INSERT INTO `expediente` "
                +"(`idExpediente`,`expedienteNro`,`descripcion`,`Oficina_idOficina_Origen`,`Oficina_idOficina_Destino`,`libro`,`folio`,`expedienteCausa`,`expedientePlazo`,`TipoExpediente_idTipoExpediente`) "
                + "VALUES (NULL,"
                + "'"+numeroExpediente+"',"
                + "'"+descripcion+"',"
                + nroOrigen+","
                + nroDestino+","
                + libro+","
                + folio+","
                + "'"+expedienteCausa+"',"
                + expedientePlazo+","
                + idTipoExpediente+","
                +")";
        
        
        System.out.println(consulta);
//        PreparedStatement st = this.con.getConexion().prepareStatement(consulta);
//        
//        st.execute();
//        
        //con.cerrarConexion();
    }
    
    
//    
//    public void altaSumario(Integer id,Integer nro, Integer año, String causa) throws SQLException, ClassNotFoundException{
//       
//       String consultaSumario;
//      
//       //con.conectar();
//       
//        //Integer id = obtenerUltimoExpediente();
//        System.out.println("Ultimo id en BDAltaExpediente"+id);
//       
//       
//        consultaSumario = "INSERT INTO `sumario` "
//                +"(`idSumario`,`nro`,`año`,`causa`,`Expediente_idExpediente`) "
//                + "VALUES (NULL,"
//                +nro+","
//                +año+","
//                +"'"+causa+"',"
//                +id+")";
//
//       PreparedStatement st2 = this.con.getConexion().prepareStatement(consultaSumario);
//       st2.execute();
//        
//      // con.cerrarConexion();
//        
//    }
//    
    public void altaElementos(ArrayList<Elemento> elementos) throws SQLException, ClassNotFoundException{
       
        Integer id = null;
        ResultSet rs = null;
        //con.conectar();
        
        for(int i=0;i<elementos.size();i++){
           String consultaAltaExpediente = "INSERT INTO `elemento` "
                +"(`idElemento`,`descripcion`,`cantidad`,`TipoElemento_idTipoElemento`) "
                + "VALUES (NULL,"
                +"'"+elementos.get(i).getDescripcion()+"',"
                +"'"+elementos.get(i).getCantidad()+","
                +elementos.get(i).getTipoElemento().getId()+")";
            
            PreparedStatement st = this.con.getConexion().prepareStatement(consultaAltaExpediente);
        
            st.execute();
            
        }
        
        
       // con.cerrarConexion();
        
    }
    
    public Integer obtenerUltimoExpediente() throws SQLException{
        
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
       con.conectar();
       TipoElemento tipo = null;
       ResultSet rs = null;
       
       String consulta = "SELECT * FROM tipoelemento WHERE idTipoElemento = "+id;
       
       PreparedStatement st = con.getConexion().prepareStatement(consulta);
       rs = st.executeQuery();
       
       while(rs.next()){
           tipo = new TipoElemento(rs.getInt("idTipoElemento"),rs.getString("descripcion"));
       }
       
       con.cerrarConexion();
       return tipo;
   }
}
