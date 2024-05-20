package utillidades;

import Jugadores.Jugador;
import java.io.*;
import java.util.Scanner;

public class JugadoresGuardados {
   final static File fichero = new File("src/Datos.txt");
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Jugador jugador = new Jugador(teclado);
        añadirDatos(jugador);
        leerFile();
        mostrarDatosJugador("55555");
    }

public static void añadirDatos(  Jugador jugador)  {
        if (verificarExistenciaJugador(jugador.getId())==false) {
                    try {
                        FileWriter sobreEscrbir = new FileWriter(fichero, true);// true append es para no machacar la informacion obtenida
                        sobreEscrbir.write("ID: " + jugador.getId() + " | " + "nombre: " + jugador.getNombre() + "\n");
                        sobreEscrbir.close();
                    } catch (IOException ie) {
                        System.out.println("no se logro subir los datos");
                    }
        }
else {
    System.out.println("ya existe un usuario con ese identificar");
}
    }

    public static  void leerFile(){
        String linea;
        try {
            FileReader lector= new FileReader(fichero);
            BufferedReader lectura= new BufferedReader(lector);
            linea=lectura.readLine();

            while (linea !=null){
                System.out.println(linea);
                linea=lectura.readLine();

            }
        }
        catch (Exception e ){
            System.out.println("no se puede leer los datos");
        }

    }

    public static  void mostrarDatosJugador(String ID){
        String linea;
        try {
            FileReader lector= new FileReader(fichero);
            BufferedReader lectura= new BufferedReader(lector);
            linea=lectura.readLine();

            while (linea !=null){
                if (linea.startsWith("ID: " + ID)){
                    System.out.println(linea);
                break;
                }
                linea=lectura.readLine();

            }
        }
        catch (Exception e ){
            System.out.println("no hay registro de ese jugador");
        }
    }

    public static boolean verificarExistenciaJugador(String ID){
        String linea;
        try {
            FileReader lector= new FileReader(fichero);
            BufferedReader lectura= new BufferedReader(lector);
            linea=lectura.readLine();

            while (linea !=null){
                if (linea.startsWith("ID: " + ID)){
                    return true;
                }
                linea=lectura.readLine();

            }
        }
        catch (Exception e ){
            System.out.println("no hay registro de ese jugador");
        }
        return false;
    }




}
