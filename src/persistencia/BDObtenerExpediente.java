/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Sergio Alberto
 */
public class BDObtenerExpediente {
    private MySqlConexion con;
    
    public BDObtenerExpediente(MySqlConexion con){
        this.con = con;
    }
    
    
       public Integer obtenerUltimoExpediente() throws SQLException{
        
       Integer id = null;
       ResultSet rs = null;
       String consultaID;
        
       consultaID = "SELECT MAX(idExpediente) AS id FROM expediente";
        
       PreparedStatement st1 = this.con.getConexion().prepareStatement(consultaID);
       rs = st1.executeQuery();
       
        
       while(rs.next()){
            id = rs.getInt(1);
           
        } 
         
        return id;
    }
    
    
}
