
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Persona;
import persistencia.BDMostrarListaEmpleados;

import persistencia.MySqlConexion;
import vista.VistaListaEmpleado;

public class ControladorFrameListaEmpleados implements ActionListener{
    
    private VistaListaEmpleado vistaListaEmpleado;
    private ControladorFrameAltaEmpleado controladorAltaEmpleado;
    private MySqlConexion con;
    private BDMostrarListaEmpleados bdmostrarEpleados;
    
    public ControladorFrameListaEmpleados(MySqlConexion con) throws SQLException, ClassNotFoundException{
        this.vistaListaEmpleado = new VistaListaEmpleado();
        this.vistaListaEmpleado.setControlador(this);
        this.con = con;
        listarEmpleados(vistaListaEmpleado.getJTableEmpleados());
        this.vistaListaEmpleado.ejecutar();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals(vistaListaEmpleado.BTN_AGREGAR_EMP)){
           this.controladorAltaEmpleado = new ControladorFrameAltaEmpleado(vistaListaEmpleado, con);
          System.out.println("Prueba.................................................");
        }
        
    }
    
    //======================================================================================
    // Metodo para modelar la tabla y mostrar la lista de empleados
    
    public void listarEmpleados(JTable jtableEmpleados) throws SQLException, ClassNotFoundException{
        
        this.con.conectar();
        
        bdmostrarEpleados = new BDMostrarListaEmpleados(con);
        
        
        
        DefaultTableModel modelo = new DefaultTableModel();
        String titulos[] = {"idPersona","idEmpleado","legajo","Nombre","Apellido","dni","Fecha nacim","direccion","Rango"};
        modelo.setColumnIdentifiers(titulos);
        jtableEmpleados.setModel(modelo);
        
        String registro[] = new String[9];
        
        ResultSet empleados = bdmostrarEpleados.RSListaEmpleados();
        
        while(empleados.next()){
            
            Persona persona = bdmostrarEpleados.obtenerPersona(empleados.getInt("Persona_idPersona"));
            registro[0] = String.valueOf(empleados.getInt("Persona_idPersona"));
            registro[1] = String.valueOf(empleados.getInt("idEmpleado"));
            registro[2] = String.valueOf(empleados.getInt("legajo"));
            registro[3] = persona.getNombre();
            registro[4] = persona.getApellido();
            registro[5] = String.valueOf(persona.getDni());
            registro[6] = persona.getFechaNac();
            registro[7] = persona.getDireccion();
            registro[8] = empleados.getString("rango");
            modelo.addRow(registro);
        }
        this.con.cerrarConexion();
    }
    
    
    
}
