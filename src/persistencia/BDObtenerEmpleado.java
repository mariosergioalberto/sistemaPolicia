/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Empleado;
import modelo.Persona;

/**
 *
 * @author Laboratio
 */
public class BDObtenerEmpleado {
    private MySqlConexion con;
    
    
    public BDObtenerEmpleado(MySqlConexion con){
        this.con = con;
        
    }
    
    public Empleado obtenerEmpleado(Integer idEmpleado) throws SQLException, ClassNotFoundException{
        
       
       Empleado empleado = null;
       ResultSet rs = null;
       BDMostrarListaEmpleados obtenerpersona = new BDMostrarListaEmpleados(this.con);
       Persona persona;
       
       Statement consulta = this.con.getConexion().createStatement();
       rs = consulta.executeQuery("SELECT * FROM empleado WHERE idEmpleado='"+idEmpleado+"'");
       
       
       
       while(rs.next()){
          System.out.println(rs.getInt("Persona_idPersona")); 
          persona = obtenerpersona.obtenerPersona(rs.getInt("Persona_idPersona"));
          
           empleado = new Empleado(rs.getInt("legajo"),persona.getNombre(),persona.getApellido(),persona.getDni(),persona.getFechaNac(),persona.getDireccion(),rs.getString("rango"));
       }
      
       
        return empleado;
    }
    
    
}
