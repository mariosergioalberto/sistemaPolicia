package persistencia;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySqlConexion extends Conector {

    public MySqlConexion() {
    }

    public MySqlConexion(String servidor, String baseDeDatos, String usuario, String clave) {
        super(servidor, baseDeDatos, usuario, clave);
    }

    @Override
    public void conectar() throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + getServidor() + "/" + getBaseDeDatos();
            setConexion(DriverManager.getConnection(url, getUsuario(), getClave()));
            setSentencia(getConexion().createStatement());
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error SQL");
        } catch (ClassNotFoundException e) {
            System.out.println("Error de Driver o Servidor");
        }
    }
    
    public void cerrarConexion(){
        try {
            getConexion().close();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlConexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
