
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistencia.MySqlConexion;
import vista.VistaDetalleExpediente;

/**
 *
 * @author Laboratio
 */
public class ControladorFrameDetalleExpediente implements ActionListener{
    private MySqlConexion con;
    private VistaDetalleExpediente vistadetalleexpediente;
    
    public ControladorFrameDetalleExpediente(MySqlConexion con){
     vistadetalleexpediente = new VistaDetalleExpediente();
     this.con = con;
     vistadetalleexpediente.setControlador(this);
     vistadetalleexpediente.ejecutar();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }
    
}
