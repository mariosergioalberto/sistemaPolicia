
package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


public abstract class Conector {
    
    private String servidor = "localhost";
    private String baseDeDatos = "expedientesPolicia";
    private String usuario = "root";
    private String clave = "";
    
    private Connection conexion;
    private Statement sentencia;

    public Conector() {
    }

    public Conector(String servidor, String basededatos, String usuario, String clave) {
        this.servidor = servidor;
        this.baseDeDatos = basededatos;
        this.usuario = usuario;
        this.clave = clave;
    }

    public abstract void conectar() throws SQLException, ClassNotFoundException;

    public String getBaseDeDatos() {
        return baseDeDatos;
    }

    public void setBaseDeDatos(String baseDeDatos) {
        this.baseDeDatos = baseDeDatos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSentencia() {
        return sentencia;
    }

    public void setSentencia(Statement sentencia) {
        this.sentencia = sentencia;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
}
