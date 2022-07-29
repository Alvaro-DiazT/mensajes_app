package diaz.mensajes_app;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public Connection get_connection(){
        Connection con = null; 
        try { 
            String url = "jdbc:mysql://localhost:3306/mensajes_app"; 
            String username = "root";
            String password = ""; 
            // Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection(url, username, password);
            if (con != null) { 
                System.out .println("Conectado a la base de datos MySQL mensajes_app");
            }
        } catch (SQLException ex) { 
                System.out .println("Ocurrio un error mientras que se conectaba a la base de datos MySQL");
                 ex.printStackTrace(); 
        }
        return con;
    }
    
}