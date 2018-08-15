
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import persistencia.BDMostrarListaTiposTramites;
import persistencia.Conector;
import persistencia.MySqlConexion;
import vista.VistaTipoTramites;


/**
 *
 * @author Laboratio
 */
public class ControladorFrameTipoTramite implements ActionListener{
    
   VistaTipoTramites vistaTipoTramite;
   ControladorFrameAltaTramite controladorFrameAltaTramite;
    MySqlConexion con;
    
    
    public ControladorFrameTipoTramite(MySqlConexion con) throws SQLException, ClassNotFoundException{
        
        this.vistaTipoTramite = new VistaTipoTramites();
        vistaTipoTramite.setControlador(this);
        this.con = con;
        
        mostrarListaTipoTramite(vistaTipoTramite.getTablaTipoTramite());
        
        vistaTipoTramite.Ejecutar();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(vistaTipoTramite.BTN_AGREGAR)) {
            
            controladorFrameAltaTramite = new ControladorFrameAltaTramite(vistaTipoTramite,con);
            
        }
    }
    
    
    //=====================================================================================================
    
    
    
    
    public void mostrarListaTipoTramite(JTable tablaTipoTramites) throws SQLException, ClassNotFoundException{
        this.con.conectar();
        
        BDMostrarListaTiposTramites lista = new BDMostrarListaTiposTramites();
        
        DefaultTableModel tabla = new DefaultTableModel();
        
        String titulos[] = {"Id","Descripcion"};
        
        tabla.setColumnIdentifiers(titulos);
        tablaTipoTramites.setModel(tabla);
        
        String registro[] = new String[2];
        
        ResultSet listaTiposTramites = lista.RSListaTipoTramites(con);
        
        //===================== Cambiar el ancho de la columna=======================
        TableColumnModel columnModel = tablaTipoTramites.getColumnModel();
         columnModel.getColumn(0).setPreferredWidth(50);
         columnModel.getColumn(1).setPreferredWidth(310);
        
        
        while(listaTiposTramites.next()){
            registro[0] = String.valueOf(listaTiposTramites.getInt("idTipoTramite"));
            registro[1] = listaTiposTramites.getString("descripcion");
            tabla.addRow(registro);
        }
        
       this.con.cerrarConexion();
        
    }
    
}
