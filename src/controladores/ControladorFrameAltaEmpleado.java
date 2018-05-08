
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistencia.Conector;
import vista.AltaEmpleado;

public class ControladorFrameAltaEmpleado implements ActionListener{
  
    private AltaEmpleado vistaAltaEmpleado;
    
    private Conector con;
    
    public ControladorFrameAltaEmpleado(Conector con){
        
       this.vistaAltaEmpleado = new AltaEmpleado();
       this.vistaAltaEmpleado.setControlador(this);
       vistaAltaEmpleado.ejecutar();
       
       this.con = con;
        
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(vistaAltaEmpleado.BTN_AGREGAR)) {
            
        }
    }
    
    
    
}
