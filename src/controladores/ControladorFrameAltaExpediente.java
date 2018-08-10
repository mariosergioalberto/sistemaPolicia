
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.LineaHistoria;
import persistencia.BDMostrarListaOficina;
import persistencia.MySqlConexion;
import vista.VistaAltaExpediente;

/**
 *
 * @author Sergio Alberto
 */
public class ControladorFrameAltaExpediente implements ActionListener{

    private VistaAltaExpediente vistaaltaexpediente;
    private BDMostrarListaOficina rsListaOficinas;
    
    private MySqlConexion con;
    
    public ControladorFrameAltaExpediente(MySqlConexion con) throws SQLException{
        this.vistaaltaexpediente = new VistaAltaExpediente();
        this.con = con;
        this.vistaaltaexpediente.ejecutar();
        
        obtenerOficinas();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals(e)){
           
       }
    }
    
    
    public void obtenerOficinas() throws SQLException{
        System.out.println("Metodo obtener oficina funciona");
        ArrayList<String> oficinas = new ArrayList<String>();
        rsListaOficinas = new BDMostrarListaOficina();
        
        ResultSet rs = rsListaOficinas.RSListaOficinas(con);
        
        while(rs.next()){
            oficinas.add(rs.getString("nombre"));
        }
     
        vistaaltaexpediente.setComboOrigenOficina(oficinas);
        vistaaltaexpediente.setComboDestinoOficina(oficinas);
        // REVISAR EL TEMA DE CERRAR LA CONEXION LUEGO DE LA CONEXION Y UTILIZACION
    }
    
}
