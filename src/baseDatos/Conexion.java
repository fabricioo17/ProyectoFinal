package baseDatos;
import javax.swing.*;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static  Connection conn=null;
    private static String login= "system";
    private  static String contraseña= "2004";
    private static String url="jdbc:oracle:thin:@localhost:1521:xe";

    public void obtenerConexion(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection(url,login,contraseña);
            conn.setAutoCommit(false);
            if (conn!=null){
                System.out.println("conexion existosa");
            }
            else {
                System.out.println("conexion erronea");
            }
        }

        catch (ClassNotFoundException  | SQLException e ){
            JOptionPane.showMessageDialog(null,"coexion erronea"+ e.getMessage());
        }

    }


public void desconexion(){
        try {
            conn.close();
        }
        catch (Exception e ){
            System.out.println("error al desconectar");
        }
}


    public static void main(String[] args) {
        Conexion c = new Conexion();
       c.obtenerConexion();
    }




}