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
 * @author Laboratio
 */
public class BDMostrarListaOficina {
    
    
    
    
    public ResultSet RSListaOficinas(MySqlConexion con) throws SQLException{
       
        ResultSet oficinas = null;
        
        PreparedStatement st = con.getConexion().prepareStatement("SELECT * FROM oficina");
        oficinas = st.executeQuery();
        
        return oficinas;
        
        
    }
}
