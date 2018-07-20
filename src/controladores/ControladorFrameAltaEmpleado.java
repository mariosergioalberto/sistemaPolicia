
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Empleado;
import persistencia.BDAltaEmpleado;

import persistencia.MySqlConexion;

import vista.VistaAltaEmpleado;
import vista.VistaListaEmpleado;

public class ControladorFrameAltaEmpleado implements ActionListener{
  
    private VistaAltaEmpleado vistaAltaEmpleado;
    private Empleado empleado;
    private VistaListaEmpleado vistaListaEmpleado;
    private MySqlConexion con;
    
    private BDAltaEmpleado altaempleado;
    
    public ControladorFrameAltaEmpleado(VistaListaEmpleado vistaListaEmpleado,MySqlConexion con){
        
       this.vistaAltaEmpleado = new VistaAltaEmpleado(vistaListaEmpleado,true);
       this.vistaAltaEmpleado.setControlador(this);
       vistaAltaEmpleado.ejecutar();
       this.con = con;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(vistaAltaEmpleado.BTN_AGREGAR_EMPLEADO)) {
            try {
                AgregarEmpleado();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFrameAltaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorFrameAltaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
    }
    
    
    
    //=====================================================================
    
    public void AgregarEmpleado() throws SQLException, ClassNotFoundException{
        Integer legajo = vistaAltaEmpleado.getLegajo();
        String nombre = vistaAltaEmpleado.getNombre();
        String apellido = vistaAltaEmpleado.getApellido();
        Integer dni = vistaAltaEmpleado.getDni();
        String fechaNac = vistaAltaEmpleado.getFecha();
        String direccion = vistaAltaEmpleado.getDireccion();
        String rango = vistaAltaEmpleado.getRango();
        
        
        
        this.empleado = new Empleado(legajo,nombre,apellido,dni,fechaNac,direccion,rango);
        
        altaempleado = new BDAltaEmpleado();
        
        altaempleado.AgregarEmpleado(empleado);
        ///
    }
        
}
