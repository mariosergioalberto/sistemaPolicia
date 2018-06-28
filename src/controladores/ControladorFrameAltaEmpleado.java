
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Empleado;

import persistencia.MySqlConexion;

import vista.VistaAltaEmpleado;
import vista.VistaListaEmpleado;

public class ControladorFrameAltaEmpleado implements ActionListener{
  
    private VistaAltaEmpleado vistaAltaEmpleado;
    private Empleado empleado;
    private VistaListaEmpleado vistaListaEmpleado;
    private MySqlConexion con;
    
    public ControladorFrameAltaEmpleado(VistaListaEmpleado vistaListaEmpleado,MySqlConexion con){
        
       this.vistaAltaEmpleado = new VistaAltaEmpleado(vistaListaEmpleado,true);
       this.vistaAltaEmpleado.setControlador(this);
       vistaAltaEmpleado.ejecutar();
       this.con = con;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(vistaAltaEmpleado.BTN_AGREGAR_EMPLEADO)) {
           AgregarEmpleado();
        }
    }
    
    
    
    //=====================================================================
    
    public void AgregarEmpleado(){
        Integer legajo = vistaAltaEmpleado.getLegajo();
        String nombre = vistaAltaEmpleado.getNombre();
        String apellido = vistaAltaEmpleado.getApellido();
        Integer dni = vistaAltaEmpleado.getDni();
        String fechaNac = vistaAltaEmpleado.getFecha();
        String direccion = vistaAltaEmpleado.getDireccion();
        Integer numerDir = vistaAltaEmpleado.getNumerDir();
        String rango = "Agente";
        
        this.empleado = new Empleado(legajo,nombre,apellido,dni,fechaNac,direccion,numerDir,rango);
        
        
    }
        
}
