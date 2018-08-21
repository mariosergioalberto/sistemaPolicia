
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Elemento;
import modelo.Oficina;

import modelo.Persona;
import modelo.TipoElemento;
import persistencia.BDMostrarListaElementos;
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
    private Integer cantidadElementos = 1;
    private String[] registroTablaElementos = new String[4];
    private DefaultTableModel modeloTablaElementos = new DefaultTableModel();
    private String[] registroTablaTramites = new String[2];
    private DefaultTableModel modeloTablaTramites = new DefaultTableModel();
    
    public ControladorFrameAltaExpediente(MySqlConexion con) throws SQLException, ClassNotFoundException{
        this.vistaaltaexpediente = new VistaAltaExpediente();
        this.con = con;
        this.vistaaltaexpediente.setControlador(this);
        this.vistaaltaexpediente.ejecutar();
        
        obtenerOficinas();
        obtenerEmpleados();
        asignarFechaHoy();
        obtenerTiposTramites();
        obtenerElementos();
        modelarTablaElementos(vistaaltaexpediente.getTablaElementosSecuestros());
        modelarTablaTramites(vistaaltaexpediente.getTablaTiposDeTramites());
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(vistaaltaexpediente.BTN_AGREGAR_ELEMENTO)){
            agregarElemento(modeloTablaElementos);
            vistaaltaexpediente.limpiarTextoDescSecuestro();
        }
        
        if(e.getActionCommand().equals(vistaaltaexpediente.BTN_AGREGAR_TRAMITE)){
            agregarTipoTramite(modeloTablaTramites);
        }
        if(e.getActionCommand().equals(vistaaltaexpediente.BTN_ACEPTAR)){
            if(vistaaltaexpediente.getComboTipoExpediente().equals("Sumario")){
                altaNuevoSumario();
            }
        }
    }
   
    
    
    public void obtenerOficinas() throws SQLException, ClassNotFoundException{
        
        ArrayList<Oficina> oficinas = new ArrayList<Oficina>();
        
        rsListaOficinas = new BDMostrarListaOficina();
        this.con.conectar();
        ResultSet rs = rsListaOficinas.RSListaOficinas(con);
        
        while(rs.next()){
            Oficina oficina = new Oficina(rs.getInt("idOficina"),rs.getString("nombre"),rs.getString("direccion"));
            oficinas.add(oficina);
        }
     
        con.cerrarConexion();
        vistaaltaexpediente.setComboOrigenOficina(oficinas);
        vistaaltaexpediente.setComboDestinoOficina(oficinas);
        
    }
    
    public void obtenerEmpleados() throws SQLException, ClassNotFoundException{
        ArrayList<String> empleados = new ArrayList<String>();
        this.con.conectar();
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
    
    public void obtenerElementos() throws SQLException, ClassNotFoundException{
        ArrayList<TipoElemento> tiposElementos = new ArrayList<TipoElemento>();
        this.con.conectar();
        BDMostrarListaElementos rsListaElementos = new BDMostrarListaElementos(con);
        
        ResultSet rs = rsListaElementos.rsListaElementos();
        
        while(rs.next()){
            TipoElemento tipoelement = new TipoElemento(rs.getInt("idTipoElemento"),rs.getString("descripcion"));
            tiposElementos.add(tipoelement);
        }
        this.con.cerrarConexion();
        vistaaltaexpediente.setComboTipoElementosSecuestro(tiposElementos);
    }
    
  
    public void asignarFechaHoy(){
        fechahoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy"); 
        vistaaltaexpediente.setTextoFechaHoy(formateador.format(fechahoy)); 
    }
    
    public void obtenerTiposTramites() throws SQLException, ClassNotFoundException{
        ArrayList<String> tiposTramites = new ArrayList<String>();
        rslistaTiposTramites = new BDMostrarListaTiposTramites();
        this.con.conectar();
        ResultSet rs = rslistaTiposTramites.RSListaTipoTramites(con);
        while(rs.next()){
            tiposTramites.add(rs.getString("descripcion"));
        }
        
        con.cerrarConexion();
        vistaaltaexpediente.setComboTipoTramite(tiposTramites);
    }

        public void agregarElemento(DefaultTableModel modelo){
               String descTipoElemento = vistaaltaexpediente.getTextoDescSecuestro();
               String tipoElemento = vistaaltaexpediente.getComboTipoElementosSecuestro();
               String cantidad = String.valueOf(vistaaltaexpediente.getSpinnerCantidadElementos());
         
               registroTablaElementos[0] = String.valueOf(cantidadElementos++);
               registroTablaElementos[1] = tipoElemento;
               registroTablaElementos[2] = cantidad;
               registroTablaElementos[3] = descTipoElemento;
                  
               modelo.addRow(registroTablaElementos);
        }
        
        public void modelarTablaElementos(JTable jtableElementos){
            
               String titulos[] = {
                 "nro","Tipo Elemento","Cantidad","Descripción"  
               };
               modeloTablaElementos.setColumnIdentifiers(titulos);
               jtableElementos.setModel(modeloTablaElementos);
        }
        
        public void modelarTablaTramites(JTable jtableTramites){
            String titulos[] = {
                "Tipo Tramite","Descripcion Tramite"
            };
            modeloTablaTramites.setColumnIdentifiers(titulos);
            jtableTramites.setModel(modeloTablaTramites);
        }
        
        public void agregarTipoTramite(DefaultTableModel modelo){
            String tipoTramite = vistaaltaexpediente.getComboTipoTramite();
            String descripcionTramite = vistaaltaexpediente.getTextoDescripcionTramite();
            
            registroTablaTramites[0] = tipoTramite;
            registroTablaTramites[1] = descripcionTramite;
            
            modelo.addRow(registroTablaTramites);
            
        }
        
        public void altaNuevoSumario(){
            
            
            String tipoExpediente = vistaaltaexpediente.getComboTipoExpediente();
            Integer nroSumario = vistaaltaexpediente.getTextoNroSumario();
            String origen = vistaaltaexpediente.getComboOrigenOficina();
            String destino = vistaaltaexpediente.getComboDestinoOficina();
            String causa = vistaaltaexpediente.getTextoCausa();
            Integer libro = vistaaltaexpediente.getTextoNroLibro();
            Integer folio = vistaaltaexpediente.getTextoNroFolio();
            
           
            
        }
    
}
