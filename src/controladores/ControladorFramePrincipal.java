
package controladores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import persistencia.MySqlConexion;

import vista.Principal;


public class ControladorFramePrincipal implements ActionListener {
    
  private Principal pantallaPrincipal;
  
  private ControladorFrameTipoTramite controladorFrameTipoTramite;
  private ControladorFrameListaEmpleados controladorFrameListaEmpleado;
  private ControladorFrameListaOficina controladorframelistaoficina;
  
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
           try {
               controladorFrameListaEmpleado = new ControladorFrameListaEmpleados(con);
           } catch (SQLException ex) {
               Logger.getLogger(ControladorFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ControladorFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
           }
          }
       
       if(e.getActionCommand().equals(pantallaPrincipal.MENUITEM_TRAMITES)){
           try {
               controladorFrameTipoTramite = new ControladorFrameTipoTramite(con);
           } catch (SQLException ex) {
               Logger.getLogger(ControladorFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ControladorFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
           }
           
          }
       
       if(e.getActionCommand().equals(pantallaPrincipal.MENUITEM_OFICINAS)){
           try {
               controladorframelistaoficina = new ControladorFrameListaOficina(con);
           } catch (SQLException ex) {
               Logger.getLogger(ControladorFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(ControladorFramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }  
   
}

