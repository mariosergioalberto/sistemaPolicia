
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BDMostrarListaOficina;
import persistencia.MySqlConexion;
import vista.VistaAltaOficina;
import vista.VistaListaOficinas;


public class ControladorFrameListaOficina implements ActionListener{

    private VistaListaOficinas vistalistaoficinas;
    private ControladorFrameAltaOficina controladorframealtaoficina;
    private MySqlConexion con;
    private BDMostrarListaOficina BDoficina;
    
    
    public ControladorFrameListaOficina(MySqlConexion con) throws SQLException, ClassNotFoundException{
            this.vistalistaoficinas = new VistaListaOficinas();
            this.vistalistaoficinas.setControlador(this);
            this.con = con;
            
            mostrarListaOficinas(vistalistaoficinas.getJTableEmpleados());
            
            this.vistalistaoficinas.ejecutar();
            }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getActionCommand().equals(vistalistaoficinas.BTN_AGREGAR)){
          this.controladorframealtaoficina = new ControladorFrameAltaOficina(vistalistaoficinas, con);
      }
    }
    
    public void mostrarListaOficinas(JTable JTableOficinas) throws SQLException, ClassNotFoundException{
        
        this.con.conectar();
        BDoficina = new BDMostrarListaOficina();
        DefaultTableModel modelo = new DefaultTableModel();
        String titulos[] = {"Nombre","Direccion","Numero"
        };
        modelo.setColumnIdentifiers(titulos);
        JTableOficinas.setModel(modelo);
        
        String registro[] = new String[3];
        
        ResultSet oficinas = BDoficina.RSListaOficinas(con);
        
        while(oficinas.next()){
            
            registro[0] = oficinas.getString("nombre");
            registro[1] = oficinas.getString("direccion");
            modelo.addRow(registro);
            
        }
        con.cerrarConexion();
    }
    
}
