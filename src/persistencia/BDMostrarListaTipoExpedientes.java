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
public class BDMostrarListaTipoExpedientes {
    
    private MySqlConexion con;
    
    public BDMostrarListaTipoExpedientes(MySqlConexion con){
        this.con = con;
    }
    
    public ResultSet rsListaTipoExpedientes() throws SQLException{
        ResultSet listaTipoExpedientes = null;
        String consultaTiposExpedientes = "SELECT * FROM tipoexpediente";
        
        PreparedStatement tiposExpedientes = this.con.getConexion().prepareStatement(consultaTiposExpedientes);
        
        listaTipoExpedientes = tiposExpedientes.executeQuery();
        
        return listaTipoExpedientes;
    }
}
