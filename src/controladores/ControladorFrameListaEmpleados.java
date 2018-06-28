
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import persistencia.MySqlConexion;
import vista.VistaListaEmpleado;

public class ControladorFrameListaEmpleados implements ActionListener{
    
    private VistaListaEmpleado vistaListaEmpleado;
    private ControladorFrameAltaEmpleado controladorAltaEmpleado;
    private MySqlConexion con;
    
    public ControladorFrameListaEmpleados(MySqlConexion con){
        this.vistaListaEmpleado = new VistaListaEmpleado();
        this.vistaListaEmpleado.setControlador(this);
        this.con = con;
        this.vistaListaEmpleado.ejecutar();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals(vistaListaEmpleado.BTN_AGREGAR_EMP)){
           this.controladorAltaEmpleado = new ControladorFrameAltaEmpleado(vistaListaEmpleado, con);
        }
        
    }
    
    //======================================================================================
    
    
    
    
}
