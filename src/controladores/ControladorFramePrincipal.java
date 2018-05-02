
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Empleado;
import vista.AltaEmpleado;
import vista.Principal;


public class ControladorFramePrincipal implements ActionListener {
    
  private Principal pantallaPrincipal;
  private AltaEmpleado pantallaAltaEmpleado;
  
  
  public ControladorFramePrincipal(Principal pantallaPrincipal){
      
      this.pantallaPrincipal = pantallaPrincipal;
     // this.pantallaAltaEmpleado = pantallaAltaEmpleado;
  
  }
  
  

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals(pantallaPrincipal.MENUITEM_EMPLEADOS)){
           System.out.println("Prueba de evento...");
           pantallaAltaEmpleado.ejecutar();
       }
        
    }
  
  
  
    
    
    
}
