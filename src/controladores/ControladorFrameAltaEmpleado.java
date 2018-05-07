
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.AltaEmpleado;

public class ControladorFrameAltaEmpleado implements ActionListener{
  
    private AltaEmpleado vistaAltaEmpleado;
    
    
    public ControladorFrameAltaEmpleado(){
        
       this.vistaAltaEmpleado = new AltaEmpleado();
       this.vistaAltaEmpleado.setControlador(this);
       vistaAltaEmpleado.ejecutar();
        
    }

  
    @Override
    public void actionPerformed(ActionEvent e) {
       
    }
    
    
    
}
