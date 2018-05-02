
package sistemapolicia;

import controladores.ControladorFramePrincipal;
import vista.Principal;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistencia.MySqlConexion;


public class SistemaPolicia {
    
    public static void main(String[] args) {
        
        
            MySqlConexion con = new MySqlConexion();
            System.out.println("Iniciando aplicacion...");
            
            
         try {   
            con.conectar();
            
            Principal principal = new Principal();
            ControladorFramePrincipal control = new ControladorFramePrincipal(principal);
            principal.Ejecutar();
            
           
        } catch (SQLException ex) {
            Logger.getLogger(SistemaPolicia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SistemaPolicia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
