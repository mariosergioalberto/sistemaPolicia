
package controladores;

import static java.awt.SystemColor.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Empleado;
import vista.AltaEmpleado;
import vista.Principal;


public class ControladorFramePrincipal implements ActionListener {
    
  private Principal pantallaPrincipal;
  private ControladorFrameAltaEmpleado controladorAltaEmpleado;
  
  
  public ControladorFramePrincipal(){
      
      this.pantallaPrincipal = new Principal();
      pantallaPrincipal.setControlador(this);
      pantallaPrincipal.Ejecutar();
      
      
  
  }
  
  

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals(pantallaPrincipal.MENUITEM_EMPLEADOS)){
           System.out.println("Prueba de evento...");
          controladorAltaEmpleado = new ControladorFrameAltaEmpleado();
          }
       
       
        
    }  
   
}

