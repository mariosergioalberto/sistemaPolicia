
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Oficina;
import persistencia.BDAltaOficina;
import persistencia.MySqlConexion;
import vista.VistaAltaOficina;
import vista.VistaListaOficinas;


public class ControladorFrameAltaOficina implements ActionListener{
    
    private Oficina oficina;
    private VistaAltaOficina vistaaltaoficina;
    private MySqlConexion con;
    private BDAltaOficina bdAltaOficina;
    
    public ControladorFrameAltaOficina(VistaListaOficinas vistalistaoficina,MySqlConexion con){
        
        this.con = con;
        this.vistaaltaoficina = new VistaAltaOficina(vistalistaoficina, true);
        this.vistaaltaoficina.setControlador(this);
        this.vistaaltaoficina.ejecutar();
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(vistaaltaoficina.BTN_AGREGAR)){
            try {
                vista_a_modelo();
                vistaaltaoficina.limpiar();
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFrameAltaOficina.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorFrameAltaOficina.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void vista_a_modelo() throws SQLException, ClassNotFoundException{
        this.oficina = new Oficina();
        
       this.oficina.setNombre(vistaaltaoficina.getNombre());
       this.oficina.setDireccion(vistaaltaoficina.getDireccion());
       
       this.bdAltaOficina = new BDAltaOficina(con);
       this.bdAltaOficina.AgregarOficina(oficina);
          
    }
    
}
