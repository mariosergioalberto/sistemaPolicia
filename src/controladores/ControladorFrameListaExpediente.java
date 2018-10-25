/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import persistencia.BDMostrarListaExpedientes;
import persistencia.MySqlConexion;
import vista.VistaExpedientesLista;

/**
 *
 * @author Sergio Alberto
 */
public class ControladorFrameListaExpediente implements ActionListener{

    private VistaExpedientesLista vistaexpedientelista;
    // Controlador de la pantalla de mostrar detalle falta !!!!!!!!!!!!!!!!!!!
    private MySqlConexion con;
    private BDMostrarListaExpedientes bdmostrarlistaexpedientes;
    
    public ControladorFrameListaExpediente(MySqlConexion con) throws SQLException, ClassNotFoundException{
        this.vistaexpedientelista = new VistaExpedientesLista();
        this.vistaexpedientelista.setControlador(this);
        this.con = con;
        
        listarExpedientes(vistaexpedientelista.getTablaListaExpedientes());
        this.vistaexpedientelista.ejecutar();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
 public void listarExpedientes(JTable tablaExpedientes) throws SQLException, ClassNotFoundException{
     this.con.conectar();
     bdmostrarlistaexpedientes = new BDMostrarListaExpedientes(con);
     
     DefaultTableModel modelo = new DefaultTableModel();
     String titulos[] = {"Fecha Llegada","Tipo Expediente","Numero Exp.","Causa Expediente     ","Responsable   ","Procedencia ","Plazo"};
     modelo.setColumnIdentifiers(titulos);
     tablaExpedientes.setModel(modelo);
     
     String registro[] = new String[7];
     
     ResultSet expedientes = bdmostrarlistaexpedientes.RSListaExpedientes();
     
     while(expedientes.next()){
         registro[0] = expedientes.getString("Expediente_FechaLlegada");
         registro[1] = expedientes.getString("descripcion");
         registro[2] = expedientes.getString("expedienteNro");
         registro[3] = expedientes.getString("expedienteCausa");
         registro[4] = expedientes.getString("apellido")+" "+expedientes.getString("nombre");
         registro[5] = expedientes.getString("O.nombre");
         registro[6] = String.valueOf(expedientes.getInt("expedientePlazo"));
         modelo.addRow(registro);
         
     }
     
     this.con.cerrarConexion();
 }   
    
}
