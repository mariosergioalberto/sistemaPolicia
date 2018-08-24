
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
import modelo.Historia;
import modelo.LineaTramite;
import modelo.Oficina;

import modelo.Persona;
import modelo.TipoElemento;
import modelo.TipoTramite;
import modelo.Tramite;
import persistencia.BDAltaExpediente;
import persistencia.BDAltaHistoria;
import persistencia.BDAltaTramite;
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
    private String[] registroTablaElementos = new String[5];
    private DefaultTableModel modeloTablaElementos = new DefaultTableModel();
    private String[] registroTablaTramites = new String[3];
    private DefaultTableModel modeloTablaTramites = new DefaultTableModel();
    
    private BDAltaExpediente BDaltaexpediente;
    private BDAltaTramite BDaltaTramite;
    private ArrayList<TipoElemento> tiposElementosTabla = new ArrayList<TipoElemento>();
    
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
        ArrayList<Empleado> empleados = new ArrayList<Empleado>();
        this.con.conectar();
        rsListaEmpleados = new BDMostrarListaEmpleados(con);
        
        ResultSet rs = rsListaEmpleados.RSListaEmpleados();
        // public Empleado(Integer legajo, String nombre, String apellido, Integer dni, String fechaNac, String direccion, String rango) {
    
        while(rs.next()){
            Persona persona = rsListaEmpleados.obtenerPersona(rs.getInt("Persona_idPersona"));
            Empleado emp = new Empleado(rs.getInt("legajo"),persona.getNombre(),persona.getApellido(),persona.getDni(),persona.getFechaNac(),persona.getDireccion(),rs.getString("rango"));
            emp.setId(rs.getInt("idEmpleado"));
            empleados.add(emp);
            System.out.println(emp);
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
        ArrayList<TipoTramite> tiposTramites = new ArrayList<TipoTramite>();
        rslistaTiposTramites = new BDMostrarListaTiposTramites();
        this.con.conectar();
        ResultSet rs = rslistaTiposTramites.RSListaTipoTramites(con);
        while(rs.next()){
            Integer id = rs.getInt("idTipoTramite");
            String descripcion = rs.getString("descripcion");
            TipoTramite tipoTramite = new TipoTramite(id,descripcion);
            tiposTramites.add(tipoTramite);
        }
        
        con.cerrarConexion();
        vistaaltaexpediente.setComboTipoTramite(tiposTramites);
    }

        public void agregarElemento(DefaultTableModel modelo){
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
        
        public void agregarTipoTramite(DefaultTableModel modelo){
            
            TipoTramite tipoTramite = vistaaltaexpediente.getComboTipoTramite();
            String descripcionTramite = vistaaltaexpediente.getTextoDescripcionTramite();
            registroTablaTramites[0] = String.valueOf(tipoTramite.getId());
            registroTablaTramites[1] = tipoTramite.getDescripcion();
            registroTablaTramites[2] = descripcionTramite;
            
            modelo.addRow(registroTablaTramites);
            
        }
        
        public void altaNuevoSumario() throws SQLException, ClassNotFoundException{
            BDaltaexpediente = new BDAltaExpediente(con);
            
            
            String tipoExpediente = vistaaltaexpediente.getComboTipoExpediente();
            Integer nroSumario = vistaaltaexpediente.getTextoNroSumario();
            Integer añoSumario = vistaaltaexpediente.getTextoAñoSumario();
            Integer nroOrigen = vistaaltaexpediente.getComboOrigenOficina().getId();
            String origen = vistaaltaexpediente.getComboOrigenOficina().getNombre();
            Integer nroDestino = vistaaltaexpediente.getComboDestinoOficina().getId();
            String destino = vistaaltaexpediente.getComboDestinoOficina().getNombre();
            String causa = vistaaltaexpediente.getTextoCausa();
            Integer libro = vistaaltaexpediente.getTextoNroLibro();
            Integer folio = vistaaltaexpediente.getTextoNroFolio();
           
            
            
            BDaltaexpediente.altaExpediente(destino, nroOrigen, nroDestino, libro, folio);
            BDaltaexpediente.altaSumario(nroSumario, añoSumario, causa);
           
            altaTramite();
            
            
            
        }
        
        public void altaTramite() throws SQLException, ClassNotFoundException{
             ArrayList<LineaTramite> lineasTramites = new ArrayList<LineaTramite>();
           
            
            Integer plazo = vistaaltaexpediente.getTextoPlazo();
            Integer idEmpleado = vistaaltaexpediente.getComboResponsable().getId();
            
            System.out.println("empleado ="+idEmpleado);
            Integer idEstado = 1;
            Integer ultimoId = BDaltaexpediente.obtenerUltimoExpediente();
            System.out.println("Ultimo id expediente:"+ultimoId);
           
            BDaltaTramite = new BDAltaTramite(con);
            BDaltaTramite.altaTramite(1, plazo, idEmpleado, idEstado, ultimoId);
           
            lineasTramites = obtenerTramitesTabla();
            
            BDaltaTramite.altaLineas(lineasTramites);
           
            Integer ultimoidTramite = BDaltaTramite.obtenerUltimoTramite();
           System.out.println("Ultimo id tramite: "+ultimoidTramite);
           BDAltaHistoria altaHistoria = new BDAltaHistoria(con);
           altaHistoria.altaHistoria(ultimoidTramite);
           
        }
        
        
        public ArrayList<Elemento> obtenerElementosTabla() throws SQLException, ClassNotFoundException{
            ArrayList<Elemento> elementos = new ArrayList<Elemento>();
            
            JTable table = vistaaltaexpediente.getTablaElementosSecuestros();
            
            TableModel tableModel = table.getModel();
            
            int cols = tableModel.getColumnCount();
            int rows = tableModel.getRowCount();
            
            for(int i=0; i<rows; i++){
                for(int j=0;j<cols; j++){
                    
                    Integer id = Integer.parseInt((String) tableModel.getValueAt(i, 4));
                    String descripcion = (String) tableModel.getValueAt(i, 3);
                    TipoElemento tipo = BDaltaexpediente.obtenerTipoElemento(id);
                    Integer cantidad = (Integer) tableModel.getValueAt(i, 2);
                    Elemento elemento = new Elemento(descripcion,tipo,cantidad);
                    elementos.add(elemento);
   
                }
            }
            
            return elementos;
        }
        
        public ArrayList<LineaTramite> obtenerTramitesTabla(){
            ArrayList<LineaTramite> lineasTramites = new ArrayList<LineaTramite>();
            
            JTable table = vistaaltaexpediente.getTablaTiposDeTramites();
            
            TableModel tableModel = table.getModel();
            
            int cols = tableModel.getColumnCount();
            int rows = tableModel.getRowCount();
            
            for(int i=0; i<rows; i++){//public Tramite(Integer numero,Integer plazo,ArrayList<TipoTramite> tramites, Historia historia) {
                for(int j=0;j<cols; j++){
                    
                    Integer idTipoTramite = Integer.parseInt((String) tableModel.getValueAt(i,0));
                    String descTipoTramite = (String) tableModel.getValueAt(i,1);
                    String descLineaTramite = (String) tableModel.getValueAt(i, 2);
                    TipoTramite tipo = new TipoTramite(idTipoTramite, descTipoTramite); // public LineaTramite(Integer id,TipoTramite tipo, String descripcion){
                    LineaTramite linea = new LineaTramite(0, tipo, descLineaTramite);
                    
                    lineasTramites.add(linea);
                   
   
                }
            }
            
            return lineasTramites;
            
        }
    
}
