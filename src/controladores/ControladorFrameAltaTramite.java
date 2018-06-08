package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TipoTramite;
import modelo.Tramite;
import persistencia.BDAltaTipoTramite;
import persistencia.Conector;
import persistencia.MySqlConexion;
import vista.AltaTipoTramite;
import vista.VistaTipoTramites;

/**
 *
 * @author Laboratio
 */
public class ControladorFrameAltaTramite implements ActionListener {

    private AltaTipoTramite vistaAltaTipoTramite;
    private VistaTipoTramites vistaTipoTramites;
    private TipoTramite tramite;
    private BDAltaTipoTramite bdAltaTramite;
    private MySqlConexion con;

    public ControladorFrameAltaTramite(VistaTipoTramites vistaTipoTramites,MySqlConexion con) {

        vistaAltaTipoTramite = new AltaTipoTramite(vistaTipoTramites,true);
        vistaAltaTipoTramite.setControlador(this);
        vistaAltaTipoTramite.Ejecutar();
        this.con = con;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(vistaAltaTipoTramite.BTN_AGREGAR)) {

            try {
                Vista_a_Modelo();
                vistaAltaTipoTramite.setDescripcion("");
            } catch (SQLException ex) {
                Logger.getLogger(ControladorFrameAltaTramite.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControladorFrameAltaTramite.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        System.out.println("Tipo de tramite agregado");

    }

    //=========================================Obtener datos de la vista====================================
    public void Vista_a_Modelo() throws SQLException, ClassNotFoundException {

        this.tramite = new TipoTramite();

        tramite.setDescripcion(vistaAltaTipoTramite.getDescripcion());

        this.bdAltaTramite = new BDAltaTipoTramite(tramite);
        this.bdAltaTramite.AltaTipoTramite();

    }

}
