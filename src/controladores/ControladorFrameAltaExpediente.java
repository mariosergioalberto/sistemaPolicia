
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Elemento;
import modelo.Empleado;

import modelo.LineaTramite;
import modelo.Oficina;

import modelo.Persona;
import modelo.TipoElemento;
import modelo.TipoExpediente;
import modelo.TipoTramite;

import persistencia.BDAltaElementosExpediente;
import persistencia.BDAltaExpediente;
import persistencia.BDAltaHistoria;
import persistencia.BDAltaTramite;
import persistencia.BDMostrarListaElementos;
import persistencia.BDMostrarListaEmpleados;
import persistencia.BDMostrarListaOficina;
import persistencia.BDMostrarListaTipoExpedientes;
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
    private String[] registroTablaElementos = new String[5];
    private DefaultTableModel modeloTablaElementos = new DefaultTableModel();
    private String[] registroTablaTramites = new String[3];
    private DefaultTableModel modeloTablaTramites = new DefaultTableModel();
    
    private BDAltaExpediente BDaltaexpediente;
    private BDAltaTramite BDaltaTramite;
    private ArrayList<TipoElemento> tiposElementosTabla = new ArrayList<TipoElemento>();
    private Integer ultimoidexpediente;
    private BDAltaHistoria altaHistoria;
    private BDAltaElementosExpediente BDaltaelementos;
    
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
        obtenerTipoExpedientes();
        modelarTablaElementos(vistaaltaexpediente.getTablaElementosSecuestros());
        modelarTablaTramites(vistaaltaexpediente.getTablaTiposDeTramites());
        
    }
    
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(vistaaltaexpediente.BTN_AGREGAR_ELEMENTO)){
            agregarElementoTabla(modeloTablaElementos);
            vistaaltaexpediente.limpiarTextoDescSecuestro();
        }
        
        if(e.getActionCommand().equals(vistaaltaexpediente.BTN_AGREGAR_TRAMITE)){
            agregarTipoTramiteTabla(modeloTablaTramites);
        }
        if(e.getActionCommand().equals(vistaaltaexpediente.BTN_ACEPTAR)){
            if(vistaaltaexpediente.getComboTipoExpediente().equals("Sumario")){
                try {
                    altaNuevoSumario();
                } catch (SQLException ex) {
                    Logger.getLogger(ControladorFrameAltaExpediente.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ControladorFrameAltaExpediente.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
   
    
    
    public void obtenerOficinas() throws SQLException, ClassNotFoundException{
        
        ArrayList<Oficina> oficinas = new ArrayList<Oficina>();
        
        rsListaOficinas = new BDMostrarListaOficina();
        this.con.conectar();
        ResultSet rs = rsListaOficinas.RSListaOficinas(this.con);
        
        while(rs.next()){
            Oficina oficina = new Oficina(rs.getInt("idOficina"),rs.getString("nombre"),rs.getString("direccion"));
            oficinas.add(oficina);
        }
     
        this.con.cerrarConexion();
        vistaaltaexpediente.setComboOrigenOficina(oficinas);
        vistaaltaexpediente.setComboDestinoOficina(oficinas);
        
    }
    
    public void obtenerEmpleados() throws SQLException, ClassNotFoundException{
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        this.con.conectar();
        rsListaEmpleados = new BDMostrarListaEmpleados(this.con);
        
        ResultSet rs = rsListaEmpleados.RSListaEmpleados();
        // public Empleado(Integer legajo, String nombre, String apellido, Integer dni, String fechaNac, String direccion, String rango) {
    
        while(rs.next()){
            Persona persona = rsListaEmpleados.obtenerPersona(rs.getInt("Persona_idPersona"));
            Empleado emp = new Empleado(rs.getInt("legajo"),persona.getNombre(),persona.getApellido(),persona.getDni(),persona.getFechaNac(),persona.getDireccion(),rs.getString("rango"));
            emp.setId(rs.getInt("idEmpleado"));
            empleados.add(emp);
            System.out.println(emp);
        }
        this.con.cerrarConexion();
        vistaaltaexpediente.setComboResponsable(empleados);
        
    }
    
    public void obtenerElementos() throws SQLException, ClassNotFoundException{
        ArrayList<TipoElemento> tiposElementos = new ArrayList<TipoElemento>();
        this.con.conectar();
        BDMostrarListaElementos rsListaElementos = new BDMostrarListaElementos(this.con);
        
        ResultSet rs = rsListaElementos.rsListaElementos();
        
        while(rs.next()){
            TipoElemento tipoelement = new TipoElemento(rs.getInt("idTipoElemento"),rs.getString("descripcion"));
            tiposElementos.add(tipoelement);
        }
        this.con.cerrarConexion();
        vistaaltaexpediente.setComboTipoElementosSecuestro(tiposElementos);
    }
    
  public void obtenerTipoExpedientes() throws SQLException, ClassNotFoundException{
      ArrayList<TipoExpediente> tiposExpedientes = new ArrayList<TipoExpediente>();
      this.con.conectar();
      
      BDMostrarListaTipoExpedientes rsListaTipoExpedientes = new BDMostrarListaTipoExpedientes(this.con);
      
      ResultSet rs = rsListaTipoExpedientes.rsListaTipoExpedientes();
      
      while(rs.next()){
          TipoExpediente tipoexpediente = new TipoExpediente(rs.getInt("idTipoExpediente"),rs.getString("descripcion"));
          tiposExpedientes.add(tipoexpediente);
      }
      this.con.cerrarConexion();
      vistaaltaexpediente.setComboTipoExpediente(tiposExpedientes);
      
  }
    
    public void asignarFechaHoy(){
        fechahoy = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy"); 
        vistaaltaexpediente.setTextoFechaHoy(formateador.format(fechahoy)); 
    }
    
    public void obtenerTiposTramites() throws SQLException, ClassNotFoundException{
        ArrayList<TipoTramite> tiposTramites = new ArrayList<TipoTramite>();
        rslistaTiposTramites = new BDMostrarListaTiposTramites();
        this.con.conectar();
        ResultSet rs = rslistaTiposTramites.RSListaTipoTramites(this.con);
        while(rs.next()){
            Integer id = rs.getInt("idTipoTramite");
            String descripcion = rs.getString("descripcion");
            TipoTramite tipoTramite = new TipoTramite(id,descripcion);
            tiposTramites.add(tipoTramite);
        }
        
        this.con.cerrarConexion();
        vistaaltaexpediente.setComboTipoTramite(tiposTramites);
    }

        public void agregarElementoTabla(DefaultTableModel modelo){
               Integer idTipoElemento = vistaaltaexpediente.getComboTipoElementosSecuestro().getId();
               String descTipoElemento = vistaaltaexpediente.getTextoDescSecuestro();
               String tipoElemento = vistaaltaexpediente.getComboTipoElementosSecuestro().getDescripcion();
               String cantidad = String.valueOf(vistaaltaexpediente.getSpinnerCantidadElementos());
         
               registroTablaElementos[0] = String.valueOf(cantidadElementos++);
               registroTablaElementos[1] = tipoElemento;
               registroTablaElementos[2] = cantidad;
               registroTablaElementos[3] = descTipoElemento;
               registroTablaElementos[4] = String.valueOf(idTipoElemento);
                  
               modelo.addRow(registroTablaElementos);
        }
        
        public void modelarTablaElementos(JTable jtableElementos){
            
               String titulos[] = {
                 "nro","Tipo Elemento","Cantidad","Descripción","idElemento"  
               };
               modeloTablaElementos.setColumnIdentifiers(titulos);
               jtableElementos.setModel(modeloTablaElementos);
        }
        
        public void modelarTablaTramites(JTable jtableTramites){
            String titulos[] = {
                "idTipoTramite","Tipo Tramite","Descripcion Tramite"
            };
            modeloTablaTramites.setColumnIdentifiers(titulos);
            jtableTramites.setModel(modeloTablaTramites);
        }
        
        public void agregarTipoTramiteTabla(DefaultTableModel modelo){
            
            TipoTramite tipoTramite = vistaaltaexpediente.getComboTipoTramite();
            String descripcionTramite = vistaaltaexpediente.getTextoDescripcionTramite();
            registroTablaTramites[0] = String.valueOf(tipoTramite.getId());
            registroTablaTramites[1] = tipoTramite.getDescripcion();
            registroTablaTramites[2] = descripcionTramite;
            
            modelo.addRow(registroTablaTramites);
            
        }
        
        public void altaNuevoSumario() throws SQLException, ClassNotFoundException{
            BDaltaexpediente = new BDAltaExpediente(this.con);
             this.con.conectar();
            
            
            String nroExpediente = vistaaltaexpediente.getTextoNroExpediente();
            String descripcion = vistaaltaexpediente.getTextoDescripcionExpediente();
            Integer nroOrigen = vistaaltaexpediente.getComboOrigenOficina().getId();
            Integer nroDestino = vistaaltaexpediente.getComboDestinoOficina().getId();
            Integer libro = vistaaltaexpediente.getTextoNroLibro();
            Integer folio = vistaaltaexpediente.getTextoNroFolio();
            String causa = vistaaltaexpediente.getTextoCausa();
            
            Integer plazo = vistaaltaexpediente.getTextoPlazo();
            Integer tipoExpediente = vistaaltaexpediente.getComboTipoExpediente().getId();
           
            
            BDaltaexpediente.altaExpediente(descripcion, nroOrigen, nroDestino, libro, folio);
            
            ultimoidexpediente = BDaltaexpediente.obtenerUltimoExpediente();
            
            BDaltaexpediente.altaSumario(ultimoidexpediente,nroSumario, añoSumario, causa);
            
           
            
            altaTramite(ultimoidexpediente);
            
            
            altaElementosExpediente(ultimoidexpediente);// PROBLEMA CON LA CONEXION DE LA BD DICE QUE YA ESTA CERRADA Y NO SE PUEDE EJECUTAR METODOS!!!!!!!!!
           
            this.con.cerrarConexion();
        }
        
        public void altaTramite(Integer ultimoidexpediente) throws SQLException, ClassNotFoundException{
           
            ArrayList<LineaTramite> lineasTramites = new ArrayList<LineaTramite>();

            Integer plazo = vistaaltaexpediente.getTextoPlazo();
            Integer idEmpleado = vistaaltaexpediente.getComboResponsable().getId();
            
            
            Integer idEstado = 1;
          
            BDaltaTramite = new BDAltaTramite(this.con);
            
            BDaltaTramite.altaTramite(1, plazo, idEmpleado, idEstado, ultimoidexpediente);
            
            Integer ultimoidTramite = BDaltaTramite.obtenerUltimoTramite();
            
            
            lineasTramites = obtenerTramitesTabla();
            
            BDaltaTramite.altaLineas(lineasTramites,ultimoidTramite);
          
      
           altaHistoria = new BDAltaHistoria(this.con);
           altaHistoria.altaHistoria(ultimoidTramite);
           
        }
        
        public void altaElementosExpediente(Integer ultimoidexpediente) throws SQLException, ClassNotFoundException{
            
            ArrayList<Elemento> elementos = new ArrayList<Elemento>();
            
            elementos = this.obtenerElementosTabla();
            
            BDaltaelementos = new BDAltaElementosExpediente(this.con);
            BDaltaelementos.AltaElementos(ultimoidexpediente,elementos);
            
        }
        
        
        public ArrayList<Elemento> obtenerElementosTabla() throws SQLException, ClassNotFoundException{
            ArrayList<Elemento> elementos = new ArrayList<Elemento>();
            
            JTable table = vistaaltaexpediente.getTablaElementosSecuestros();
            
            TableModel tableModel = table.getModel();
            
           
            int rows = tableModel.getRowCount();
            
            for(int i=0; i<rows; i++){
                
                    
                    Integer id = Integer.parseInt((String) tableModel.getValueAt(i, 4));
                    String descripcion = (String) tableModel.getValueAt(i, 3);
                    TipoElemento tipo = BDaltaexpediente.obtenerTipoElemento(id);
                    Integer cantidad =  Integer.parseInt((String) tableModel.getValueAt(i, 2));
                    Elemento elemento = new Elemento(descripcion,tipo,cantidad);
                    elementos.add(elemento);
   
                
            }
            
            return elementos;
        }
        
        public ArrayList<LineaTramite> obtenerTramitesTabla(){
            ArrayList<LineaTramite> lineasTramites = new ArrayList<LineaTramite>();
            
            JTable table = vistaaltaexpediente.getTablaTiposDeTramites();
            
            TableModel tableModel = table.getModel();
            
           
            int rows = tableModel.getRowCount();
            
            for(int i=0; i<rows; i++){//public Tramite(Integer numero,Integer plazo,ArrayList<TipoTramite> tramites, Historia historia) {
                
                    
                    Integer idTipoTramite = Integer.parseInt((String) tableModel.getValueAt(i,0));
                    String descTipoTramite = (String) tableModel.getValueAt(i,1);
                    String descLineaTramite = (String) tableModel.getValueAt(i, 2);
                    TipoTramite tipo = new TipoTramite(idTipoTramite, descTipoTramite); // public LineaTramite(Integer id,TipoTramite tipo, String descripcion){
                    LineaTramite linea = new LineaTramite(0, tipo, descLineaTramite);
                    
                    lineasTramites.add(linea);

            }
            
            return lineasTramites;
            
        }
    
}
