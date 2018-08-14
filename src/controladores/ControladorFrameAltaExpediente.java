
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.LineaHistoria;
import modelo.Persona;
import persistencia.BDMostrarListaEmpleados;
import persistencia.BDMostrarListaOficina;
import persistencia.BDMostrarListaTiposTramites;
import persistencia.MySqlConexion;
import vista.VistaAltaExpediente;

/**
 *
 * @author Sergio Alberto
 */
public class ControladorFrameAltaExpediente implements ActionListener{

    private VistaAltaExpediente vistaaltaexpediente;
    private BDMostrarListaOficina rsListaOficinas;
    private BDMostrarListaEmpleados rsListaEmpleados;
    private BDMostrarListaTiposTramites rslistaTiposTramites;
    private MySqlConexion con;
    private Date fechahoy;
    public ControladorFrameAltaExpediente(MySqlConexion con) throws SQLException, ClassNotFoundException{
        this.vistaaltaexpediente = new VistaAltaExpediente();
        this.con = con;
        this.vistaaltaexpediente.ejecutar();
        
        obtenerOficinas();
        obtenerEmpleados();
        asignarFechaHoy();
        
    }
    
    
   
    
    
    public void obtenerOficinas() throws SQLException{
        System.out.println("Metodo obtener oficina funciona");
        ArrayList<String> oficinas = new ArrayList<String>();
        rsListaOficinas = new BDMostrarListaOficina();
        ResultSet rs = rsListaOficinas.RSListaOficinas(con);
        
        while(rs.next()){
            oficinas.add(rs.getString("nombre"));
        }
     
        con.cerrarConexion();
        vistaaltaexpediente.setComboOrigenOficina(oficinas);
        vistaaltaexpediente.setComboDestinoOficina(oficinas);
        
    }
    
    public void obtenerEmpleados() throws SQLException, ClassNotFoundException{
        ArrayList<String> empleados = new ArrayList<String>();
        rsListaEmpleados = new BDMostrarListaEmpleados(con);
        
        ResultSet rs = rsListaEmpleados.RSListaEmpleados();
        
        while(rs.next()){
            Persona persona = rsListaEmpleados.obtenerPersona(rs.getInt("Persona_idPersona"));
            empleados.add(persona.getNombre()+" "+persona.getApellido());
            System.out.println(persona.getNombre());
        }
        con.cerrarConexion();
        vistaaltaexpediente.setComboResponsable(empleados);
        
    }
    
    public void asignarFechaHoy(){
        fechahoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy"); 
        vistaaltaexpediente.setTextoFechaHoy(formateador.format(fechahoy)); 
    }
    
    public void obtenerTiposTramites() throws SQLException, ClassNotFoundException{
        ArrayList<String> tiposTramites = new ArrayList<String>();
        rslistaTiposTramites = new BDMostrarListaTiposTramites();
        ResultSet rs = rslistaTiposTramites.RSListaTipoTramites();
        while(rs.next()){
            tiposTramites.add(rs.getString("descripcion"));
        }
        
        con.cerrarConexion();
        vistaaltaexpediente.setComboTipoExpediente();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
