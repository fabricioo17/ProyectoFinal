package Piezas.Tipos;

import Piezas.Pieza;
import Piezas.movimientosReutilizables.MovimientoDiagonal;
import Tablero.Tablero;

import java.util.Scanner;

public class Alfil extends Pieza  implements MovimientoDiagonal {

    public Alfil(boolean blancas,int posicionX,int posicionY) {
        super(blancas,posicionX,posicionY);
    }


    @Override
    public boolean protegerRey(Tablero tablero, int posicionX, int posicionY, boolean blanco) {
        return false;
    }

    public  int movimientoAlfil(Scanner teclado, Tablero table) {
        System.out.println("ingrese a que fila quiere mover el alfil");
        int x = teclado.nextInt() - 1;
        System.out.println("ingrese la columna");
        int y = teclado.nextInt() - 1;

int opcion=  movimientoDiagonal(table,x,y,posicionX,posicionY);

    if (opcion==0){
        System.out.println("pieza movida");
        return 0;
    } else if (opcion==1) {
        System.out.println("pieza comida");
        return 0;
    }
    else  if (opcion==2){
        System.out.println(" no puedes comer tu propia pieza");
        return 1;
    }
    else {
        System.out.println(" error de movimiento");
        return 1;
    }
    }


    public void imprimirAlfil(){
        if (this.roja) {
            System.out.print(red + "♗" + reset);
        }
        else {
            System.out.print(green + "♗" + reset);
        }
    }

    public String mostrarDatosAlfil(){


        return toString() + ",Alfil";
    }

}