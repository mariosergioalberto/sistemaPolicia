
package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TipoTramite;
import modelo.Tramite;
import persistencia.BDAltaTipoTramite;
import persistencia.Conector;
import vista.AltaTipoTramite;
import vista.VistaTipoTramites;

/**
 *
 * @author Laboratio
 */
public class ControladorFrameAltaTramite implements ActionListener{

    AltaTipoTramite vistaAltaTipoTramite;
    VistaTipoTramites vistaTipoTramites;
    TipoTramite tramite;
    Conector con;
    
    public ControladorFrameAltaTramite(Conector con){
        
        vistaAltaTipoTramite = new AltaTipoTramite(vistaTipoTramites,true);
        vistaAltaTipoTramite.setControlador(this);
        vistaAltaTipoTramite.Ejecutar();
        this.con = con;
         
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(vistaAltaTipoTramite.BTN_AGREGAR)){
            Vista_a_Modelo();
            
            
            try {
                Modelo_a_BD();
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFrameAltaTramite.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("Tipo de tramite agregado");
       
    }
    
    
    //=========================================Obtener datos de la vista====================================
    
    public void Vista_a_Modelo(){
        
        tramite = new TipoTramite();
        
        tramite.setDescripcion(vistaAltaTipoTramite.getDescripcion());
        
    
    }
    
    public void Modelo_a_BD() throws SQLException{
       
        BDAltaTipoTramite bdAltaTramite = new BDAltaTipoTramite(con);
        bdAltaTramite.AltaTipoTramite(tramite);
        
    }
    
}
