package baseDatos;

import Jugadores.Jugador;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static baseDatos.Conexion.conn;

public class mainBase { public static void main(String[] args) {

    Conexion c = new Conexion();
    c.obtenerConexion();
    mainBase nuevo = new mainBase();
    nuevo.agregarEmpleado(conn);







}


    String mensaje;
    public void agregarEmpleado(  Connection conn)
    {

       // final Jugador nuevo1= new Jugador("fabricio","1", new Date(2024,05,15));
        PreparedStatement pst=null;
        String sql="INSERT INTO tablajava (NOMBRE,JUGADORID,CUENTACREADA)"
                + "VALUES (?,?,?)";
        try {
            pst = conn.prepareStatement(sql);
          //  pst.setString(1,nuevo1.getNombre());
          //  pst.setString(2,nuevo1.getId());
           // pst.setDate(3,nuevo1.getFecha());
            mensaje="guardado";
            pst.execute();
            pst.close();
        }catch (SQLException se ){
            mensaje="error de guardado"+  se.getMessage();
        }

    }

}
