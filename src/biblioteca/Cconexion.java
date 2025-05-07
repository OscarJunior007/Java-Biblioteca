package biblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Cconexion {

    private Connection conectar;
    ;
   private String cadena;

    private String user = "root";
    private String pass = "12345";
    private String bd = "BIBLIOTECA";
    private String ip = "localhost";
    private String puerto = "3306";

    public Cconexion() {
        this.conectar = null;
        this.user = "root";
        this.pass = "12345";
        this.bd = "BIBLIOTECA";
        this.ip = "localhost";
        this.puerto = "3306";
        this.cadena = "jdbc:mysql://" + ip + ":" + puerto + "/" + bd + "?useSSL=false&serverTimezone=UTC";
    }

    public Connection estableceConexcion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conectar = DriverManager.getConnection(
                    cadena, user, pass
            );
            System.out.println("Conexion exitosa!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar nada " + e, "Error", JOptionPane.INFORMATION_MESSAGE);
        }
        return conectar;
    }

    public PreparedStatement PreparedStatement(String SQLquery) throws SQLException {
        if (conectar == null) {
            estableceConexcion();
        }
        return conectar.prepareStatement(SQLquery);
    }
}
