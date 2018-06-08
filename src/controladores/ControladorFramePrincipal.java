
package controladores;

import static java.awt.SystemColor.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Empleado;
import persistencia.Conector;
import persistencia.MySqlConexion;
import vista.AltaEmpleado;
import vista.Principal;


public class ControladorFramePrincipal implements ActionListener {
    
  private Principal pantallaPrincipal;
  
  private ControladorFrameTipoTramite controladorFrameTipoTramite;
  private ControladorFrameAltaEmpleado controladorAltaEmpleado;
  
  private MySqlConexion con;
  
  
  public ControladorFramePrincipal(MySqlConexion con){//El controlador se encarga de crear las pantallas y asignar el controlador
      
      this.pantallaPrincipal = new Principal();
      pantallaPrincipal.setControlador(this);
      pantallaPrincipal.Ejecutar();
      this.con = con;
  }
  
  

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getActionCommand().equals(pantallaPrincipal.MENUITEM_EMPLEADOS)){
           System.out.println("Prueba de evento...");
          controladorAltaEmpleado = new ControladorFrameAltaEmpleado(con);
          }
       
       if(e.getActionCommand().equals(pantallaPrincipal.MENUITEM_TRAMITES)){
           controladorFrameTipoTramite = new ControladorFrameTipoTramite(con);
           
          }
       
       
        
    }  
   
}

