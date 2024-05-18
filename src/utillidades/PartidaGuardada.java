import Piezas.Pieza;
import Piezas.Tipos.*;
import Tablero.Tablero;

import java.io.*;

public class PartidaGuardada {
    static File fichero= new File("src/PartidaGuardada.txt");
    public static void main(String[] args) {
        Tablero tablero = new Tablero();
        tablero.startTablero();
        tablero.imprimirTablero();
guardarPiezas(tablero);
cargarPartida(tablero);

    }


    public static void guardarPiezas(Tablero tablero){
        Pieza[][] table=tablero.getTable();
        for (int i=0;i<=7;i++){
            for (int j=0;j<=7;j++) {
                if (table[i][j] instanceof Caballo){
                    Caballo actual = (Caballo) table[i][j];
                String contenido = actual.mostrarDatos();
                try {
                    FileWriter sobreEscrbir = new FileWriter(fichero,true);// true append es para no machacar la informacion obtenida
                    sobreEscrbir.write(contenido + "\n");
                    sobreEscrbir.close();
                } catch (IOException ie) {
                    System.out.println("no se logro subir los datos");
                }
            }
            }
        }

    }

    public static void cargarPartida(Tablero tablero){
        Pieza [][] table= tablero.getTable();
        String tipoPieza;
        String linea;
        String [] separarLinea;
        String  [] separarDato;
        int posicionX;
        int posicionY;
        boolean roja;
        try {
            FileReader lector= new FileReader(fichero);
            BufferedReader lectura= new BufferedReader(lector);
            linea=lectura.readLine();
            while (linea !=null){
                separarLinea=linea.split(",");// separamos los datos mediante las comas
                separarDato=separarLinea[0].split("=");
                roja=Boolean.parseBoolean(separarDato[1]);
                separarDato=separarLinea[1].split("="); // ahora separamos en dos el dato de posicionX=" numero" usando como separador el "="
                posicionX=Integer.parseInt(separarDato[1]);//obtenemos la posicionX
                separarDato=separarLinea[2].split("=");
                posicionY=Integer.parseInt(separarDato[1]);//POSICIONY

                tipoPieza=separarLinea[6];//tipo dato
                //----------cargar pieza-------------//
               table[posicionX][posicionY]= cargarPieza(tipoPieza,roja,posicionX,posicionY);
               //--------------leer siguiente linea
               linea=lectura.readLine();
            }
        }
        catch (Exception e ){
            System.out.println("no hay registro de ese jugador");
        }


    }










public static Pieza cargarPieza(String tipo,boolean rojas, int possicionX, int posicionY){
    if (tipo.compareToIgnoreCase("caballo")==0){
            return  new Caballo(rojas,possicionX,posicionY);
    }
return null;
}


}
