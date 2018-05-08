
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistencia.Conector;
import vista.VistaTipoTramites;


/**
 *
 * @author Laboratio
 */
public class ControladorFrameTipoTramite implements ActionListener{
    
   VistaTipoTramites vistaTipoTramite;
   ControladorFrameAltaTramite controladorFrameAltaTramite;
   Conector con;
    
    
    public ControladorFrameTipoTramite(Conector con){
        
        this.vistaTipoTramite = new VistaTipoTramites();
        vistaTipoTramite.setControlador(this);
        vistaTipoTramite.Ejecutar();
        this.con = con;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(vistaTipoTramite.BTN_AGREGAR)) {
            
            controladorFrameAltaTramite = new ControladorFrameAltaTramite(con);
            
        }
    }
    
}
